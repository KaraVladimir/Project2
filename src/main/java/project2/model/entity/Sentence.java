package project2.model.entity;

import project2.model.CompositePartOfText;
import project2.model.PartOfText;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Sentence implements CompositePartOfText {
    List<PartOfText> list = new ArrayList<>();
    private static Pattern pattern = initPattern();

    private static Pattern initPattern() {
        String s = "([А-Яа-я\\w]+[^-?!.,:;\"\\s]*)|([-?!.,:;\"]+)|(\\s+)";
        return Pattern.compile(s);
    }

    @Override
    public List<PartOfText> getList() {
        return list;
    }

    @Override
    public void parse(CharSequence charSequence) {
        Matcher matcher = pattern.matcher(charSequence);
        PartOfText partOfText = null;
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                partOfText = new Word();
                partOfText.parse(matcher.group(1));
            } else if (matcher.group(2) != null) {
                partOfText = new PunctuationMark();
                partOfText.parse(matcher.group(2));
            } else if (matcher.group(3) != null) {
                partOfText = new Separator();
                partOfText.parse(matcher.group(3));
            }
            addPart(partOfText);
        }
    }
}
