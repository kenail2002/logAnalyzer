package p.k.tools.bundledependenceanalyzer.entity

import org.h2.util.StringUtils

class Bundle(val groupId: String, val artifactId: String, val ver: Version) {
    override fun equals(other: kotlin.Any?): kotlin.Boolean {
        if (other is Bundle) {
            if (StringUtils.equals(this.groupId, other.groupId)
                    && StringUtils.equals(this.groupId, other.groupId) && StringUtils.equals(this.groupId, other.groupId)) {
                return true
            }
        }

        return false
    }

    override fun hashCode(): kotlin.Int {
        return this.toString().hashCode()
    }

    override fun toString(): kotlin.String {
        return "GroupId=" + groupId + ",artifactId=" + artifactId + ",version=" + ver
    }
}