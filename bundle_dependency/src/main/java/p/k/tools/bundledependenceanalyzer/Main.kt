package p.k.tools.bundledependenceanalyzer

import org.apache.commons.logging.LogFactory

fun main(args: Array<String>) {
    var log = LogFactory.getLog(BundleParser::class.java)

    log.info("bundle dependency analyzer is begining...")
    val bundles = BundleParser(args[0]).getAllBundles()

    val bundlesTarget = BundleParser(args[1]).getAllBundles()

    val analyzer = BundleDependencyAnalyzer(bundles, bundlesTarget)
    bundles.forEach({
        log.info(analyzer.getDependentBundles(it))
    })
    log.info("bundle dependency analyzer finished.")

}