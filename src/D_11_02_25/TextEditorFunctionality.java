package D_11_02_25;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
class TextEditor {
    private TextState head, tail, current;
    private final int HISTORY_LIMIT = 10;
    private int size = 0;
    public TextEditor() {
        head = tail = current = null;
    }
    public void addState(String newText) {
        TextState newState = new TextState(newText);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }
        current = newState;
        if (head == null) {
            head = newState;
        }
        tail = newState;
        if (size == HISTORY_LIMIT) {
            head = head.next;
            head.prev = null;
        } else {
            size++;
        }
    }
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo available.");
        }
    }
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo available.");
        }
    }
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}
public class TextEditorFunctionality {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Hello Archi");
        editor.addState("Hello Mayank");
        editor.addState("Hello Khushi");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
