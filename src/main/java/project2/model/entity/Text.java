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
public enum Text implements CompositePartOfText {
    INSTANCE;
    List <PartOfText>list=new ArrayList<>();
    private static Pattern pattern = initPattern();

    private static Pattern initPattern() {
        String s = "(\\s*[А-ЯA-Z]([^?!.])*[.?!])";
        return Pattern.compile(s);
    }

    @Override
    public List<PartOfText> getList() {
        return list;
    }

    @Override
    public void parse(CharSequence charSequence) {
        Matcher matcher = pattern.matcher(charSequence);
        while (matcher.find()) {
            PartOfText partOfText = new Sentence();
            partOfText.parse(matcher.group());
            addPart(partOfText);
        }
    }

    public static PartOfText getInstance() {
        return INSTANCE;
    }
    }
