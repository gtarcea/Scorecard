package org.fdl.scorecard.loader;

import org.ncibi.commons.smooks.loader.script.LoaderRunner;

public class ScorecardLoaderMain
{
    public static void main(String[] args)
    {
        System.out.println("Loading the Scorecard database...");
        LoaderRunner.runLoaders(args);
        System.out.println("\nThe Scorecard database is now ready to use.");
    }
}
