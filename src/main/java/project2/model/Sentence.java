package project2.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Sentence extends CompositePartOfText {

    CharSequence charSequence;
    private static Pattern pattern = initPattern();

    public Sentence(CharSequence charSequence) {
        this.charSequence = charSequence;
    }

    private static Pattern initPattern() {
        String s = "([А-Яа-я\\w]+([^?!.,:;\"\\s])*)|([?!.,:;\"]+)|(\\s+)";
        return Pattern.compile(s);
    }

    @Override
    public void parse() {
        Matcher matcher = pattern.matcher(charSequence);
        PartOfText partOfText = null;
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                partOfText = new Word(matcher.group(1));
            } else if (matcher.group(3) != null) {
                partOfText = new PunctuationMark(matcher.group(3));
            } else if (matcher.group(4) != null) {
                partOfText = new Separator(matcher.group(4));
            }
            partOfText.parse();
            addPart(partOfText);
        }
    }
}
