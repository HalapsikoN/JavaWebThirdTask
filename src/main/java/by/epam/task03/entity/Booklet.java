package by.epam.task03.entity;

public class Booklet extends Paper {
    public Booklet(String id, String publicationDate, String title, String type, boolean monthly, boolean color, boolean glossy, int volume) {
        super(id, publicationDate, title, type, monthly, color, glossy, volume);
    }

    private Booklet(Builder builder){
        this.setTitle(builder.getTitle());
        this.setPublicationDate(builder.getPublicationDate());
        this.setType(builder.getType());
        this.setId(builder.getId());
        this.setGlossy(builder.isGlossy());
        this.setVolume(builder.getVolume());
        this.setColor(builder.isColor());
        this.setMonthly(builder.isMonthly());
    }

    public static class Builder extends Paper.Builder{
        @Override
        public Booklet build() {
            return new Booklet(this);
        }
    }

    @Override
    public String toString() {
        return "Booklet{" +
                super.toString() +
                "}";
    }
}
