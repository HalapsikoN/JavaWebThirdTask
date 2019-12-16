package by.epam.task03.entity;

public class Booklet extends Paper{
    public Booklet(String id, String publicationDate, String title, String type, boolean monthly, boolean color, boolean glossy, int volume) {
        super(id, publicationDate, title, type, monthly, color, glossy, volume);
    }

    public Booklet() {
    }

    @Override
    public String toString() {
        return "Booklet{"+
                super.toString()+
                "}";
    }
}
