import java.util.List;
import java.util.ArrayList;

public class Mahasiswa extends SivitasAkademika {
    private String nim;
    private String prodi;
    private List<MataKuliah> mataKuliahDiambil;
    private ManajemenDataImpl manajemenData;

    public Mahasiswa(String nama, String nim, String prodi) {
        super(nama, nim);
        this.nim = nim;
        this.prodi = prodi;
        this.mataKuliahDiambil = new ArrayList<>();
        this.manajemenData = new ManajemenDataImpl(mataKuliahDiambil);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void tampilkanData() {
        System.out.println("Nama Mahasiswa: " + nama + ", NIM: " + nim + ", Program Studi: " + prodi);
        System.out.println("Mata Kuliah yang Diambil: ");
        for (MataKuliah matkul : mataKuliahDiambil) {
            System.out.println("- " + matkul.getNamaMatkul());
        }
    }

    public void daftarMataKuliah(MataKuliah mataKuliah) {
        manajemenData.daftarMataKuliah(mataKuliah); // Panggil metode dari ManajemenDataImpl
    }

    public void batalMataKuliah(MataKuliah mataKuliah) {
        manajemenData.batalMataKuliah(mataKuliah); // Panggil metode dari ManajemenDataImpl
    }

    public List<MataKuliah> getMataKuliahDiambil() {
        return mataKuliahDiambil;
    }
}