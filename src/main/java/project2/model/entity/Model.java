package project2.model.entity;

import project2.model.DataLoader;
import project2.model.Operation;
import project2.model.PartOfText;
import project2.model.loader.FileLoader;

import java.util.stream.Stream;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Model {
    private PartOfText text = Text.getInstance();

    public void doTask(char c,String fileS,String fileD) {
        DataLoader dataLoader = new FileLoader(fileS, fileD);
        text.parse(dataLoader.getContent());
        Operation oper = Operation.getOperation(c);
        Stream<String> stream = oper.doOperation(oper.prepareStream(text));
        dataLoader.saveStream(stream);
    }
}
