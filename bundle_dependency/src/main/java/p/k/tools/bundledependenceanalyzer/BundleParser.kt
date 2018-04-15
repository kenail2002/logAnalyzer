package p.k.tools.bundledependenceanalyzer

import org.apache.commons.logging.LogFactory
import p.k.tools.bundledependenceanalyzer.entity.Bundle
import java.io.File


class BundleParser(val path: String) {
    var log = LogFactory.getLog(BundleParser::class.java)
    fun getAllBundles(): Set<Bundle> {
        var result = HashSet<Bundle>(10)
        val files = getFiles(path);
        files.forEach({ result.add(BundleBuilder(it).build()) })
        return result
    }

    fun getFiles(filePath: String): List<File> {
        val root = File(filePath)
        val filelist = ArrayList<File>(1)
        val files = root.listFiles()
        for (file in files!!) {
            if (file.isDirectory) {
                filelist.addAll(getFiles(file.absolutePath))
            } else if (file.isFile && isBundleJar(file)) {
                filelist.add(file)
            }
        }
        return filelist;
    }

    fun isBundleJar(file: File): Boolean {
        if (!file.name.endsWith(".jar")) {
            return false
        }

        return true
    }

}
