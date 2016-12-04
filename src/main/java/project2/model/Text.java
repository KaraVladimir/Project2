package project2.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Text extends CompositePartOfText {
    CharSequence charSequence;
    private static Pattern pattern = initPattern();

    public Text(CharSequence charSequence) {
        this.charSequence = charSequence;
    }

    private static Pattern initPattern() {
        String s = "([А-ЯA-Z]([^?!.])*[.?!])";
        return Pattern.compile(s);
    }

    @Override
    public void parse() {
        Matcher matcher = pattern.matcher(charSequence);
        while (matcher.find()) {
            PartOfText partOfText = new Sentence(matcher.group());
            partOfText.parse();
            addPart(partOfText);
        }
    }
}
