package p.k.tools.index.store.op

import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.store.FSDirectory
import java.io.IOException
import java.nio.file.Paths
import java.util.*


class IndexFileWriter
{
    companion object
    {

        @JvmStatic
        @Throws(IOException::class)
        fun createWriter(): IndexWriter
        {
            val INDEX_DIR = "/TMP"
            val dir = FSDirectory.open(Paths.get(INDEX_DIR))
            val config = IndexWriterConfig(StandardAnalyzer())
            return IndexWriter(dir, config)
        }

        @JvmStatic
        fun createDocument(id: Int, firstName: String, lastName: String, website: String): Document
        {
            val document = Document()
            document.add(StringField("id", id.toString(), Field.Store.YES))
            document.add(TextField("firstName", firstName, Field.Store.YES))
            document.add(TextField("lastName", lastName, Field.Store.YES))
            document.add(TextField("website", website, Field.Store.YES))
            return document
        }

    }


}

@Throws(Exception::class)
fun main(args: Array<String>)
{
    val writer = IndexFileWriter.createWriter()
    val documents = ArrayList<Document>()

    val document1 = IndexFileWriter.createDocument(1, "Lokesh", "Gupta", "howtodoinjava.com")
    documents.add(document1)

    val document2 = IndexFileWriter.createDocument(2, "Brian", "Schultz", "example.com")
    documents.add(document2)

    //Let's clean everything first
    writer.deleteAll()

    writer.addDocuments(documents)
    writer.commit()
    writer.close()
}