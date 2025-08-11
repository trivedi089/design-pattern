package main.BehaviouralPatterns.MementoPattern;

import java.util.ArrayList;
import java.util.List;

class TextEditor {
    private String text = "";
    private List<String> history = new ArrayList<>(); // Direct history storage inside main class

    public void type(String newText) {
        history.add(text); // Save current state before changing
        text += newText;
    }

    public void undo() {
        if (!history.isEmpty()) {
            text = history.remove(history.size() - 1);
        }
    }

    public String getText() {
        return text;
    }
}

public class WithoutMementoPattern {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.type("Hello ");
        editor.type("World");
        System.out.println(editor.getText()); // Hello World

        editor.undo();
        System.out.println(editor.getText()); // Hello
    }
}
