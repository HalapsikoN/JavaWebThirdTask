package by.epam.task03.dto;

public enum AttributesName {
    ID,
    PUBLICATION_DATE;

    public static AttributesName getElemntTagName(String element){
        switch (element){
            case "id":{
                return ID;
            }
            case "publication_date":{
                return PUBLICATION_DATE;
            }
            default:{
                throw new EnumConstantNotPresentException(TagName.class, element);
            }
        }
    }
}
