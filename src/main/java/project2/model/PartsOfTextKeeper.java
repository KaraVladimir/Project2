package project2.model;

import project2.model.PartOfText;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface PartsOfTextKeeper {
    PartOfText lookupPartOfText(Class<? extends PartOfText> clazz, CharSequence charSequence);
}
