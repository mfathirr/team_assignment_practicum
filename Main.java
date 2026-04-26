import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object daftarMahasiswa = pilihStrukturData(scanner);
        TextEditor editor = new TextEditor();
        int pilihan;

        do {
            System.out.println("\n=== Sistem Manajemen Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("5. Ganti Struktur Data");
            System.out.println("6. Text Editor (Undo/Redo)");
            System.out.println("7. Benchmark Timer");
            System.out.println("`8. Keluar");
            System.out.print("Pilih menu (1-7): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    int nim = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    int nilai = scanner.nextInt();
                    if (daftarMahasiswa instanceof SingleLinkedList) {
                        ((SingleLinkedList) daftarMahasiswa).tambahMahasiswa(nim, nama, nilai);
                    } else {
                        ((DoulbyLinkedList) daftarMahasiswa).tambahMahasiswa(nim, nama, nilai);
                    }
                    break;

                case 2:
                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    int nimHapus = scanner.nextInt();
                    if (daftarMahasiswa instanceof SingleLinkedList) {
                        ((SingleLinkedList) daftarMahasiswa).hapusMahasiswa(nimHapus);
                    } else {
                        ((DoulbyLinkedList) daftarMahasiswa).hapusMahasiswa(nimHapus);
                    }
                    break;

                case 3:
                    System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
                    int nimUpdate = scanner.nextInt();
                    System.out.print("Masukkan nilai baru: ");
                    int nilaiBaru = scanner.nextInt();
                    if (daftarMahasiswa instanceof SingleLinkedList) {
                        ((SingleLinkedList) daftarMahasiswa).updateNilai(nimUpdate, nilaiBaru);
                    } else {
                        ((DoulbyLinkedList) daftarMahasiswa).updateNilai(nimUpdate, nilaiBaru);
                    }
                    break;

                case 4:
                    if (daftarMahasiswa instanceof SingleLinkedList) {
                        ((SingleLinkedList) daftarMahasiswa).tampilkanMahasiswa();
                    } else {
                        ((DoulbyLinkedList) daftarMahasiswa).tampilkanMahasiswa();
                    }
                    break;

                case 5:
                    daftarMahasiswa = pilihStrukturData(scanner);
                    break;

                case 6:
                    int pilihanEditor;
                    do {
                        System.out.println("\n=== TEXT EDITOR ===");
                        System.out.println("1. Tambah Teks");
                        System.out.println("2. Undo");
                        System.out.println("3. Redo");
                        System.out.println("4. Tampilkan Teks");
                        System.out.println("5. Kembali");
                        System.out.print("Pilih: ");
                        pilihanEditor = scanner.nextInt();
                        scanner.nextLine();

                        switch (pilihanEditor) {
                            case 1:
                                System.out.print("Masukkan teks: ");
                                String teks = scanner.nextLine();
                                editor.tambahTeks(teks);
                                break;

                            case 2:
                                editor.undo();
                                break;

                            case 3:
                                editor.redo();
                                break;

                            case 4:
                                editor.tampilkan();
                                break;

                            case 5:
                                System.out.println("Kembali ke menu utama");
                                break;

                            default:
                                System.out.println("Pilihan tidak valid");
                        }
                    } while (pilihanEditor != 5);
                    break;
                    
                case 7:
                    Benchmark.runAllTests();
                    break;

                case 8:
                    System.out.println("Sistem selesai");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi");
            }
        } while (pilihan != 6);

        scanner.close();
    }

    private static Object pilihStrukturData(Scanner scanner) {
        System.out.println("=== Pilih Struktur Data ===");
        System.out.println("1. Single Linked List");
        System.out.println("2. Doubly Linked List");
        System.out.print("Pilih struktur data (1-2): ");
        int pilihanStruktur = scanner.nextInt();

        if (pilihanStruktur == 1) {
            SingleLinkedList list = new SingleLinkedList();
            list.buatDummyData();
            System.out.println("Menggunakan Single Linked List");
            return list;
        } else if (pilihanStruktur == 2) {
            DoulbyLinkedList list = new DoulbyLinkedList();
            list.buatDummyData();
            System.out.println("Menggunakan Doubly Linked List");
            return list;
        } else {
            System.out.println("Pilihan tidak valid. Menggunakan Single Linked List sebagai default.");
            SingleLinkedList list = new SingleLinkedList();
            list.buatDummyData();
            return list;
        }
    }
}
