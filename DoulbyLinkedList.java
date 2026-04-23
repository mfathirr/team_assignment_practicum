public class DoulbyLinkedList {
    Node head;
    Node tail;

    // Menambahkan mahasiswa baru
    public void tambahMahasiswa(int nim, String nama, int nilai) {
        Mahasiswa mhs = new Mahasiswa(nim, nama, nilai);
        Node newNode = new Node(mhs);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Mahasiswa " + nama + " berhasil ditambahkan.");
        tampilkanMahasiswa();
    }

    public void buatDummyData() {
        buatDummyDataMahasiswa(12345, "Andi", 85);
        buatDummyDataMahasiswa(67890, "Budi", 90);
    }

    private void buatDummyDataMahasiswa(int nim, String nama, int nilai) {
        Mahasiswa mhs = new Mahasiswa(nim, nama, nilai);
        Node newNode = new Node(mhs);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Menghapus mahasiswa berdasarkan NIM
    public void hapusMahasiswa(int nim) {
        if (head == null) {
            System.out.println("Daftar mahasiswa kosong.");
            return;
        }

        Node current = head;

        // Cari node dengan NIM yang sesuai
        while (current != null && current.data.nim != nim) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        // Jika node yang akan dihapus adalah head
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        }
        // Jika node yang akan dihapus adalah tail
        else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // Jika node di tengah
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
        tampilkanMahasiswa();
    }

    // Mengupdate nilai mahasiswa berdasarkan NIM
    public void updateNilai(int nim, int nilaiBaru) {
        Node current = head;
        while (current != null) {
            if (current.data.nim == nim) {
                current.data.nilai = nilaiBaru;
                System.out.println("Mengupdate nilai mahasiswa (" + current.data.nama + " -> " + nilaiBaru + ")");
                tampilkanMahasiswa();
                return;
            }
            current = current.next;
        }
        System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
    }

    // Menampilkan daftar mahasiswa
    public void tampilkanMahasiswa() {
        if (head == null) {
            System.out.println("Daftar mahasiswa kosong.");
            return;
        }

        System.out.println("Daftar Mahasiswa:");
        System.out.println();

        Node current = head;
        int counter = 1;
        while (current != null) {
            System.out.println(counter + ". NIM: " + current.data.nim + ", Nama: " + current.data.nama + ", Nilai: "
                    + current.data.nilai);
            current = current.next;
            counter++;
        }
    }
}
