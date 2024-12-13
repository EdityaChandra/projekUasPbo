public class Mahasiswa extends AktifitasAkademik {
    String nim;
    String prodi;
    int semester;

    public void daftarMatkul(String matkul) {

    }

    public void batalkanMatkul(String matkul) {

    }

    public double hitungIP(List<Double> nilai) {

        double total = 0;
        for (double n : nilai) {
            total += n;
        }
        return total / nilai.size();
    }
}
