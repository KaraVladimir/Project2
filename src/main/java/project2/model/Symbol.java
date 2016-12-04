package project2.model;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Symbol implements PartOfText{
    private char aChar;

    public Symbol(CharSequence charSequence) {
        this.aChar = charSequence.charAt(0);
    }

    @Override
    public StringBuilder getText(StringBuilder stringBuilder) {
        stringBuilder.append(aChar);
        return stringBuilder;
    }

    @Override
    public void parse() {
        throw new UnsupportedOperationException();
    }
}
