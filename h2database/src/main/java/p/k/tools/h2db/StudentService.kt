package p.k.tools.h2db

import java.util.*
import javax.sql.DataSource

interface StudentService
{
    fun queryStudent(): ArrayList<Student>
    /**
     * @param dataSource the jdbcTemplate to set
     */
    fun setDataSource(dataSource: DataSource)

    @Throws(Exception::class)
    fun delete(id: Int)

    fun getStudent(id: Int): Student

    fun save(student: Student)
}
