import java.util.Stack;

public class TextEditor {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private String currentText = "";

    // Tambah teks
    public void tambahTeks(String teks) {
        undoStack.push(currentText);
        currentText += teks;
        redoStack.clear();

        System.out.println("Teks saat ini: " + currentText);
    }

    // Undo
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak bisa undo");
            return;
        }

        redoStack.push(currentText);
        currentText = undoStack.pop();

        System.out.println("Undo: " + currentText);
    }

    // Redo
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak bisa redo");
            return;
        }

        undoStack.push(currentText);
        currentText = redoStack.pop();

        System.out.println("Redo: " + currentText);
    }

    // Tampilkan teks
    public void tampilkan() {
        System.out.println("Teks saat ini: " + currentText);
    }
}