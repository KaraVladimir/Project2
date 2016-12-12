package project2.model;

import project2.model.PartOfText;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface CompositePartOfText extends PartOfText {

    public List<PartOfText> getList();

    @Override
    default StringBuilder getText(StringBuilder stringBuilder) {
        getList().stream().forEach(item->item.getText(stringBuilder));
        return stringBuilder;
    }

    @Override
    default String getText() {
        return getText(new StringBuilder()).toString();
    }

    void parse(CharSequence charSequence);

    @Override
    default boolean isComposite() {
        return true;
    }

    default boolean addPart(PartOfText partOfText) {
        return getList().add(partOfText);
    }

    default PartOfText getPart(int i) {
        return getList().get(i);
    }

    default boolean removePart(PartOfText partOfText) {
        return getList().remove(partOfText);
    }
}
