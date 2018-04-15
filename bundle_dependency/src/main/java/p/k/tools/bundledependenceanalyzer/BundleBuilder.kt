package p.k.tools.bundledependenceanalyzer

import p.k.tools.bundledependenceanalyzer.entity.Bundle
import p.k.tools.bundledependenceanalyzer.entity.Version
import java.io.File

class BundleBuilder(val file: File)
{
    fun build():Bundle
    {
        val bundle = Bundle("", "", Version(""))
        return bundle
    }

}