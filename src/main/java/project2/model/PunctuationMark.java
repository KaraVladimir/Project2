package project2.model;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class PunctuationMark extends CompositePartOfText {
    CharSequence charSequence;

    public PunctuationMark(CharSequence s) {
        this.charSequence = s;
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
