public class Pengguna {
    protected String id;
    protected Date tanggalLahir;

    public boolean validasiData() {
        return id != null && !id.isEmpty() && tanggalLahir != null;
    }
}
