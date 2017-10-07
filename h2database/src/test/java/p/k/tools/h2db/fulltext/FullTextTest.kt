package p.k.tools.h2db.fulltext

import org.h2.fulltext.FullText
import org.junit.Assert.*
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext
import p.k.tools.h2db.LogRecord
import p.k.tools.h2db.dao.LogDaoService
import java.sql.Timestamp
import javax.sql.DataSource

class FullTextTest
{
    @Test
    fun testFullText()
    {

        val ctx = ClassPathXmlApplicationContext("applicationContext.xml")
        val ds = ctx.getBean("dataSource") as DataSource

        val conn = ds.connection;

        val logService = ctx.getBean("logDaoService") as LogDaoService
        logService.setDataSource(ds)



        var stat = conn.createStatement();

        FullText.setIgnoreList(conn, "to,this");
        FullText.setWhitespaceChars(conn, " ,.-")
        val logRecord = LogRecord(Timestamp(System.currentTimeMillis()), "zq",
                "thread2", "Welcome to this world, One_Word")
        logService.save(logRecord)

        var rs = stat.executeQuery("SELECT * FROM FT_SEARCH('Welcome', 0, 0)");
        assertTrue(rs.next());
        assertEquals("QUERY", rs.getMetaData().getColumnLabel(1));
        assertEquals("SCORE", rs.getMetaData().getColumnLabel(2));
        assertEquals("\"PUBLIC\".\"LOGRECORD\" WHERE \"ID\"="+logRecord.id, rs.getString(1));
        assertEquals("1.0", rs.getString(2));
        rs = stat.executeQuery("SELECT * FROM FT_SEARCH_DATA('One', 0, 0)");
        assertFalse(rs.next());
        rs = stat.executeQuery("SELECT * FROM FT_SEARCH_DATA('One_Word', 0, 0)");
        assertTrue(rs.next());
        rs = stat.executeQuery("SELECT * FROM FT_SEARCH_DATA('Welcome', 0, 0)");
        assertTrue(rs.next());
    }
}