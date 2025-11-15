import java.util.ArrayList;
import java.util.Scanner;

// Classe principale contenant le main
public class tests {
    public static void main(String[] args) {

        // Création d'un LoginManager avec 3 tentatives maximum
        LoginManager loginManager = new LoginManager(3);

        // Lancement du système de connexion
        loginManager.login();
    }
}

// Classe représentant un utilisateur
class User {

    // Attributs privés : nom d'utilisateur et mot de passe
    private String username;
    private String password;

    // Constructeur permettant d'initialiser un utilisateur
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Méthode qui vérifie si le nom + mot de passe correspondent
    public boolean authenticate(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    // Getter pour récupérer le nom de l'utilisateur
    public String getUsername() {
        return username;
    }
}

// Classe qui gère tout le système d'authentification
class LoginManager {

    private ArrayList<User> users; // Liste des utilisateurs autorisés
    private int maxAttempts;      // Nombre maximum de tentatives
    private int currentAttempts;  // Tentatives déjà effectuées
    private Scanner input;        // Scanner pour lire les entrées clavier

    // Constructeur
    public LoginManager(int maxAttempts) {
        this.users = new ArrayList<>(); // Initialisation de la liste
        this.maxAttempts = maxAttempts; // Définition du nombre de tentatives max
        this.currentAttempts = 0;       // Aucune tentative au début
        this.input = new Scanner(System.in); // Scanner pour saisir login/mdp

        initializeUsers(); // On ajoute des utilisateurs prédéfinis
    }

    // Ajoute des utilisateurs dans la liste
    private void initializeUsers() {
        users.add(new User("admin", "password"));
        users.add(new User("juve", "12345"));
        users.add(new User("freddy", "123456"));
    }

    // Méthode pour demander le nom d'utilisateur et le mot de passe
    private String[] promptForCredentials() {
        System.out.print("Entrez votre nom d'utilisateur : ");
        String username = input.nextLine().trim(); // Lecture + suppression espaces

        System.out.print("Entrez votre mot de passe : ");
        String password = input.nextLine(); // Lecture du mot de passe

        // Retourne les deux valeurs dans un tableau
        return new String[]{username, password};
    }

    // Vérifie si les identifiants correspondent à un utilisateur existant
    private boolean verifyCredentials(String username, String password) {
        for (User user : users) { // On parcourt chaque utilisateur
            if (user.authenticate(username, password)) { // Vérification
                return true;
            }
        }
        return false; // Aucun utilisateur trouvé → identifiants incorrects
    }

    // Affiche le nombre de tentatives restantes
    private void displayAttemptsRemaining() {
        int remaining = maxAttempts - currentAttempts;
        if (remaining > 0) {
            System.out.println(
                "Nom d'utilisateur ou mot de passe incorrect. Il vous reste "
                + remaining + " tentative(s).\n"
            );
        }
    }

    // Méthode principale du login
    public boolean login() {

        System.out.println("========== SYSTÈME DE CONNEXION ==========\n");

        // Boucle tant que les tentatives n'atteignent pas la limite
        while (currentAttempts < maxAttempts) {

            // On demande nom + mot de passe
            String[] credentials = promptForCredentials();
            String username = credentials[0];
            String password = credentials[1];

            // Si les identifiants sont valides
            if (verifyCredentials(username, password)) {
                System.out.println("\n Connexion réussie ! Bienvenue " + username + " !\n");
                return true;
            } 
            // Si identifiants incorrects
            else {
                currentAttempts++; // On augmente le compteur de tentatives
                displayAttemptsRemaining(); // On affiche le nombre restant
            }
        }

        // Si toutes les tentatives sont utilisées
        System.out.println("Vous avez dépassé le nombre maximum de tentatives de connexion.\n");
        return false;
    }
}
