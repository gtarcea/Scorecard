package org.fdl.scorecard.model;

public enum ContributionType
{
    INDEPENDENT_CONTRIBUTION("24A"),
    COORDINATED_EXPENDITURE("24C"),
    INDEPENDENT_EXPENDITURE("24E"),
    COMMUNICATION_COST_FOR_CANDIDATE("24F"),
    DIRECT_CONTRIBUTION("24K"),
    COMMUNICATION_COST_AGAINST_CANDIDATE("24N"),
    IN_KIND_CONTRIBUTION("24Z"),
    UNKNOWN("UNK");

    private final String transactionCode;

    private ContributionType(String transactionCode)
    {
        this.transactionCode = transactionCode;
    }

    public String transactionCode()
    {
        return this.transactionCode;
    }
    
    public static ContributionType toContributionType(String txnCode)
    {
        if (txnCode == null)
        {
            return UNKNOWN;
        }
        else
        {
            for (ContributionType ct : ContributionType.values())
            {
                if (ct.transactionCode.equals(txnCode.toUpperCase()))
                {
                    return ct;
                }
            }
            return UNKNOWN;
        }
    }
}
