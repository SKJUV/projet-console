import java.util.ArrayList;
import java.util.Scanner;

class main{
    public static void main(String args[]){
        ArrayList<String> noms= new ArrayList<>();
        Scanner input = new Scanner(System.in);
        noms.add("alice");
        noms.add("jean");
        System.out.println(noms);
        System.out.print("entrer une valeur: ");
        int a = input.nextInt();
        System.out.println(a);
    

        input.close();

    }
}       