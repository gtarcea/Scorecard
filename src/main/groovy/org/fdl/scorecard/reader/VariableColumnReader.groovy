package org.fdl.scorecard.reader

import java.io.IOException;

import org.apache.commons.lang.math.NumberUtils 
import org.milyn.cdr.annotation.ConfigParam 
import org.ncibi.commons.lang.StrUtils 
import org.ncibi.commons.smooks.reader.AbstractSmooksXMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class VariableColumnReader extends AbstractSmooksXMLReader
{
    private static final def VARIABLE_COLUMN_RECORD_ELEMENT = "vcolumn-record"
    
    @ConfigParam(defaultVal = "")
    private String columnsConfig;
    
    private static class Offset
    {
        Offset(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
        
        public int start;
        public int end;
    }
    
    private Map<String, Offset> columns = new HashMap<String, Offset>();
    
    public VariableColumnReader()
    {
        super();
    }
    
    @Override 
    public void setup()
    {
        if ("" == columnsConfig)
        {
            throw new IllegalArgumentException("No columns configured");
        }
        
        for (final String column : StrUtils.COMMA_SPLITTER.omitEmptyStrings().trimResults().split(columnsConfig))
        {
            def pieces = column.split(":");
            def range = pieces[1].split("-");
            columns.put(pieces[0], new Offset(NumberUtils.toInt(range[0]), NumberUtils.toInt(range[1])))
        }
    }

    @Override
    public void processInput(InputSource input) throws IOException, SAXException
    {

    }

}
