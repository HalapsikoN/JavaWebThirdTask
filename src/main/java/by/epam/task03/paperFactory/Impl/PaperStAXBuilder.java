package by.epam.task03.paperFactory.Impl;

import by.epam.task03.entity.Paper;
import by.epam.task03.paperFactory.PaperBuilder;
import by.epam.task03.parserXMLHandler.StAXHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PaperStAXBuilder implements PaperBuilder {
    private final static Logger logger = LogManager.getLogger(PaperStAXBuilder.class);
    private XMLInputFactory inputFactory;
    private XMLStreamReader reader;
    private StAXHandler stAXHandler;

    @Override
    public void parse(String fileName) {
        try (InputStream input = new FileInputStream(fileName)) {
            inputFactory = XMLInputFactory.newInstance();
            reader = inputFactory.createXMLStreamReader(input);
            stAXHandler = new StAXHandler();
            stAXHandler.parse(reader);
        } catch (XMLStreamException | IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public List<Paper> getPaperList() {
        return stAXHandler.getPaperList();
    }
}
