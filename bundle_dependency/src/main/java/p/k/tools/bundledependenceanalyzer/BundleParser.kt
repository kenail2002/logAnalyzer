package p.k.tools.bundledependenceanalyzer

import org.apache.commons.logging.LogFactory
import p.k.tools.bundledependenceanalyzer.entity.Bundle

class BundleParser(val path:String)
{
    var log = LogFactory.getLog(BundleParser::class.java)
    fun getAllBundles( ):Set<Bundle>
    {

        var result=HashSet<Bundle>(10)

        return result
    }

}
