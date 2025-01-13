import java.util.Scanner;

public class Pengguna extends SivitasAkademika {
    private String username;
    private String password;

    public Pengguna(String username, String password) {
        super(username, password);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public boolean requestLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Login =====");
        System.out.print("Username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Password: ");
        String passwordInput = scanner.nextLine();

        if (login(usernameInput, passwordInput)) {
            System.out.println("Login berhasil!");
            return true;
        } else {
            System.out.println("Login gagal. Username atau password salah.");
            return false;
        }
    }

    @Override
    public void tampilkanData() {
        System.out.println("Username: " + username + ", Password: " + password);
    }
}
