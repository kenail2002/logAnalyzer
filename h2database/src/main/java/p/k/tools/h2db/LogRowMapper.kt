package p.k.tools.h2db

import org.springframework.jdbc.core.RowMapper

import java.sql.ResultSet
import java.sql.SQLException

class LogRowMapper : RowMapper<*>
{

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, index: Int): Any
    {
        val logRecord = LogRecord(rs.getString("username"), rs.getString("password"), rs.getInt("age"))
        logRecord.id = rs.getLong("id")
        return logRecord

    }
}