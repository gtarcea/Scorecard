package org.fdl.lucene.analyzer;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeSource;
import org.apache.commons.lang.math.NumberUtils;

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
            AttributeSource.State state = captureState();
            CongressionalBillTokenType billTokenType = billTokenType(termAttribute.toString());

            if (isChamberBillToken(billTokenType))
            {
                if (!input.incrementToken())
                {
                    return false; // Not a bill and at end of input
                }
                
                String billIdToken = termAttribute.toString();
                if (isValidBillId(billIdToken))
                {
                    addBillToken(billTokenType, billIdToken);
                }
                else
                {
                    restoreState(state);
                }
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
        return tokenType == CongressionalBillTokenType.HOUSE
                || tokenType == CongressionalBillTokenType.SENATE;
    }

    private boolean isValidBillId(String billid)
    {
        return NumberUtils.isDigits(billid);
    }

    private void addBillToken(CongressionalBillTokenType billType, String billId)
    {
        String bill = billType + billId;
        termAttribute.copyBuffer(bill.toCharArray(), 0, bill.length());
        termAttribute.setLength(bill.length());
    }
}
