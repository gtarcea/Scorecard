package org.ncibi;

import static org.junit.Assert.*

import org.junit.Test

class TestUriWildCard
{
    @Test
    public void testCheckIfWildcard()
    {
        String path = "file:///dir/*.xml";
        assertTrue(isWildcard(path));
        
        path = "file:///dir/stuff.txt";
        assertFalse(isWildcard(path));
    }
    
    private boolean isWildcard(String uriPath)
    {
        int lastSlash = uriPath.lastIndexOf('/');
        if (atEndOfString(lastSlash, uriPath))
        {
            return false;
        }
        
        char charPastLastSlash = uriPath.charAt(lastSlash+1);
        
        return isWildcardChar(charPastLastSlash);
    }
    
    private boolean atEndOfString(int index, String s)
    {
        if (index < s.length())
        {
            return false;
        }
        
        return true;
    }
    
    private boolean isWildcardChar(char c)
    {
        return (c == '*' || c == '?');
    }
}
