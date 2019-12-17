package by.epam.task03.paperFactory.Impl;

import by.epam.task03.entity.Paper;
import by.epam.task03.paperFactory.PaperBuilder;
import by.epam.task03.parserXMLHandler.SAXHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class PaperSAXBuilder implements PaperBuilder {
    private final static Logger logger = LogManager.getLogger(PaperSAXBuilder.class);
    private XMLReader reader;
    private SAXHandler saxHandler;

    @Override
    public void parse(String fileName) {
        try {
            reader = XMLReaderFactory.createXMLReader();
            saxHandler = new SAXHandler();
            reader.setContentHandler(saxHandler);
            reader.parse(new InputSource(fileName));
        } catch (SAXException | IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Paper> getPaperList() {
        return saxHandler.getPaperList();
    }
}
