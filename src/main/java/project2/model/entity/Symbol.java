package project2.model.entity;

import project2.model.PartOfText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Symbol implements PartOfText {
    private char aChar;


    @Override
    public StringBuilder getText(StringBuilder stringBuilder) {
        stringBuilder.append(aChar);
        return stringBuilder;
    }

    @Override
    public String getText() {
        return String.valueOf(aChar);
    }

    @Override
    public void parse(CharSequence charSequence) {
        aChar = charSequence.charAt(0);
    }

    @Override
    public boolean isComposite() {
        return false;
    }
}
