package by.epam.task03.entity;

public class Magazine extends Paper {
    private int index;

    public Magazine(String id, String publicationDate, String title, String type, boolean monthly, boolean color, boolean glossy, int volume, int index) {
        super(id, publicationDate, title, type, monthly, color, glossy, volume);
        this.index = index;
    }

    public Magazine() {
        super();
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

        Magazine magazine = (Magazine) o;

        return index == magazine.index;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + index;
        return result;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                super.toString() +
                " index=" + index +
                '}';
    }
}
