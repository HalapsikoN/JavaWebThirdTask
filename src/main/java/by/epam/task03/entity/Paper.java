package by.epam.task03.entity;

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
        if (id != null ? !id.equals(paper.id) : paper.id != null) return false;
        if (publicationDate != null ? !publicationDate.equals(paper.publicationDate) : paper.publicationDate != null)
            return false;
        if (title != null ? !title.equals(paper.title) : paper.title != null) return false;
        return type != null ? type.equals(paper.type) : paper.type == null;

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
