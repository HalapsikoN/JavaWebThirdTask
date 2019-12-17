import by.epam.task03.dto.AttributesName;
import by.epam.task03.entity.Paper;
import by.epam.task03.sax.SAXHandler;
import by.epam.task03.stax.StAXHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SAXException, IOException, XMLStreamException {

//        XMLReader reader= XMLReaderFactory.createXMLReader();
//        SAXHandler saxHandler=new SAXHandler();
//        reader.setContentHandler(saxHandler);
//        reader.parse(new InputSource("data/papers.xml"));
//
//        List<Paper> paperList=saxHandler.getPaperList();
//        System.out.println(paperList);
//
//        XMLInputFactory inputFactory=XMLInputFactory.newInstance();
//        InputStream input=new FileInputStream("data/papers.xml");
//        XMLStreamReader reader2=inputFactory.createXMLStreamReader(input);
//        StAXHandler stAXHandler=new StAXHandler();
//        stAXHandler.parse(reader2);
//
//        List<Paper> paperList2=stAXHandler.getPaperList();
//        System.out.println(paperList2);
    }
}
