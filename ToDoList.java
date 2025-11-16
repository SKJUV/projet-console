// ToDoList.java
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private static class Tache {
        String description;
        boolean réalisée;

        Tache(String description) {
            this.description = description;
            this.réalisée = false;
        }

        @Override
        public String toString() {
            return (réalisée ? "[Done] " : "[ ] ") + description;
        }
    }

    private final ArrayList<Tache> taches = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    private void ajouterTache(String description) {
        taches.add(new Tache(description));
        System.out.println("Done Tâche ajoutée !");
    }

    private void afficherTaches() {
        if (taches.isEmpty()) {
            System.out.println("Aucune tâche pour le moment.");
            return;
        }
        System.out.println("\n--- Ma To-Do List ---");
        for (int i = 0; i < taches.size(); i++) {
            System.out.println((i + 1) + ". " + taches.get(i));
        }
        System.out.println();
    }

    private void terminerTache(int index) {
        if (index >= 1 && index <= taches.size()) {
            taches.get(index - 1).réalisée = true;
            System.out.println("Done Tâche terminée !");
        } else {
            System.out.println("Numéro invalide.");
        }
    }

    private void menu() {
        while (true) {
            System.out.println("1. Ajouter une tâche");
            System.out.println("2. Voir les tâches");
            System.out.println("3. Terminer une tâche");
            System.out.println("4. Quitter");
            System.out.print("Choisis une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> {
                    System.out.print("Description : ");
                    ajouterTache(scanner.nextLine());
                }
                case 2 -> afficherTaches();
                case 3 -> {
                    afficherTaches();
                    System.out.print("Numéro à terminer : ");
                    terminerTache(scanner.nextInt());
                }
                case 4 -> {
                    System.out.println("À bientôt !");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Option invalide.");
            }
            System.out.println();
        }
    }

    // Point d'entrée
    public static void main(String[] args) {
        new ToDoList().menu();
    }
}