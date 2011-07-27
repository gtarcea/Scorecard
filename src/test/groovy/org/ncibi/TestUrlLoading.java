package org.ncibi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import org.junit.Test;

import java.io.File;

public class TestUrlLoading
{
    @Test
    public void testUrlLoading() throws Exception
    {
        System.out.println("testUrlLoading");
        openUrl("http://thomas.loc.gov/home/gpoxmlc112/h87_ih.xml");
        System.out.println("\n\nDone.");
    }
    
    @Test
    public void testFileAsUrl() throws Exception
    {
        System.out.println("testFileAsUrl");
        openUrl("file:///Users/gtarcea/GIT/Scorecard/src/main/resources/h87_ih.xml");
        System.out.println("\n\nDone.");
    }
    
    private void openUrl(String url) throws Exception
    {
        URL bill = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(bill.openStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);

        in.close();
    }
    
    @Test
    public void testOpenUriOfDirectory() throws Exception
    {
        openUriAsFile("file:///Users/gtarcea/GIT/Scorecard/src/main/resources");
    }
    
    private void openUriAsFile(String uri) throws Exception
    {
        URI dir = new URI(uri);
        File f = new File(dir);
        for (String filename : f.list())
        {
            System.out.println("filename = " + filename);
        }
    }
}