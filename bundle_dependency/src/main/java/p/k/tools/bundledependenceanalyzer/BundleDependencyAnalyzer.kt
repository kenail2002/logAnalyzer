package p.k.tools.bundledependenceanalyzer

import p.k.tools.bundledependenceanalyzer.entity.Bundle
import java.util.concurrent.ConcurrentHashMap

object BundleDependentCache {
    val cache = ConcurrentHashMap<Bundle, Set<Bundle>>()
    fun addDependentLevel(rootBundle: Bundle, dependencied: Set<Bundle>) {
        cache.putIfAbsent(rootBundle, dependencied)
    }

    fun getDependencies(rootBundle: Bundle): Set<Bundle>? {
        return cache.get(rootBundle)
    }
}

class BundleDependencyAnalyzer(val baseBundles: Set<Bundle>, val targetBundles: Set<Bundle>) {
    fun getDependentBundles(rootBundle:Bundle): Set<Bundle> {
        val dBundles = HashSet<Bundle>()
        return dBundles
    }
}