package p.k.tools.h2db

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
    fun delete(id: Int)

    fun getLog(id: Int): LogRecord

    fun save(logRecord: LogRecord)
}
