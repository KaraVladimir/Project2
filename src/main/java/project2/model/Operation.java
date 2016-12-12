package project2.model;

import project2.model.operation.OperationVariant13;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author kara.vladimir2@gmail.com.
 */
public interface Operation {

    Stream<String> prepareStream(PartOfText partOfText);

    Stream<String> doOperation(Stream<String>stream);

    default void fillListOfElementsSpecificType(Class clazz, PartOfText partOfText, List<PartOfText> list) {
        ((CompositePartOfText) partOfText).getList().stream().forEach((p) -> {
            if(p.getClass()==clazz) list.add(p);
            if (p.isComposite()) {
                fillListOfElementsSpecificType(clazz, p,list);
            } else {
                return;
            }
        });
        return;
    }

    static Operation getOperation(char c) {
        OperationVariant13 o = OperationVariant13.INSTANCE;
        o.setPattern(c);
        return o;
    }
}
