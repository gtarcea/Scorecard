package lia.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class AnalyzerAndFilterSpikeTest
{

    private static class CongressionalBillFilter extends TokenFilter
    {
        private final PositionIncrementAttribute posIncrAtt;
        private final OffsetAttribute offsetAttribute; //= tokenStream.getAttribute(OffsetAttribute.class);
        private final CharTermAttribute charTermAttribute; // = tokenStream.getAttribute(CharTermAttribute.class);


        protected CongressionalBillFilter(TokenStream input)
        {
            super(input);
            this.offsetAttribute = addAttribute(OffsetAttribute.class);
            this.posIncrAtt = addAttribute(PositionIncrementAttribute.class);
            this.charTermAttribute = addAttribute(CharTermAttribute.class);
        }

        @Override
        public boolean incrementToken() throws IOException
        {
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
            TokenStream s = new StandardTokenizer(Version.LUCENE_30, reader);
            TokenStream result = new CongressionalBillFilter(new LowerCaseFilter(Version.LUCENE_30, s));
            return result;
        }
    }

    @Test
    public void test() throws IOException
    {
        String sentence1 = "oppose HR 503, H.R. 504, S 727 and S. 728 criminalizing transport and export of equines for slaughter for human consumption";
        Analyzer a = new CongressionalTextAnalyzer();
        AnalyzerUtils.displayTokensWithFullDetails(a, sentence1);
    }

}
