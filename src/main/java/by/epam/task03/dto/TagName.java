package by.epam.task03.dto;

public enum TagName {
    TITLE,
    MONTHLY,
    COLOR,
    VOLUME,
    TYPE,
    GLOSSY,
    INDEX,
    MAGAZINE,
    NEWSPAPER,
    BOOKLET,
    PAPERS;

    public static TagName getElementTagName(String element) {
        switch (element) {
            case "title": {
                return TITLE;
            }
            case "monthly": {
                return MONTHLY;
            }
            case "color": {
                return COLOR;
            }
            case "volume": {
                return VOLUME;
            }
            case "type": {
                return TYPE;
            }
            case "glossy": {
                return GLOSSY;
            }
            case "index": {
                return INDEX;
            }
            case "magazine": {
                return MAGAZINE;
            }
            case "newspaper": {
                return NEWSPAPER;
            }
            case "booklet": {
                return BOOKLET;
            }
            case "papers": {
                return PAPERS;
            }
            default: {
                throw new EnumConstantNotPresentException(TagName.class, element);
            }
        }
    }
}