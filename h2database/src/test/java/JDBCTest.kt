package p.k.tools.h2db

import org.junit.Test
import org.slf4j.LoggerFactory
import org.springframework.context.support.ClassPathXmlApplicationContext
import javax.sql.DataSource
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class JDBCTest
{
    val log = LoggerFactory.getLogger(JDBCTest::class.java)

    @Test
    fun testSaveLog()
    {
        val ctx = ClassPathXmlApplicationContext("applicationContext.xml")
        val logService = ctx.getBean("logDaoService") as LogDaoService
        logService.setDataSource(ctx.getBean("dataSource") as DataSource)
        logService.save(LogRecord("zq", "password", 100))
        val list = logService.queryLogs()
        log.info("list=$list")
        assertNotNull(list)
        assertEquals("zq", list[0].username)
        assertEquals(100, list[0].age)
    }

    @Test
    fun testQueryLog()
    {
        val ctx = ClassPathXmlApplicationContext("applicationContext.xml")
        val logService = ctx.getBean("logDaoService") as LogDaoService
        logService.setDataSource(ctx.getBean("dataSource") as DataSource)
        val logRecord = LogRecord("zq", "password", 100)
        logService.save(logRecord)
        val log2 = logService.getLog(logRecord.id)
        assertNotNull(log2)
        assertEquals("zq", log2.username)
        assertEquals(100, log2.age)

    }

    @Test
    fun testEmptyDB()
    {
        val ctx = ClassPathXmlApplicationContext("applicationContext.xml")
        val logService = ctx.getBean("logDaoService") as LogDaoService
        logService.setDataSource(ctx.getBean("dataSource") as DataSource)
        val list = logService.queryLogs()
        log.info("list=$list")
        assertTrue(list.isEmpty())
    }

    @Test
    fun testDeleteLog()
    {
        val ctx = ClassPathXmlApplicationContext("applicationContext.xml")
        val logService = ctx.getBean("logDaoService") as LogDaoService
        logService.setDataSource(ctx.getBean("dataSource") as DataSource)
        val logRecord = LogRecord("zq", "password", 100)
        logService.save(logRecord)
        logService.deleteAll()
        val log2 = logService.queryLogs()

        assertTrue(log2.isEmpty())
    }


}