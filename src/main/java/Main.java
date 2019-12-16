import by.epam.task03.dto.AttributesName;
import by.epam.task03.entity.Paper;
import by.epam.task03.sax.saxHendlers.SAXHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SAXException, IOException {

        XMLReader reader= XMLReaderFactory.createXMLReader();
        SAXHandler saxHandler=new SAXHandler();
        reader.setContentHandler(saxHandler);
        reader.parse(new InputSource("data/papers.xml"));

        List<Paper> paperList=saxHandler.getPaperList();
        System.out.println(paperList);
    }
}
