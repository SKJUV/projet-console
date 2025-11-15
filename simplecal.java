import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n=== CALCULATRICE ===");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");
            choix = sc.nextInt();

            if (choix >= 1 && choix <= 4) {
                System.out.print("Entrez le premier nombre : ");
                double a = sc.nextDouble();
                System.out.print("Entrez le deuxième nombre : ");
                double b = sc.nextDouble();

                switch (choix) {
                    case 1: System.out.println("Résultat = " + (a + b)); break;
                    case 2: System.out.println("Résultat = " + (a - b)); break;
                    case 3: System.out.println("Résultat = " + (a * b)); break;
                    case 4:
                        if (b == 0) {
                            System.out.println("Erreur : division par zéro !");
                        } else {
                            System.out.println("Résultat = " + (a / b));
                        }
                        break;
                }
            }
        } while (choix != 5);
    }
}
