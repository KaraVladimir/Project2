package project2;

import project2.controller.Controller;
import project2.model.Model;
import project2.model.Text;
import project2.view.View;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Stream<String> s = Files.lines(Paths.get("E:\\1\\master.txt"), StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        s.forEach(stringBuilder::append);
        Text t = new Text(stringBuilder);
        t.parse();
        StringBuilder builderResult = new StringBuilder();
        t.getText(builderResult);
        System.out.println(builderResult.toString());

        // Initialization
//        Model model = new Model();
//        View view = new View();
//        Controller controller = new Controller(view, model);
//        // Run
//        controller.process();
    }
}
