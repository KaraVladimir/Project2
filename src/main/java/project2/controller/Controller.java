package project2.controller;

import project2.model.entity.Model;
import project2.view.View;

import java.util.Scanner;

/**
 * @author kara.vladimir2@gmail.com.
 */
public class Controller {
    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input char code");
        while (true) {
            if (scanner.hasNextInt()) {
                char c = (char) scanner.nextInt();
                processTask(c);
                break;
            }
        }
    }

    private void processTask(char c) {
        model.doTask(c,"e:\\1\\m1.txt","e:\\1\\m1Sort.txt");
    }
}
