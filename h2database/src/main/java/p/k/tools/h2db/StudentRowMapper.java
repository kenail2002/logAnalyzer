package p.k.tools.h2db;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int index) throws SQLException {
        Student student = new Student(rs.getString("username"), rs.getString("password"),rs.getInt("age"));
        return student;

    }
}