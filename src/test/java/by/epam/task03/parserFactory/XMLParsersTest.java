package by.epam.task03.parserFactory;

import by.epam.task03.entity.Booklet;
import by.epam.task03.entity.Magazine;
import by.epam.task03.entity.Newspaper;
import by.epam.task03.entity.Paper;
import by.epam.task03.paperFactory.PaperBuilder;
import by.epam.task03.paperFactory.PaperBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class XMLParsersTest {
    private static final Logger logger = LogManager.getLogger(XMLParsersTest.class);

    private static final String FILE_PATH = "data/papers.xml";
    private PaperBuilderFactory factory = PaperBuilderFactory.getInstance();

    @Test
    public void isSAXParseCorrectly() {
        Newspaper expected = new Newspaper("ID-1", "1124-12-26", "Test newspaper1", "newspaper",
                true, false, false, 15, 44654);
        PaperBuilder parser = factory.createPaperBuilder("sax");
        parser.parse(FILE_PATH);
        List<Paper> paperList = parser.getPaperList();
        Newspaper actual = (Newspaper) paperList.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isStAXParseCorrectly() {
        Magazine expected = new Magazine("ID-3", "2365-03-15", "Test magazine1", "magazine",
                false, true, true, 33, 469854);
        PaperBuilder parser = factory.createPaperBuilder("stax");
        parser.parse(FILE_PATH);
        List<Paper> paperList = parser.getPaperList();
        Magazine actual = (Magazine) paperList.get(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isDOMParseCorrectly() {
        Booklet expected = new Booklet("ID-4", null, "Test booklet2", "booklet",
                false, true, true, 56);
        PaperBuilder parser = factory.createPaperBuilder("dom");
        parser.parse(FILE_PATH);
        List<Paper> paperList = parser.getPaperList();
        Booklet actual = (Booklet) paperList.get(3);
        Assert.assertEquals(expected, actual);
    }
}
