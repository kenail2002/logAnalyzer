package p.k.tools.h2db

import java.util.*

class LogRecord()
{


    var id: Long = 0
    var username: String? = null
    var password: String? = null
    var age: Int = 0

    init
    {
        this.id = System.currentTimeMillis() * 1000 + Random().nextInt() % 100
    }

    constructor(us1: String, pd: String, age1: Int) : this()
    {
        this.username = us1
        this.password = pd
        this.age = age1
    }

    override fun toString(): String
    {
        val sb = StringBuilder()
        sb.append("id=").append(this.id)
        sb.append(",username=").append(this.username)
        sb.append(",password=***,age=").append(this.age)
        return sb.toString()
    }
}