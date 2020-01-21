package by.epam.task03.parserXMLHandler;

import by.epam.task03.dto.AttributesName;
import by.epam.task03.dto.PaperType;
import by.epam.task03.dto.TagName;
import by.epam.task03.entity.Booklet;
import by.epam.task03.entity.Magazine;
import by.epam.task03.entity.Newspaper;
import by.epam.task03.entity.Paper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMHandler {
    private static final Logger logger = LogManager.getLogger(DOMHandler.class);

    private List<Paper> paperList = new ArrayList<>();

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void parse(Document document) {
        logger.info("start DOM reading");
        Element root = document.getDocumentElement();

        NodeList magazineList = root.getElementsByTagName(PaperType.MAGAZINE.name().toLowerCase());
        for (int i = 0; i < magazineList.getLength(); ++i) {
            logger.info("<-----magazine element start----->");
            Element magazineElement = (Element) magazineList.item(i);
            Magazine magazine = buildMagazine(magazineElement);
            paperList.add(magazine);
        }

        NodeList newspaperList = root.getElementsByTagName(PaperType.NEWSPAPER.name().toLowerCase());
        for (int i = 0; i < newspaperList.getLength(); ++i) {
            logger.info("<-----newspaper element start----->");
            Element newspaperElement = (Element) newspaperList.item(i);
            Newspaper newspaper = buildNewspaper(newspaperElement);
            paperList.add(newspaper);
        }

        NodeList bookletList = root.getElementsByTagName(PaperType.BOOKLET.name().toLowerCase());
        for (int i = 0; i < bookletList.getLength(); ++i) {
            logger.info("<-----booklet element start----->");
            Element bookletElement = (Element) bookletList.item(i);
            Booklet booklet = buildBooklet(bookletElement);
            paperList.add(booklet);
        }
        logger.info("end DOM reading");
    }

    private Magazine buildMagazine(Element element) {
        Magazine.Builder magazine = new Magazine.Builder();
        buildPaper(element, magazine);
        int index = Integer.parseInt(getElementTextContext(element, TagName.INDEX.name().toLowerCase()));
        magazine.withIndex(index);
        logger.info("index -> " + index);
        return magazine.build();
    }

    private Newspaper buildNewspaper(Element element) {
        Newspaper.Builder newspaper = new Newspaper.Builder();
        buildPaper(element, newspaper);
        int index = Integer.parseInt(getElementTextContext(element, TagName.INDEX.name().toLowerCase()));
        newspaper.withIndex(index);
        logger.info("index -> " + index);
        return newspaper.build();
    }

    private Booklet buildBooklet(Element element) {
        Booklet.Builder booklet = new Booklet.Builder();
        buildPaper(element, booklet);
        return booklet.build();
    }

    private void buildPaper(Element element, Paper.Builder paper) {
        String id = element.getAttribute(AttributesName.ID.name().toLowerCase());
        paper.withId(id);
        String publicationDate = element.getAttribute(AttributesName.PUBLICATION_DATE.name().toLowerCase());
        if (!publicationDate.isEmpty()) {
            paper.withPublicationDate(publicationDate);
        }
        String title = getElementTextContext(element, TagName.TITLE.name().toLowerCase());
        paper.withTitle(title);
        logger.info("title -> " + title);
        boolean monthly = Boolean.parseBoolean(getElementTextContext(element, TagName.MONTHLY.name().toLowerCase()));
        paper.withMonthly(monthly);
        logger.info("monthly -> " + monthly);
        boolean color = Boolean.parseBoolean(getElementTextContext(element, TagName.COLOR.name().toLowerCase()));
        paper.withColor(color);
        logger.info("color -> " + color);
        int volume = Integer.parseInt(getElementTextContext(element, TagName.VOLUME.name().toLowerCase()));
        paper.withVolume(volume);
        logger.info("volume -> " + volume);
        String type = getElementTextContext(element, TagName.TYPE.name().toLowerCase());
        paper.withType(type);
        logger.info("type -> " + type);
        boolean glossy = Boolean.parseBoolean(getElementTextContext(element, TagName.GLOSSY.name().toLowerCase()));
        paper.withGlossy(glossy);
        logger.info("glossy -> " + glossy);
    }

    private String getElementTextContext(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
