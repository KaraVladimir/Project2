package project2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author kara.vladimir2@gmail.com.
 */
public abstract class CompositePartOfText implements PartOfText {
    protected List<PartOfText> list;
    StringBuilder stringBuilder = new StringBuilder();


    public CompositePartOfText() {
        this.list = new ArrayList<>();
    }


    @Override
    public StringBuilder getText(StringBuilder stringBuilder) {
        list.stream().forEach(item->item.getText(stringBuilder));
        return stringBuilder;
    }

    public abstract void parse();

    public boolean addPart(PartOfText partOfText) {
        return list.add(partOfText);
    }

    public PartOfText getPart(int i) {
        return list.get(i);
    }

    public boolean removePart(PartOfText partOfText) {
        return list.remove(partOfText);
    }
}
