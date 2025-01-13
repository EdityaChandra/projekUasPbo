import java.util.ArrayList;
import java.util.List;

public class Dosen extends SivitasAkademika {
    private String nidn;
    private List<MataKuliah> mataKuliah;

    public Dosen(String nama, String nidn) {
        super(nama, nidn);
        this.nidn = nidn;
        this.mataKuliah = new ArrayList<>();
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public void tambahMataKuliah(MataKuliah matkul) {
        mataKuliah.add(matkul);
    }


    public void tambahMataKuliah(String kode, String namaMatkul, int sks, Dosen dosenPengampu, int kuota, Jadwal jadwal, String hari, String jam) {
        MataKuliah matkul = new MataKuliah(kode, namaMatkul, sks, dosenPengampu, kuota, jadwal, hari, jam);
        mataKuliah.add(matkul);
    }

    public void tampilkanData() {
        System.out.println("Nama Dosen: " + nama + ", NIDN: " + nidn);
        System.out.println("Mata Kuliah yang Diajarkan: ");
        for (MataKuliah matkul : mataKuliah) {
            System.out.println("- " + matkul.getNamaMatkul());
        }
    }

    public List<MataKuliah> getMataKuliah() {
        return mataKuliah;
    }
}
