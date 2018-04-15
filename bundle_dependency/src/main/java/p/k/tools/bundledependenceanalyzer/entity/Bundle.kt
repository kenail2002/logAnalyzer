package p.k.tools.bundledependenceanalyzer.entity

class Bundle(val groupId: String, val artifactId: String, val ver: Version) {
    var exports: Set<Package> = HashSet<Package>(1)
    var imports: Set<ImportPackage> = HashSet<ImportPackage>(1)

}