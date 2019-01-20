package p.k.tools.pom;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PomReader {
    public static void main(String[] args) throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        String myPom = System.getProperty("user.dir") + File.separator + "pom.xml";
        Model model = reader.read(new FileReader(myPom));

    }
}
