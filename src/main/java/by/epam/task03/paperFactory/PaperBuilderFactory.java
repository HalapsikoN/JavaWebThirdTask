package by.epam.task03.paperFactory;

import by.epam.task03.paperFactory.Impl.PaperDOMBuilder;
import by.epam.task03.paperFactory.Impl.PaperSAXBuilder;
import by.epam.task03.paperFactory.Impl.PaperStAXBuilder;

public class PaperBuilderFactory {
    private static final PaperBuilderFactory instance = new PaperBuilderFactory();

    private PaperBuilderFactory() {
    }

    public static PaperBuilderFactory getInstance() {
        return instance;
    }

    private enum TypeParser {
        SAX,
        STAX,
        DOM
    }

    public PaperBuilder createPaperBuilder(String parserType) {
        TypeParser typeParser = TypeParser.valueOf(parserType.toUpperCase());
        switch (typeParser) {
            case SAX: {
                return new PaperSAXBuilder();
            }
            case STAX: {
                return new PaperStAXBuilder();
            }
            case DOM: {
                return new PaperDOMBuilder();
            }
            default: {
                throw new EnumConstantNotPresentException(typeParser.getDeclaringClass(), typeParser.name());
            }
        }
    }
}
