package org.fdl.scorecard.map;

import org.fdl.scorecard.model.Pac;
import org.fdl.scorecard.model.Representative;
import org.ncibi.commons.loader.util.EntityMap;

public class EntityMaps
{
    public static EntityMap pacMap = FdlEntityMapFactory.of(Pac.class, "where xxx=");
    public static EntityMap representativeMap = FdlEntityMapFactory.of(Representative.class, "where xxx =");
}
