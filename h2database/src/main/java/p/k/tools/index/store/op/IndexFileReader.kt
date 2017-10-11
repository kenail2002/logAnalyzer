package p.k.tools.index.store.op


import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.TopDocs
import org.apache.lucene.store.FSDirectory

import java.io.IOException
import java.nio.file.Paths

object IndexFileReader
{
    private val INDEX_DIR = "/TMP"

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>)
    {
        val searcher = createSearcher()

        //Search by ID
        val foundDocs = searchById(1, searcher)

        println("Total Results :: " + foundDocs.totalHits)

        for (sd in foundDocs.scoreDocs)
        {
            val d = searcher.doc(sd.doc)
            println(String.format(d.get("firstName")))
        }

        //Search by firstName
        val foundDocs2 = searchByFirstName("Brian", searcher)

        println("Total Results :: " + foundDocs2.totalHits)

        for (sd in foundDocs2.scoreDocs)
        {
            val d = searcher.doc(sd.doc)
            println(String.format(d.get("id")))
        }
    }

    @Throws(Exception::class)
    private fun searchByFirstName(firstName: String, searcher: IndexSearcher): TopDocs
    {
        val qp = QueryParser("firstName", StandardAnalyzer())
        val firstNameQuery = qp.parse(firstName)
        return searcher.search(firstNameQuery, 10)
    }

    @Throws(Exception::class)
    private fun searchById(id: Int, searcher: IndexSearcher): TopDocs
    {
        val qp = QueryParser("id", StandardAnalyzer())
        val idQuery = qp.parse(id.toString())
        return searcher.search(idQuery, 10)
    }

    @Throws(IOException::class)
    private fun createSearcher(): IndexSearcher
    {
        val dir = FSDirectory.open(Paths.get(INDEX_DIR))
        val reader = DirectoryReader.open(dir)
        return IndexSearcher(reader)
    }
}