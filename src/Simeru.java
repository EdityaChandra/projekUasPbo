import java.util.ArrayList;
import java.util.List;

public class Simeru {
    private List<Prodi> prodiList;
    private List<Mahasiswa> mahasiswaList;
    private List<Dosen> dosenList;

    public Simeru() {
        prodiList = new ArrayList<>();
        mahasiswaList = new ArrayList<>();
        dosenList = new ArrayList<>();
    }

    public void tambahProdi(Prodi prodi) {
        prodiList.add(prodi);
    }

    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaList.add(mahasiswa);
    }

    public void tambahDosen(Dosen dosen) {
        dosenList.add(dosen);
    }

    public void tampilkanSemuaData() {
        System.out.println("Daftar Prodi:");
        for (Prodi prodi : prodiList) {
            System.out.println("- " + prodi.getNamaProdi());
        }

        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa mahasiswa : mahasiswaList) {
            mahasiswa.tampilkanData();
        }

        System.out.println("Daftar Dosen:");
        for (Dosen dosen : dosenList) {
            dosen.tampilkanData();
        }
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    public List<MataKuliah> getMataKuliahListFromDosen(Dosen dosen) {
        return dosen.getMataKuliah();
    }


}
