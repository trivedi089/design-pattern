package main.BehaviouralPatterns.MementoPattern;


import java.util.Stack;

// Memento: stores state
class TextMemento {
    private final String state;

    public TextMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator: creates and restores mementos
class TextEditor1 {
    private String text = "";

    public void type(String newText) {
        text += newText;
    }

    public String getText() {
        return text;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        text = memento.getState();
    }
}

// Caretaker: manages history
class History {
    private Stack<TextMemento> history = new Stack<>();

    public void save(TextEditor1 editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor1 editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        }
    }
}

public class MementoPatternExample {
    public static void main(String[] args) {
        TextEditor1 editor = new TextEditor1();
        History history = new History();

        editor.type("Hello ");
        history.save(editor);

        editor.type("World");
        history.save(editor);

        System.out.println(editor.getText()); // Hello World

        history.undo(editor);
        System.out.println(editor.getText()); // Hello

        history.undo(editor);
        System.out.println(editor.getText()); // ""
    }
}
