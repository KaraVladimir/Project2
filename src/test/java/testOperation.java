import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import project2.model.Operation;
import project2.model.PartOfText;
import project2.model.entity.Text;
import project2.model.operation.OperationVariant13;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class testOperation {
    static PartOfText text;
    static String testedText = Storage.TEST_TEXT_FOR_SORT;

    @BeforeClass
    public static void initTest() {
        text = Text.getInstance();
        text.parse(testedText);
    }

    @Test
    public void testOperation13() {
        Operation operation = Operation.getOperation('в');
        List<String> list = operation.doOperation(operation.prepareStream(text)).collect(Collectors.toList());
        Assert.assertTrue(list.get(0).equals(Storage.MAX_CHAR));
    }
}
