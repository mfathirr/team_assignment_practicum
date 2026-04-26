import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueLinkedList antrean = new QueueLinkedList();
        int pilihan;

        do {
            System.out.println("\n=== Sistem Manajemen Antrean Customer Service ===");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Daftar Antrean");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = scanner.nextLine();
                    antrean.tambahPelanggan(nama);
                    break;

                case 2:
                    antrean.layaniPelanggan();
                    break;

                case 3:
                    antrean.tampilkanAntrean();
                    break;

                case 4:
                    System.out.println("Sistem antrean selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
