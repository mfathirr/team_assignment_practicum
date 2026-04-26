public class QueueLinkedList {
    private Node front;
    private Node rear;
    private int nomorAntreanBerikutnya = 1;

    public boolean isEmpty() {
        return front == null;
    }

    // Menambahkan pelanggan baru ke belakang antrean
    public void tambahPelanggan(String nama) {
        Pelanggan pelanggan = new Pelanggan(nomorAntreanBerikutnya, nama);
        Node newNode = new Node(pelanggan);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        nomorAntreanBerikutnya++;
        System.out.println("Pelanggan " + nama + " berhasil ditambahkan ke antrean.");
        System.out.println("Nomor antrean: " + pelanggan.nomorAntrean);
    }

    // Melayani pelanggan paling depan dan menghapusnya dari antrean
    public void layaniPelanggan() {
        if (isEmpty()) {
            System.out.println("Antrean kosong. Tidak ada pelanggan yang dapat dilayani.");
            return;
        }

        Pelanggan pelangganDilayani = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println("Melayani pelanggan:");
        System.out.println("Nomor Antrean: " + pelangganDilayani.nomorAntrean);
        System.out.println("Nama: " + pelangganDilayani.nama);
    }

    // Menampilkan seluruh daftar pelanggan dalam antrean
    public void tampilkanAntrean() {
        if (isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }

        System.out.println("Daftar Pelanggan dalam Antrean:");
        Node current = front;
        int posisi = 1;

        while (current != null) {
            System.out.println(posisi + ". Nomor Antrean: " + current.data.nomorAntrean + ", Nama: " + current.data.nama);
            current = current.next;
            posisi++;
        }
    }
}
