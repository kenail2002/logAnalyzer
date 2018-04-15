package p.k.tools.bundledependenceanalyzer.entity

data class VersionRange(val beginVer: String, val endVer: String) {
    fun inRange(ver: Version): Boolean {
        return false
    }
}