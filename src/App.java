import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        ArrayList<String> parole = new ArrayList<>(Arrays.asList("mare", "sole", "luce", "vento", "sale", "naso", "casa", "terra", "gas", "stella"));


        ArrayList<String> rispostaGicatore1 = new ArrayList<>();
        ArrayList<String> rispostaGicatore2 = new ArrayList<>();


        for (int turno = 0; turno < 5; turno++) {
            String parolaEstratta = parole.get(r.nextInt(parole.size()));
            System.out.println("");
            System.out.println("La parola estratta è: " + parolaEstratta);
            System.out.println("");
            System.out.println("Turno " + (turno + 1) + "- Giocatore 1");
            
            System.out.println("Giocatore 2, inserisci una parola che contiene la parola estratta:");
            String parolaGiocatore1 = sc.nextLine();
            if (parolaGiocatore1.indexOf(parolaEstratta) >= 0 && !parolaGiocatore1.equals(parolaEstratta)) {
                System.out.println("Risposta corretta");
                rispostaGicatore1.add(parolaGiocatore1);
            } else {
                System.out.println("Risposta non corretta");
            }
            
            System.out.println("Turno " + (turno + 1) + "- Giocatore 2");
            System.out.println("Giocatore 2, inserisci una parola che contiene la parola estratta:");
            String parolaGiocatore2 = sc.nextLine();
            if (parolaGiocatore2.indexOf(parolaEstratta) >= 0 && !parolaGiocatore2.equals(parolaEstratta)) {
                System.out.println("Risposta corretta");
                rispostaGicatore2.add(parolaGiocatore2);
            } else {
                System.out.println("Risposta non corretta");
            }

        }

        System.out.println("Risposte Giocatore 1 " + rispostaGicatore1.toString());
        System.out.println("Risposta Giocatore 2 " + rispostaGicatore2.toString());
        if (rispostaGicatore1.size()==rispostaGicatore2.size()) {
            System.out.println("Pareggio!");
        } else if (rispostaGicatore1.size()>rispostaGicatore2.size()) {
            System.out.println("ha vinto giocatore 1");
        }else {
                System.out.println("ha vinto giocatore 2");
            
            }


        

    } 
}

