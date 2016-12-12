import project2.controller.Controller;
import project2.model.entity.Model;
import project2.view.View;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.process();
    }
}
