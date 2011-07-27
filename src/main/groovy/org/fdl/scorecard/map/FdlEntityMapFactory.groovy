package org.fdl.scorecard.map;

import org.ncibi.commons.loader.util.EntityMap
import org.fdl.scorecard.db.FdlDB;

class FdlEntityMapFactory
{
    private MimiEntityMapFactory() {}
    
    public static EntityMap of(Class<?> cls, String whereClause)
    {
        def table = getTableFromClass(cls)
        def sql = "select * from fdl.${table} ${whereClause}"
        def session = { FdlDB.getSession() }
        new EntityMap(sql, cls, session)    
    }
    
    private static getTableFromClass(Class<?> cls)
    {
        def clsName = cls.getName()
        def dot = clsName.lastIndexOf('.')
        return clsName[dot+1..<clsName.size()]
    }
}
