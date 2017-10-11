package p.k.tools.datasource

import java.util.*

interface DataStoreService
{
    fun queryLogs(): ArrayList<LogRecord>

    @Throws(Exception::class)
    fun delete(id: Long)

    @Throws(Exception::class)
    fun deleteAll()

    fun getLog(id: Long): LogRecord

    fun save(logRecord: LogRecord)
}