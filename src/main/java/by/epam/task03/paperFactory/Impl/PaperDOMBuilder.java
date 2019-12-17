package by.epam.task03.paperFactory.Impl;

import by.epam.task03.entity.Paper;
import by.epam.task03.paperFactory.PaperBuilder;
import by.epam.task03.parserXMLHandler.DOMHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class PaperDOMBuilder implements PaperBuilder {
    private final static Logger logger = LogManager.getLogger(PaperDOMBuilder.class);
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document document;
    private DOMHandler domHandler;


    @Override
    public void parse(String fileName) {
        try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(fileName);
            domHandler = new DOMHandler();
            domHandler.parse(document);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Paper> getPaperList() {
        return domHandler.getPaperList();
    }
}
