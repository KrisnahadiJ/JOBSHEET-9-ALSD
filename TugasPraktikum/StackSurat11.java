package TugasPraktikum;

public class StackSurat11 {
    Surat11[] stack;
    int size;
    int top;
    
    public StackSurat11(int size) {
        this.size = size;
        stack = new Surat11[size];
        top = -1;
    }
    
    public boolean isFull() {
        return top == size - 1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public void push(Surat11 srt) {
        if (!isFull()) {
            top++;
            stack[top] = srt;
            System.out.println("Surat izin berhasil diterima.");
        } else {
            System.out.println("Stack sudah penuh! Tidak dapat menerima surat lagi.");
        }
    }
    
    public Surat11 pop() {
        if (!isEmpty()) {
            Surat11 srt = stack[top];
            top--;
            return srt;
        } else {
            System.out.println("Stack masih kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }
    
    public Surat11 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack masih kosong! Tidak ada surat untuk dilihat.");
            return null;
        }
    }
    
    public void cariSurat(String nama) {
        boolean ditemukan = false;
        if (isEmpty()) {
            System.out.println("Stack masih kosong! Tidak ada surat untuk dicari.");
        } else {
            System.out.println("\nHasil pencarian surat atas nama " + nama + ":");
            for (int i = top; i >= 0; i--) {
                if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                    ditemukan = true;
                    System.out.println("------------------------");
                    System.out.println("ID Surat: " + stack[i].idSurat);
                    System.out.println("Nama Mahasiswa: " + stack[i].namaMahasiswa);
                    System.out.println("Kelas: " + stack[i].kelas);
                    System.out.println("Jenis Izin: " + (stack[i].jenisIzin == 'S' ? "Sakit" : "Izin keperluan lain"));
                    System.out.println("Durasi: " + stack[i].durasi + " hari");
                    System.out.println("------------------------");
                }
            }
            if (!ditemukan) {
                System.out.println("Surat atas nama " + nama + " tidak ditemukan!");
            }
        }
    }
}