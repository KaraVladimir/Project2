package project2.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Word extends CompositePartOfText{
    CharSequence charSequence;

    public Word(CharSequence charSequence) {
        this.charSequence = charSequence;
    }


    @Override
    public void parse() {
        for (int i = 0; i < charSequence.length(); i++) {
            Symbol symbol = (Symbol) PartsOfTextKeeper.INSTANCE.lookupInWordKeeper(Symbol.class,
                    String.valueOf(charSequence.charAt(i)));
            addPart(symbol);
        }
    }
}
