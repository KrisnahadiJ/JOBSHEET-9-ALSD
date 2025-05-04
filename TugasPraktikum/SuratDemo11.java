package TugasPraktikum;
import java.util.Scanner;

public class SuratDemo11 {
    public static void main(String[] args) {
        StackSurat11 stack = new StackSurat11(10); // Kapasitas stack adalah 10 surat
        Scanner sc = new Scanner(System.in);
        int pilih;
        
        do {
            System.out.println("\n=== SISTEM PENGELOLAAN SURAT IZIN MAHASISWA ===");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-4): ");
            pilih = sc.nextInt();
            sc.nextLine(); // Membersihkan buffer
            
            switch (pilih) {
                case 1: // Terima Surat Izin
                    System.out.println("\n=== TERIMA SURAT IZIN ===");
                    System.out.print("ID Surat: ");
                    String idSurat = sc.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String namaMahasiswa = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    
                    char jenisIzin;
                    do {
                        System.out.print("Jenis Izin (S: Sakit, I: Izin keperluan lain): ");
                        jenisIzin = sc.nextLine().toUpperCase().charAt(0);
                        if (jenisIzin != 'S' && jenisIzin != 'I') {
                            System.out.println("Input tidak valid! Masukkan S atau I.");
                        }
                    } while (jenisIzin != 'S' && jenisIzin != 'I');
                    
                    System.out.print("Durasi izin (hari): ");
                    int durasi = sc.nextInt();
                    sc.nextLine(); // Membersihkan buffer
                    
                    Surat11 surat = new Surat11(idSurat, namaMahasiswa, kelas, jenisIzin, durasi);
                    stack.push(surat);
                    break;
                
                case 2: // Proses Surat Izin
                    System.out.println("\n=== PROSES SURAT IZIN ===");
                    Surat11 prosesedSurat = stack.pop();
                    if (prosesedSurat != null) {
                        System.out.println("Surat berhasil diproses dengan detail:");
                        System.out.println("------------------------");
                        System.out.println("ID Surat: " + prosesedSurat.idSurat);
                        System.out.println("Nama Mahasiswa: " + prosesedSurat.namaMahasiswa);
                        System.out.println("Kelas: " + prosesedSurat.kelas);
                        System.out.println("Jenis Izin: " + (prosesedSurat.jenisIzin == 'S' ? "Sakit" : "Izin keperluan lain"));
                        System.out.println("Durasi: " + prosesedSurat.durasi + " hari");
                        System.out.println("------------------------");
                    }
                    break;
                
                case 3: // Lihat Surat Izin Terakhir
                    System.out.println("\n=== LIHAT SURAT IZIN TERAKHIR ===");
                    Surat11 lastSurat = stack.peek();
                    if (lastSurat != null) {
                        System.out.println("Detail surat izin terakhir:");
                        System.out.println("------------------------");
                        System.out.println("ID Surat: " + lastSurat.idSurat);
                        System.out.println("Nama Mahasiswa: " + lastSurat.namaMahasiswa);
                        System.out.println("Kelas: " + lastSurat.kelas);
                        System.out.println("Jenis Izin: " + (lastSurat.jenisIzin == 'S' ? "Sakit" : "Izin keperluan lain"));
                        System.out.println("Durasi: " + lastSurat.durasi + " hari");
                        System.out.println("------------------------");
                    }
                    break;
                
                case 4: // Cari Surat
                    System.out.println("\n=== CARI SURAT ===");
                    System.out.print("Masukkan nama mahasiswa: ");
                    String cariNama = sc.nextLine();
                    stack.cariSurat(cariNama);
                    break;
                
                case 0: // Keluar
                    System.out.println("Terima kasih telah menggunakan sistem pengelolaan surat izin mahasiswa!");
                    break;
                
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 0-4.");
            }
        } while (pilih != 0);
        
        sc.close();
    }
}