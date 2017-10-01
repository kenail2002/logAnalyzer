package p.k.tools.h2db

import org.slf4j.LoggerFactory
import org.springframework.context.support.ClassPathXmlApplicationContext
import javax.sql.DataSource


class JDBCTest
{
}

object SpringJDBC
{

    val log = LoggerFactory.getLogger(SpringJDBC::class.java)
    /**+
     * @param args
     */
    @JvmStatic
    fun main(args: Array<String>)
    {
        // TODO Auto-generated method stub
        val ctx = ClassPathXmlApplicationContext("applicationContext.xml")
        val studentService = ctx.getBean("studentService") as StudentService
        studentService.setDataSource(ctx.getBean("dataSource") as DataSource)
        studentService.save(Student("zq", "password", 100))
        val list = studentService.queryStudent()
        log.info("list=$list")

    }

}