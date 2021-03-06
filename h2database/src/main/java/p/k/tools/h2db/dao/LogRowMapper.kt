package p.k.tools.h2db.dao

import org.springframework.jdbc.core.RowMapper
import p.k.tools.datasource.LogRecord

import java.sql.ResultSet
import java.sql.SQLException

class LogRowMapper : RowMapper<LogRecord>
{

    @Throws(SQLException::class)
    override fun mapRow(rs: ResultSet, index: Int): LogRecord
    {
        val logRecord = LogRecord(rs.getTimestamp("logtime"), rs.getString("logLevel"), rs.getString("threadname"), rs
                .getString
                ("msg"))
        logRecord.id = rs.getLong("id")

        return logRecord

    }
}