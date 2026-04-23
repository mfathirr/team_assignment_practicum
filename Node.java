public class Node {
    Mahasiswa data;
    Node prev, next;

    public Node(Mahasiswa data) {
        this.data = data;
        next = null;
        prev = null;
    }
}
