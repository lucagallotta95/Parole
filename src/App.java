import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        ArrayList<String> parole = new ArrayList<>(Arrays.asList("mare", "sole", "luce", "vento", "sale", "naso", "casa", "terra", "gas", "stella"));
        

        String parolaEstratta = parole.get(r.nextInt(parole.size()));
        System.out.println("-----------------------------------------------------");
        System.out.println("La parola estratta è: " + parolaEstratta);
        System.out.println("-----------------------------------------------------");
        System.out.println("Inserisci una parola che contiene la parola estratta");
        String parolaUtente = sc.nextLine();

        if (parolaUtente.indexOf(parolaEstratta)>=0)
            System.out.println("Parola corretta");

        else {
            System.out.println("Parola non corretta");
            }

    




    }
}
