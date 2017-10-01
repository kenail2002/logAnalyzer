package p.k.tools.h2db

import org.springframework.context.support.ClassPathXmlApplicationContext
import javax.sql.DataSource


class JDBCTest
{
}

object SpringJDBC
{

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
        studentService.save(Student("zq","password",100))
        val list = studentService.queryStudent()
        for (student in list)
        {
            System.out.println("您的用户名是：" + student.username)
            System.out.println("您的年龄是" + student.age)
        }
    }

}