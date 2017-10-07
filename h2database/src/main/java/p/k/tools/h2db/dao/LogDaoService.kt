package p.k.tools.h2db.dao

import p.k.tools.h2db.LogRecord
import java.util.*
import javax.sql.DataSource

interface LogDaoService
{
    fun queryLogs(): ArrayList<LogRecord>
    /**
     * @param dataSource the jdbcTemplate to set
     */
    fun setDataSource(dataSource: DataSource)

    @Throws(Exception::class)
    fun delete(id: Long)
    @Throws(Exception::class)
    fun deleteAll()

    fun getLog(id: Long): LogRecord

    fun save(logRecord: LogRecord)
}
