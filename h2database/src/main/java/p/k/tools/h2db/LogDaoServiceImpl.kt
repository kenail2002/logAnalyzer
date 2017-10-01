package p.k.tools.h2db

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Types
import java.util.*
import javax.sql.DataSource

class LogDaoServiceImpl : LogDaoService
{
    override fun deleteAll()
    {
        jdbcTemplate!!.update("delete from LogRecord")
    }

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
    override fun delete(id: Long)
    {
        jdbcTemplate!!.update("delete from LogRecord where id=?", arrayOf<Any>(id), intArrayOf(java.sql.Types.BIGINT))
    }

    override fun getLog(id: Long): LogRecord
    {
        return jdbcTemplate!!.queryForObject("select * from LogRecord where id=?", arrayOf<Any>(id), intArrayOf(java.sql.Types.BIGINT), LogRowMapper()) as LogRecord
    }

    class CountRowMapper : RowMapper<Int>
    {

        @Throws(SQLException::class)
        override fun mapRow(rs: ResultSet, index: Int): Int
        {
            return rs.getInt(1)
        }
    }

    override fun save(logRecord: LogRecord)
    {
        jdbcTemplate!!.update("insert into logRecord(id,username,password,age) values(?,?,?,?)",
                arrayOf(logRecord.id, logRecord.username, logRecord.password, logRecord.age),
                intArrayOf(Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.INTEGER));
    }


}