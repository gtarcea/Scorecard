package org.fdl.db;

import java.util.LinkedList;
import java.util.List;

import org.ncibi.commons.config.ProjectConfiguration;
import org.ncibi.commons.exception.ConstructorCalledError;

/**
 * Utility functions for a PersistenceUnit.
 * 
 * @author gtarcea
 */
public final class PersistenceUnits
{
    private PersistenceUnits()
    {
        throw new ConstructorCalledError(this.getClass());
    }

    /**
     * Reads the list of jpa persistence units that the project supports from a
     * configuration file.
     * 
     * @return A list of the names of the persistence units supported.
     */
    public static List<String> getConfigured()
    {
        final String punits = ProjectConfiguration.getProjectProperty("persistence-units");
        final List<String> punitList = new LinkedList<String>();

        for (final String punit : punits.split(","))
        {
            punitList.add(punit.trim());
        }
        return punitList;
    }
}
