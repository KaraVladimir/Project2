import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import project2.model.Operation;
import project2.model.PartOfText;
import project2.model.entity.*;
import project2.model.operation.OperationVariant13;

import java.util.ArrayList;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class testEntities {
    static PartOfText text;
    static String testedText = Storage.TEST_TEXT;

    @BeforeClass
    public static void initTest() {
        text = Text.getInstance();
        text.parse(testedText);
    }

    @Test
    public void isTextParsed() {
        Assert.assertEquals(text.getText(new StringBuilder()).toString(),testedText);
    }

    @Test
    public void testSentenceParsing() {
        Text textInn = (Text) text;
        Sentence sentence = (Sentence) textInn.getPart(0);
        Assert.assertEquals(sentence.getText(new StringBuilder()).toString(),Storage.FIRST_SENTENCE);
    }

    @Test
    public void testWordParsing() {
        Text textInn = (Text) text;
        Sentence sentence = (Sentence) textInn.getPart(0);
        Word word1 = (Word) sentence.getPart(0);
        Word word2 = (Word) sentence.getPart(2);
        Assert.assertEquals(word1.getText(new StringBuilder()).toString(),Storage.FIRST_EL);
        Assert.assertEquals(word2.getText(new StringBuilder()).toString(),Storage.THIRD_EL);
    }

    @Test
    public void testSeparatorParsing() {
        Text textInn = (Text) text;
        Sentence sentence = (Sentence) textInn.getPart(0);
        Separator separator = (Separator) sentence.getPart(1);
        Assert.assertEquals(separator.getText(new StringBuilder()).toString(),Storage.SECOND_EL);
    }

    @Test
    public void testMarkParsing() {
        Text textInn = (Text) text;
        Sentence sentence = (Sentence) textInn.getPart(0);
        PunctuationMark mark = (PunctuationMark) sentence.getPart(3);
        Assert.assertEquals(mark.getText(new StringBuilder()).toString(),Storage.FOURTH_EL);
    }

}
