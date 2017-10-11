package p.k.tools.datasource

import java.sql.Timestamp
import java.util.*

class LogRecord()
{

    var id: Long = 0
    var logLevel: String? = null
    var logTime: Timestamp? = null
    var threadName: String? = null
    var msg: String? = null

    init
    {
        this.id = System.currentTimeMillis() * 1000 + Random().nextInt() % 100
    }

    constructor(logTime:Timestamp,logLevel:String,threadName:String,msg:String) : this()
    {
     this.logTime=logTime
        this.logLevel=logLevel
        this.threadName=threadName
        this.msg=msg
    }

    override fun toString(): String
    {
        val sb = StringBuilder()
        sb.append("id=").append(this.id)
        sb.append(",logTime=").append(this.logTime)
        sb.append(",logLevel=").append(this.logLevel)
        sb.append(",msg=").append(this.msg)
        return sb.toString()
    }
}