package p.k.tools.h2db

import org.springframework.jdbc.core.JdbcTemplate
import java.sql.Types
import java.util.*
import javax.sql.DataSource

class LogDaoServiceImpl : LogDaoService
{
    private var jdbcTemplate: JdbcTemplate? = null

    /**
     * @param dataSource the jdbcTemplate to set
     */
    override fun setDataSource(dataSource: DataSource)
    {
        this.jdbcTemplate = JdbcTemplate(dataSource)
    }

    /* (non-Javadoc)
     * @see com.ncut.service.LogDaoService#queryLogs()
     */
    override fun queryLogs(): ArrayList<LogRecord>
    {
        return jdbcTemplate!!.query("select * from LogRecord", LogRowMapper()) as ArrayList<LogRecord>
    }

    @Throws(Exception::class)
    override fun delete(id: Int)
    {
        jdbcTemplate!!.update("delete from LogRecord where id=?", arrayOf<Any>(id), intArrayOf(java.sql.Types.BIGINT))
    }

    override fun getLog(id: Int): LogRecord
    {
        return jdbcTemplate!!.queryForObject("select * from LogRecord where id=?", arrayOf<Any>(id), intArrayOf(java.sql.Types.BIGINT), LogRowMapper()) as LogRecord
    }

    override fun save(logRecord: LogRecord)
    {
        jdbcTemplate!!.update("insert into logRecord(id,username,password,age) values(?,?,?,?)",
                arrayOf(logRecord.id, logRecord.username, logRecord.password, logRecord.age),
                intArrayOf(Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.INTEGER));
    }


}