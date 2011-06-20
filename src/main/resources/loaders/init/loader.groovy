import org.ncibi.commons.smooks.loader.script.LoaderScript
import org.ncibi.commons.smooks.loader.script.LoaderUtil


/*
 * Initializes the database.
 */

def script = { loader, loaderDir, config ->
    /*
     * Do nothing - only loads the database.
     */
}

LoaderScript startLoader = new LoaderScript(loader, script)
startLoader.runLoad(initDb)