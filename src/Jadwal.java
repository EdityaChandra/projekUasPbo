public class Jadwal {
    private String hari;
    private String jam;

    // construk
    public Jadwal(String hari, String jam) {
        this.hari = hari;
        this.jam = jam;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    //cek bentrok
    public boolean isBentrok(Jadwal other) {
        return this.hari.equals(other.hari) && this.jam.equals(other.jam);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Jadwal) {
            Jadwal other = (Jadwal) obj;
            return this.hari.equals(other.hari) && this.jam.equals(other.jam);
        }
        return false;
    }

    public void tampilkanJadwal() {
        System.out.println("Hari: " + hari + ", Jam: " + jam);
    }
}
