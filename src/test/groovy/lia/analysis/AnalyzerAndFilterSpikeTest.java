package lia.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharStream;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.MappingCharFilter;
import org.apache.lucene.analysis.NormalizeCharMap;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class AnalyzerAndFilterSpikeTest
{

    private static class CongressionalBillFilter extends TokenFilter
    {
        //private final PositionIncrementAttribute posIncrAtt;
        //private final OffsetAttribute offsetAttribute; //= tokenStream.getAttribute(OffsetAttribute.class);
        private final CharTermAttribute charTermAttribute; // = tokenStream.getAttribute(CharTermAttribute.class);
        private boolean stateSaved = false;

        protected CongressionalBillFilter(TokenStream input)
        {
            super(input);
            //this.offsetAttribute = addAttribute(OffsetAttribute.class);
            //this.posIncrAtt = addAttribute(PositionIncrementAttribute.class);
            this.charTermAttribute = addAttribute(CharTermAttribute.class);
        }

        @Override
        public boolean incrementToken() throws IOException
        {
//            if (stateSaved == false)
//            {
//                input.incrementToken();
//                AttributeSource.State state = captureState();
//                String tokenStr = charTermAttribute.toString();
//                System.out.println("tokenStr = " + tokenStr);
//                System.out.println("incrementToken a second time");
//                input.incrementToken();
//                tokenStr = charTermAttribute.toString();
//                System.out.println("tokenStr = " + tokenStr);
//                System.out.println("restoreState");
//                restoreState(state);
//                tokenStr = charTermAttribute.toString();
//                System.out.println("tokenStr = " + tokenStr);
//                stateSaved = true;
//                return true;
//            }
            
            if (input.incrementToken())
            {
                String tokenStr = charTermAttribute.toString();
                System.out.println("tokenStr = " + tokenStr);
                if ("hr".equals(tokenStr) || "s".equals(tokenStr))
                {
                    input.incrementToken();
                    String tokenStr2 = charTermAttribute.toString();
                    System.out.println("tokenStr2 = " + tokenStr2);
                    String bill = tokenStr + tokenStr2;
                    charTermAttribute.copyBuffer(bill.toCharArray(), 0, bill.length());
                    charTermAttribute.setLength(bill.length());
                }
                return true;
            }
            
            return false;
        }

    }

    private static class CongressionalTextAnalyzer extends Analyzer
    {
        public TokenStream tokenStream(String fieldName, Reader reader)
        {
            NormalizeCharMap charMap = new NormalizeCharMap();
            charMap.add("/", " ");
            CharStream cstream = new MappingCharFilter(charMap, reader);
            //TokenStream s = new StandardTokenizer(Version.LUCENE_30, reader);
            TokenStream s = new StandardTokenizer(Version.LUCENE_30, cstream);
            //TokenStream tokenStream = new MappingCharFilter(charMap);
            TokenStream tokenStream = new StandardFilter(Version.LUCENE_30, s);
            TokenStream result = new CongressionalBillFilter(new LowerCaseFilter(Version.LUCENE_30, tokenStream));
            return result;
        }
    }

    @Test
    public void test() throws IOException
    {
        String sentence1 = "oppose HR 503, H.R. 504, (HR 505), H.R.506, HR507, S 727, S. 728, S.729, (S.730), S731 HR 1293/S. 1338 criminalizing transport and export of equines for slaughter for human consumption";
        Analyzer a = new CongressionalTextAnalyzer();
        AnalyzerUtils.displayTokensWithFullDetails(a, sentence1);
        
        //a = new StandardAnalyzer(Version.LUCENE_30);
        //AnalyzerUtils.displayTokensWithFullDetails(a, sentence1);
    }

}
