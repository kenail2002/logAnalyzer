package p.k.tools.h2db;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int index) throws SQLException {
        LogRecord logRecord = new LogRecord(rs.getString("username"), rs.getString("password"), rs.getInt("age"));
        logRecord.setId(rs.getLong("id"));
        return logRecord;

    }
}