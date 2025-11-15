import java.util.ArrayList;
import java.util.Scanner;

public class tests {
    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager(3);
        loginManager.login();
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public String getUsername() {
        return username;
    }
}

class LoginManager {
    private ArrayList<User> users;
    private int maxAttempts;
    private int currentAttempts;
    private Scanner input;

    public LoginManager(int maxAttempts) {
        this.users = new ArrayList<>();
        this.maxAttempts = maxAttempts;
        this.currentAttempts = 0;
        this.input = new Scanner(System.in);
        initializeUsers();
    }

    private void initializeUsers() {
        users.add(new User("admin", "password"));
        users.add(new User("juve", "12345"));
        users.add(new User("freddy", "123456"));
    }

    private String[] promptForCredentials() {
        System.out.print("Entrez votre nom d'utilisateur : ");
        String username = input.nextLine().trim();

        System.out.print("Entrez votre mot de passe : ");
        String password = input.nextLine();

        return new String[]{username, password};
    }

    private boolean verifyCredentials(String username, String password) {
        for (User user : users) {
            if (user.authenticate(username, password)) {
                return true;
            }
        }
        return false;
    }

    private void displayAttemptsRemaining() {
        int remaining = maxAttempts - currentAttempts;
        if (remaining > 0) {
            System.out.println("Nom d'utilisateur ou mot de passe incorrect. Il vous reste " + remaining + " tentative(s).\n");
        }
    }

    public boolean login() {
        System.out.println("========== SYSTÈME DE CONNEXION ==========\n");

        while (currentAttempts < maxAttempts) {
            String[] credentials = promptForCredentials();
            String username = credentials[0];
            String password = credentials[1];

            if (verifyCredentials(username, password)) {
                System.out.println("\n Connexion réussie ! Bienvenue " + username + " !\n");
                input.close();
                return true;
            } else {
                currentAttempts++;
                displayAttemptsRemaining();
            }
        }

        System.out.println("Vous avez dépassé le nombre maximum de tentatives de connexion.\n");
        input.close();
        return false;
    }
}