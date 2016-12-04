package project2.controller;

import project2.model.Model;
import project2.view.View;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void process() {

    }
}
