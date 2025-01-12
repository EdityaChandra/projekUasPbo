public class MataKuliah {
    private String kode;
    private String namaMatkul;
    private int sks;
    private Dosen dosenPengampu;
    private int kuota;
    private Jadwal jadwal;

    public MataKuliah(String kode, String namaMatkul, int sks, Dosen dosenPengampu, int kuota, Jadwal jadwal,  String hari, String jam) {
        this.kode = kode;
        this.namaMatkul = namaMatkul;
        this.sks = sks;
        this.dosenPengampu = dosenPengampu;
        this.kuota = kuota;
        this.jadwal = new Jadwal(hari, jam);
    }


    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }
    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public int getKuota() {
        return kuota;
    }

    public void setKuota(int kuota) {
        this.kuota = kuota;
    }

    public void decrementKuota() {
        if (kuota > 0) kuota--;
    }

    public void incrementKuota() {
        kuota++;
    }

    public void tampilkanData() {
        System.out.println("Kode: " + kode + ", Nama Mata Kuliah: " + namaMatkul + ", SKS: " + sks);
        System.out.println("Dosen Pengampu: " + dosenPengampu.getNama() + ", Kuota: " + kuota);
        jadwal.tampilkanJadwal();
    }
}
