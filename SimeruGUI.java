import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimeruGUI extends JFrame {
    private Simeru simeru;

    public SimeruGUI(Simeru simeru) {
        this.simeru = simeru;
        setTitle("Simeru Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        JButton btnTambahMahasiswa = new JButton("Tambah Mahasiswa");
        JButton btnTambahDosen = new JButton("Tambah Dosen");
        JButton btnTambahMataKuliah = new JButton("Tambah Mata Kuliah");
        JButton btnDaftarMataKuliah = new JButton("Daftar Mata Kuliah");
        JButton btnBatalkanMataKuliah = new JButton("Batalkan Mata Kuliah");
        JButton btnTampilkanSemuaData = new JButton("Tampilkan Semua Data");
        JButton btnKeluar = new JButton("Keluar");

        btnTambahMahasiswa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahMahasiswa();
            }
        });

        btnTambahDosen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahDosen();
            }
        });

        btnTambahMataKuliah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahMataKuliah();
            }
        });

        btnDaftarMataKuliah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daftarMataKuliah();
            }
        });

        btnBatalkanMataKuliah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                batalkanMataKuliah();
            }
        });

        btnTampilkanSemuaData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilkanSemuaData();
            }
        });

        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(btnTambahMahasiswa);
        panel.add(btnTambahDosen);
        panel.add(btnTambahMataKuliah);
        panel.add(btnDaftarMataKuliah);
        panel.add(btnBatalkanMataKuliah);
        panel.add(btnTampilkanSemuaData);
        panel.add(btnKeluar);

        add(panel);
    }

    private void tambahMahasiswa() {
        String nama = JOptionPane.showInputDialog(this, "Nama Mahasiswa:");
        String nim = JOptionPane.showInputDialog(this, "NIM Mahasiswa:");
        String namaProdi = JOptionPane.showInputDialog(this, "Program Studi:");
        Prodi prodi = new Prodi(namaProdi);
        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, prodi);
        simeru.tambahMahasiswa(mahasiswa);
    }


    private void tambahDosen() {
        String nama = JOptionPane.showInputDialog(this, "Nama Dosen:");
        String nidn = JOptionPane.showInputDialog(this, "NIDN Dosen:");
        Dosen dosen = new Dosen(nama, nidn);
        simeru.tambahDosen(dosen);
    }

    private void tambahMataKuliah() {
        String kode = JOptionPane.showInputDialog(this, "Kode Mata Kuliah:");
        String namaMatkul = JOptionPane.showInputDialog(this, "Nama Mata Kuliah:");
        int sks = Integer.parseInt(JOptionPane.showInputDialog(this, "Jumlah SKS:"));

        // Pilih dosen pengampu
        Dosen[] dosenArray = simeru.getDosenList().toArray(new Dosen[0]);
        Dosen dosen = (Dosen) JOptionPane.showInputDialog(this, "Pilih Dosen Pengampu:", "Dosen Pengampu",
                JOptionPane.QUESTION_MESSAGE, null, dosenArray, dosenArray[0]);

        // Pilih jadwal
        String hari = JOptionPane.showInputDialog(this, "Hari Mata Kuliah:");
        String jam = JOptionPane.showInputDialog(this, "Jam Mata Kuliah:");

        Jadwal jadwal = new Jadwal(hari, jam);
        MataKuliah mataKuliah = new MataKuliah(kode, namaMatkul, sks, dosen, 30, jadwal, hari, jam);

        dosen.tambahMataKuliah(mataKuliah);
    }

    private void daftarMataKuliah() {
        Mahasiswa[] mahasiswaArray = simeru.getMahasiswaList().toArray(new Mahasiswa[0]);
        Mahasiswa mahasiswa = (Mahasiswa) JOptionPane.showInputDialog(this, "Pilih Mahasiswa:", "Mahasiswa",
                JOptionPane.QUESTION_MESSAGE, null, mahasiswaArray, mahasiswaArray[0]);

        MataKuliah[] mataKuliahArray = simeru.getDosenList().stream()
                .flatMap(dosen -> dosen.getMataKuliah().stream())
                .toArray(MataKuliah[]::new);
        MataKuliah mataKuliah = (MataKuliah) JOptionPane.showInputDialog(this, "Pilih Mata Kuliah:", "Mata Kuliah",
                JOptionPane.QUESTION_MESSAGE, null, mataKuliahArray, mataKuliahArray[0]);

        mahasiswa.daftarMataKuliah(mataKuliah);
    }

    private void batalkanMataKuliah() {
        Mahasiswa[] mahasiswaArray = simeru.getMahasiswaList().toArray(new Mahasiswa[0]);
        Mahasiswa mahasiswa = (Mahasiswa) JOptionPane.showInputDialog(this, "Pilih Mahasiswa:", "Mahasiswa",
                JOptionPane.QUESTION_MESSAGE, null, mahasiswaArray, mahasiswaArray[0]);

        MataKuliah[] mataKuliahArray = mahasiswa.getMataKuliahDiambil().toArray(new MataKuliah[0]);
        MataKuliah mataKuliah = (MataKuliah) JOptionPane.showInputDialog(this, "Pilih Mata Kuliah yang Dibatalkan:", "Mata Kuliah",
                JOptionPane.QUESTION_MESSAGE, null, mataKuliahArray, mataKuliahArray[0]);

        mahasiswa.batalMataKuliah(mataKuliah);
    }

    private void tampilkanSemuaData() {
        simeru.tampilkanSemuaData();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Simeru simeru = new Simeru();
                new SimeruGUI(simeru).setVisible(true);
            }
        });
    }
}
