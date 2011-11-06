package org.fdl.lucene.analyzer;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class CongressionalBillFilter extends TokenFilter
{
    private final CharTermAttribute termAttribute;
    
    protected CongressionalBillFilter(TokenStream input)
    {
        super(input);
        this.termAttribute = addAttribute(CharTermAttribute.class);
    }

    @Override
    public boolean incrementToken() throws IOException
    {
        if (input.incrementToken())
        {
            CongressionalBillTokenType billTokenType = billTokenType(termAttribute.toString());
            
            if (isChamberBillToken(billTokenType))
            {
                if (!input.incrementToken())
                {
                    return false; // Not a bill and at end of input
                }
                String billIdToken = termAttribute.toString();              
                addBillToken(billTokenType, billIdToken);               
            }
            return true;
        }
        
        return false;
    }
    
    private CongressionalBillTokenType billTokenType(String token)
    {
        if (isHouseBillToken(token))
        {
            return CongressionalBillTokenType.HOUSE;
        }
        else if (isSenateBillToken(token))
        {
            return CongressionalBillTokenType.SENATE;
        }
        
        return CongressionalBillTokenType.UNKNOWN;
    }   
    
    private boolean isHouseBillToken(String token)
    {
        return "hr".equals(token) || "h.r.".equals(token);
    }
    
    private boolean isSenateBillToken(String token)
    {
        return "s".equals(token) || "s.".equals(token);
    }
    
    private boolean isChamberBillToken(CongressionalBillTokenType tokenType)
    {
        return tokenType == CongressionalBillTokenType.HOUSE || tokenType == CongressionalBillTokenType.SENATE;
    }
    
    private void addBillToken(CongressionalBillTokenType billType, String billId)
    {
        String bill = billType + billId;
        termAttribute.copyBuffer(bill.toCharArray(), 0, bill.length());
        termAttribute.setLength(bill.length());
    }
}
