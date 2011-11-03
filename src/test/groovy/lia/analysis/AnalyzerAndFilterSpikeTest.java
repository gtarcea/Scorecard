package lia.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class AnalyzerAndFilterSpikeTest
{

    private static class CongressionalBillFilter extends TokenFilter
    {

        protected CongressionalBillFilter(TokenStream input)
        {
            super(input);
            // TODO Auto-generated constructor stub
        }

        @Override
        public boolean incrementToken() throws IOException
        {
            if (input.incrementToken())
            {
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
        String sentence1 = "oppose HR 503 and S 727 criminalizing transport and export of equines for slaughter for human consumption";
        Analyzer a = new CongressionalTextAnalyzer();
        AnalyzerUtils.displayTokensWithFullDetails(a, sentence1);
    }

}
