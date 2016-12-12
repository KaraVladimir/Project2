package project2.model;

import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface PartOfText {

    String getText();

    StringBuilder getText(StringBuilder stringBuilder);

    void parse(CharSequence charSequence);

    boolean isComposite();
}
