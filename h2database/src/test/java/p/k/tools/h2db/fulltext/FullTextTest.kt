package p.k.tools.h2db.fulltext

import org.h2.fulltext.FullText
import org.junit.Assert.*
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext
import p.k.tools.h2db.dao.LogDaoService
import javax.sql.DataSource

class FullTextTest
{
    @Test
    fun testFullText()
    {

        val ctx = ClassPathXmlApplicationContext("applicationContext.xml")
        val logService = ctx.getBean("logDaoService") as LogDaoService
        val ds = ctx.getBean("dataSource") as DataSource
        logService.setDataSource(ds)


        val conn = ds.connection;

        var stat = conn.createStatement();

        FullText.setIgnoreList(conn, "to,this");
        FullText.setWhitespaceChars(conn, " ,.-")

        var rs = stat.executeQuery("SELECT * FROM FT_SEARCH('Welcome', 0, 0)");
        assertTrue(rs.next());
        assertEquals("QUERY", rs.getMetaData().getColumnLabel(1));
        assertEquals("SCORE", rs.getMetaData().getColumnLabel(2));
        assertEquals("\"PUBLIC\".\"TEST\" WHERE \"ID\"=1", rs.getString(1));
        assertEquals("1.0", rs.getString(2));
        rs = stat.executeQuery("SELECT * FROM FT_SEARCH_DATA('One', 0, 0)");
        assertTrue(rs.next());
        rs = stat.executeQuery("SELECT * FROM FT_SEARCH_DATA('One_Word', 0, 0)");
        assertFalse(rs.next());
        rs = stat.executeQuery("SELECT * FROM FT_SEARCH_DATA('Welcome', 0, 0)");
        assertTrue(rs.next());
    }
}