package by.epam.task03.entity;

import java.util.Objects;

public abstract class Paper {
    private String id;
    private String publicationDate;
    private String title;
    private String type;
    private boolean monthly;
    private boolean color;
    private boolean glossy;
    private int volume;

    public Paper(String id, String publicationDate, String title, String type, boolean monthly, boolean color, boolean glossy, int volume) {
        this.id = id;
        this.publicationDate = publicationDate;
        this.title = title;
        this.type = type;
        this.monthly = monthly;
        this.color = color;
        this.glossy = glossy;
        this.volume = volume;
    }

    public static abstract class Builder{
        private String id;
        private String publicationDate;
        private String title;
        private String type;
        private boolean monthly;
        private boolean color;
        private boolean glossy;
        private int volume;

        public Builder withId(String value){
            id=value;
            return this;
        }

        public Builder withPublicationDate(String value){
            publicationDate=value;
            return this;
        }

        public Builder withTitle(String value){
            title=value;
            return this;
        }

        public Builder withType(String value){
            type=value;
            return this;
        }

        public Builder withMonthly(boolean value){
            monthly=value;
            return this;
        }

        public Builder withColor(boolean value){
            color=value;
            return this;
        }

        public Builder withGlossy(boolean value){
            glossy=value;
            return this;
        }

        public Builder withVolume(int value){
            volume=value;
            return this;
        }

        public String getId() {
            return id;
        }

        public String getPublicationDate() {
            return publicationDate;
        }

        public String getTitle() {
            return title;
        }

        public String getType() {
            return type;
        }

        public boolean isMonthly() {
            return monthly;
        }

        public boolean isColor() {
            return color;
        }

        public boolean isGlossy() {
            return glossy;
        }

        public int getVolume() {
            return volume;
        }

        public abstract Paper build();
    }

    public Paper() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isGlossy() {
        return glossy;
    }

    public void setGlossy(boolean glossy) {
        this.glossy = glossy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paper paper = (Paper) o;

        if (monthly != paper.monthly) return false;
        if (color != paper.color) return false;
        if (glossy != paper.glossy) return false;
        if (volume != paper.volume) return false;
        if (!Objects.equals(id, paper.id)) return false;
        if (!Objects.equals(publicationDate, paper.publicationDate))
            return false;
        if (!Objects.equals(title, paper.title)) return false;
        return Objects.equals(type, paper.type);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (monthly ? 1 : 0);
        result = 31 * result + (color ? 1 : 0);
        result = 31 * result + (glossy ? 1 : 0);
        result = 31 * result + volume;
        return result;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id='" + id + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", monthly=" + monthly +
                ", color=" + color +
                ", glossy=" + glossy +
                ", volume=" + volume +
                '}';
    }
}
