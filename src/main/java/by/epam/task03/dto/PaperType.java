package by.epam.task03.dto;

public enum PaperType {
    MAGAZINE,
    NEWSPAPER,
    BOOKLET;

    public static PaperType getElemntTagName(String element) {
        switch (element) {
            case "magazine": {
                return MAGAZINE;
            }
            case "newspaper": {
                return NEWSPAPER;
            }
            case "booklet": {
                return BOOKLET;
            }
            default: {
                throw new EnumConstantNotPresentException(TagName.class, element);
            }
        }
    }
}
