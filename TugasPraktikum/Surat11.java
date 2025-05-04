package TugasPraktikum;

public class Surat11 {
    String idSurat;
    String namaMahasiswa;
    String kelas;
    char jenisIzin; 
    int durasi; 
    
    public Surat11() {
        // Konstruktor default
    }
    
    public Surat11(String idSurat, String namaMahasiswa, String kelas, char jenisIzin, int durasi) {
        this.idSurat = idSurat;
        this.namaMahasiswa = namaMahasiswa;
        this.kelas = kelas;
        this.jenisIzin = jenisIzin;
        this.durasi = durasi;
    }
}