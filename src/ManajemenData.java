public interface ManajemenData {
    void daftarMataKuliah(MataKuliah mataKuliah);
    void batalMataKuliah(MataKuliah mataKuliah);
    boolean isJadwalBentrokan(MataKuliah mataKuliah);
}
