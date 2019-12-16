package by.epam.task03.sax.saxHendlers;

import by.epam.task03.dto.AttributesName;
import by.epam.task03.dto.PaperType;
import by.epam.task03.dto.TagName;
import by.epam.task03.entity.Booklet;
import by.epam.task03.entity.Magazine;
import by.epam.task03.entity.Newspaper;
import by.epam.task03.entity.Paper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private static final Logger logger= LogManager.getLogger(SAXHandler.class);

    private List<Paper> paperList=new ArrayList<>();
    private Paper current;
    private StringBuilder text;

    public List<Paper> getPaperList() {
        return paperList;
    }

    @Override
    public void startDocument() throws SAXException {
        logger.info("start SAX reading");
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text=new StringBuilder();
        if(localName.equals(PaperType.MAGAZINE.name().toLowerCase())){
            logger.info("<-----magazine element start----->");
            current = new Magazine();
            setIdAndDateAttributes(attributes);
        }
        if(localName.equals(PaperType.NEWSPAPER.name().toLowerCase())){
            logger.info("<-----newspaper element----->");
            current = new Newspaper();
            setIdAndDateAttributes(attributes);
        }
        if(localName.equals(PaperType.BOOKLET.name().toLowerCase())){
            logger.info("<-----booklet element----->");
            current = new Booklet();
            setIdAndDateAttributes(attributes);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        TagName tagName=TagName.valueOf(localName.toUpperCase().replace("-","_"));
        switch (tagName) {
            case TITLE: {
                logger.info("title -> "+ text.toString());
                current.setTitle(text.toString());
                break;
            }
            case MONTHLY: {
                logger.info("monthly -> "+ text.toString());
                current.setMonthly(Boolean.valueOf(text.toString()));
                break;
            }
            case COLOR: {
                logger.info("color -> "+ text.toString());
                current.setColor(Boolean.valueOf(text.toString()));
                break;
            }
            case VOLUME:{
                logger.info("volume -> "+ text.toString());
                current.setVolume(Integer.valueOf(text.toString()));
                break;
            }
            case TYPE:{
                logger.info("type -> "+ text.toString());
                current.setType(text.toString());
                break;
            }
            case GLOSSY:{
                logger.info("glossy -> "+ text.toString());
                current.setGlossy(Boolean.valueOf(text.toString()));
                break;
            }
            case INDEX:{
                if(current.getClass().equals(Magazine.class)){
                    logger.info("index -> "+ text.toString());
                    Magazine magazine=(Magazine) current;
                    magazine.setIndex(Integer.valueOf(text.toString()));
                }
                if(current.getClass().equals(Newspaper.class)){
                    logger.info("index -> "+ text.toString());
                    Newspaper magazine=(Newspaper) current;
                    magazine.setIndex(Integer.valueOf(text.toString()));
                }
                break;
            }
            case MAGAZINE:
            case NEWSPAPER:
            case BOOKLET: {
                logger.info("<-----element end----->");
                paperList.add(current);
                current=null;
                break;
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        logger.info("end SAX reading");
        super.endDocument();
    }

    private void setIdAndDateAttributes(Attributes attributes){
        current.setId(attributes.getValue(AttributesName.ID.name().toLowerCase()));
        if(attributes.getLength()>1) {
            current.setPublicationDate(attributes.getValue(AttributesName.PUBLICATION_DATE.name().toLowerCase().replace("_", "-")));
        }
    }
}
