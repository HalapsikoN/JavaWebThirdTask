package by.epam.task03.parserXMLHandler;

import by.epam.task03.dto.AttributesName;
import by.epam.task03.dto.TagName;
import by.epam.task03.entity.Booklet;
import by.epam.task03.entity.Magazine;
import by.epam.task03.entity.Newspaper;
import by.epam.task03.entity.Paper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StAXHandler {
    private static final Logger logger = LogManager.getLogger(StAXHandler.class);

    private List<Paper> paperList = new ArrayList<>();
    private Paper.Builder current;
    private TagName tag;

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void parse(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_DOCUMENT: {
                    logger.info("start StAX reading");
                    break;
                }
                case XMLStreamReader.START_ELEMENT: {
                    tag = TagName.getElementTagName(reader.getLocalName());
                    switch (tag) {
                        case MAGAZINE: {
                            logger.info("<-----magazine element start----->");
                            current = new Magazine.Builder();
                            setIdAndDateAttribute(reader);
                            break;
                        }
                        case NEWSPAPER: {
                            logger.info("<-----newspaper element start----->");
                            current = new Newspaper.Builder();
                            setIdAndDateAttribute(reader);
                            break;
                        }
                        case BOOKLET: {
                            logger.info("<-----booklet element start----->");
                            current = new Booklet.Builder();
                            setIdAndDateAttribute(reader);
                            break;
                        }
                    }
                    break;
                }
                case XMLStreamConstants.CHARACTERS: {
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (tag) {
                        case TITLE: {
                            logger.info("title -> " + text);
                            current.withTitle(text);
                            break;
                        }
                        case MONTHLY: {
                            logger.info("monthly -> " + text);
                            current.withMonthly(Boolean.valueOf(text));
                            break;
                        }
                        case COLOR: {
                            logger.info("color -> " + text);
                            current.withColor(Boolean.valueOf(text));
                            break;
                        }
                        case VOLUME: {
                            logger.info("volume -> " + text);
                            current.withVolume(Integer.valueOf(text));
                            break;
                        }
                        case TYPE: {
                            logger.info("type -> " + text);
                            current.withType(text);
                            break;
                        }
                        case GLOSSY: {
                            logger.info("glossy -> " + text);
                            current.withGlossy(Boolean.valueOf(text));
                            break;
                        }
                        case INDEX: {
                            if (current.getClass().equals(Magazine.Builder.class)) {
                                logger.info("index -> " + text);
                                Magazine.Builder magazine = (Magazine.Builder) current;
                                magazine.withIndex(Integer.valueOf(text));
                            }
                            if (current.getClass().equals(Newspaper.Builder.class)) {
                                logger.info("index -> " + text);
                                Newspaper.Builder magazine = (Newspaper.Builder) current;
                                magazine.withIndex(Integer.valueOf(text));
                            }
                            break;
                        }
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    tag = TagName.getElementTagName(reader.getLocalName());
                    switch (tag) {
                        case MAGAZINE:
                        case NEWSPAPER:
                        case BOOKLET: {
                            paperList.add(current.build());
                            current = null;
                            break;
                        }
                    }
                }
                case XMLStreamConstants.END_DOCUMENT: {
                    logger.info("end StAX reading");
                    break;
                }
            }
        }
    }

    private void setIdAndDateAttribute(XMLStreamReader reader) {
        String id = reader.getAttributeValue(null, AttributesName.ID.name().toLowerCase());
        current.withId(id);
        String publicationDate = reader.getAttributeValue(null, AttributesName.PUBLICATION_DATE.name().toLowerCase());
        if (publicationDate != null) {
            current.withPublicationDate(publicationDate);
        }
    }
}
