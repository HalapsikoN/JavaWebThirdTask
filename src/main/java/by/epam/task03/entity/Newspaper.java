package by.epam.task03.entity;

public class Newspaper extends Paper {
    private int index;

    public Newspaper(String id, String publicationDate, String title, String type, boolean monthly, boolean color, boolean glossy, int volume, int index) {
        super(id, publicationDate, title, type, monthly, color, glossy, volume);
        this.index = index;
    }


    private Newspaper(Builder builder){
        this.setTitle(builder.getTitle());
        this.setPublicationDate(builder.getPublicationDate());
        this.setType(builder.getType());
        this.setId(builder.getId());
        this.setGlossy(builder.isGlossy());
        this.setVolume(builder.getVolume());
        this.setColor(builder.isColor());
        this.setMonthly(builder.isMonthly());
        this.setIndex(builder.index);
    }

    public static class Builder extends Paper.Builder{
        private int index;

        public Builder withIndex(int value){
            index=value;
            return this;
        }

        @Override
        public Newspaper build() {
            return new Newspaper(this);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Newspaper newspaper = (Newspaper) o;

        return index == newspaper.index;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + index;
        return result;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                super.toString() +
                " index=" + index +
                '}';
    }
}
