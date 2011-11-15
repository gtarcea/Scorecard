package org.fdl.lucene.analyzer;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharStream;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.MappingCharFilter;
import org.apache.lucene.analysis.NormalizeCharMap;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.Version;

public class CongressionalBillAnalyzer extends Analyzer
{
    @Override
    public TokenStream tokenStream(String fieldName, Reader reader)
    {
        NormalizeCharMap charMap = new NormalizeCharMap();
        charMap.add("/", " ");
        CharStream cstream = new MappingCharFilter(charMap, reader);
        TokenStream tokenStream = new StandardFilter(Version.LUCENE_30, new StandardTokenizer(Version.LUCENE_30, cstream));
        return new CongressionalBillFilter(new LowerCaseFilter(Version.LUCENE_30, tokenStream));
    }
}
