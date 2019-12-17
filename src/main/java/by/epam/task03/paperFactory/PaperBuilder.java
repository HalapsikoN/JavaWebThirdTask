package by.epam.task03.paperFactory;

import by.epam.task03.entity.Paper;

import java.util.List;

public interface PaperBuilder {
    void parse(String fileName);

    List<Paper> getPaperList();
}
