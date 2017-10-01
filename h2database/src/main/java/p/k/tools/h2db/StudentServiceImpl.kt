package p.k.tools.h2db

import org.springframework.jdbc.core.JdbcTemplate
import java.sql.Types
import java.util.*
import javax.sql.DataSource

class StudentServiceImpl : StudentService
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
     * @see com.ncut.service.StudentService#queryStudent()
     */
    override fun queryStudent(): ArrayList<Student>
    {

        //List query(String sql,Ojbect[] args,RowMapper rowMapper)
        // 说明：常用的查询，sql待执行的sql语句，args是sql语句的参数，rowMapper负责将每一行记录转化为java对象存放在list，并最终返回

        return jdbcTemplate!!.query("select * from student", StudentRowMapper()) as ArrayList<Student>
    }

    @Throws(Exception::class)
    override fun delete(id: Int)
    {
        jdbcTemplate!!.update("delete from student where id=?", arrayOf<Any>(id), intArrayOf(java.sql.Types.BIGINT))
    }

    override fun getStudent(id: Int): Student
    {
        return jdbcTemplate!!.queryForObject("select * from student where id=?", arrayOf<Any>(id), intArrayOf(java.sql.Types.BIGINT), StudentRowMapper()) as Student
    }

    override fun save(student: Student)
    {
        jdbcTemplate!!.update("insert into student(id,username,password,age) values(?,?,?,?)",
                arrayOf(student.id, student.username, student.password, student.age),
                intArrayOf(Types.BIGINT, Types.VARCHAR, Types.VARCHAR, Types.INTEGER));
    }


}