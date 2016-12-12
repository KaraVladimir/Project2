package project2.model.operation;

import project2.model.Operation;
import project2.model.PartOfText;
import project2.model.entity.Word;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author kara.vladimir2@gmail.com.
 */
public enum OperationVariant13 implements Operation {
    INSTANCE;

    Pattern pattern;

    public void setPattern(char c) {
        pattern = Pattern.compile((String.valueOf(c)));
    }

    @Override
    public Stream<String> doOperation(Stream<String> stringStream) {
        return stringStream.sorted(((Comparator<String>) this::compareByChar)
                .thenComparing(this::compareByAlphabet));
    }

    private int compareByChar(String o1, String o2) {
        return (int) Math.signum(getCountChars(o2) - getCountChars(o1));
    }

    private int compareByAlphabet(String o1, String o2) {
        return o1.toLowerCase().compareTo(o2.toLowerCase());
    }

    private int getCountChars(String s) {
        int i = 0;
        Matcher matcher = pattern.matcher(s.toLowerCase());
        while (matcher.find()) {
            i++;
        }
        return i;
    }

    @Override
    public Stream<String> prepareStream(PartOfText partOfText) {
        List<PartOfText> list = new ArrayList<>();
        fillListOfElementsSpecificType(Word.class, partOfText, list);
        return list.stream().map(PartOfText::getText).distinct();
    }

}
