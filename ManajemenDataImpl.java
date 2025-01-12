import java.util.List;

public class ManajemenDataImpl implements ManajemenData {
    private List<MataKuliah> mataKuliahDiambil;

    public ManajemenDataImpl(List<MataKuliah> mataKuliahDiambil) {
        this.mataKuliahDiambil = mataKuliahDiambil;
    }

    @Override
    public void daftarMataKuliah(MataKuliah mataKuliah) {
        if (isJadwalBentrokan(mataKuliah)) {
            System.out.println("Pendaftaran gagal, jadwal mata kuliah ini bentrok dengan mata kuliah yang sudah diambil.");
        } else {
            mataKuliahDiambil.add(mataKuliah);
            System.out.println("Mata kuliah " + mataKuliah.getNamaMatkul() + " berhasil didaftarkan.");
        }
    }

    @Override
    public void batalMataKuliah(MataKuliah mataKuliah) {
        mataKuliahDiambil.remove(mataKuliah);
        System.out.println("Mata kuliah " + mataKuliah.getNamaMatkul() + " berhasil dibatalkan.");
    }

    @Override
    public boolean isJadwalBentrokan(MataKuliah mataKuliah) {
        for (MataKuliah m : mataKuliahDiambil) {
            if (m.getJadwal().equals(mataKuliah.getJadwal())) {
                return true;
            }
        }
        return false;
    }
}
