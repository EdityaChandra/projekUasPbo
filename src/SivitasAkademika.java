public abstract class SivitasAkademika {
    protected String nama;
    protected String id;

    public SivitasAkademika(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void tampilkanData();
}
