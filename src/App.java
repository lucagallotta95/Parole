import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        ArrayList<String> parole = new ArrayList<>(
                Arrays.asList("mare", "sole", "luce", "vento", "sale", "naso", "casa", "terra", "gas", "stella"));

        ArrayList<String> rispostaGicatore1 = new ArrayList<>();
        ArrayList<String> rispostaGicatore2 = new ArrayList<>();
        int tempoGiocatore1 = 0;
        int tempoGiocatore2 = 0;

        String nomeFile = "280000_parole_italiane.txt";

        ArrayList<String> paroleAmmesse = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(nomeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String riga;

            while ((riga = bufferedReader.readLine()) != null)
                paroleAmmesse.add(riga.trim());

            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }

        ArrayList<String> paroleUtilizzate = new ArrayList<>();
        

        for (int turno = 0; turno < 5; turno++) {
            String parolaEstratta = parole.get(r.nextInt(parole.size()));
            System.out.println("");
            System.out.println("La parola estratta è: " + parolaEstratta);
            System.out.println("");

            System.out.println("Turno " + (turno + 1) + "- Giocatore 1");

            System.out.println("Giocatore 1, inserisci una parola che contiene la parola estratta:");
            long inizioTempoMillisecondi = System.currentTimeMillis();
            String parolaGiocatore1 = sc.nextLine();

            long fineTempoMillisecondi = System.currentTimeMillis();
            long secondiTrascorsi = (fineTempoMillisecondi - inizioTempoMillisecondi) / 1000;
            System.out.println("Secondi trascorsi: " + secondiTrascorsi);

            if ((parolaGiocatore1.indexOf(parolaEstratta) >= 0) && (!parolaGiocatore1.equals(parolaEstratta))
                    && (secondiTrascorsi < 11)&&(paroleAmmesse.contains(parolaGiocatore1))&&(!paroleUtilizzate.contains(parolaGiocatore1))) {
                System.out.println("Risposta corretta");
                rispostaGicatore1.add(parolaGiocatore1);
                tempoGiocatore1 += secondiTrascorsi;
                paroleUtilizzate.add(parolaGiocatore1);
            } else {
                System.out.println("Risposta non corretta");
            }

            System.out.println("Turno " + (turno + 1) + "- Giocatore 2");
            System.out.println("Giocatore 2, inserisci una parola che contiene la parola estratta:");
            long inizioTempoMillisecondi2 = System.currentTimeMillis();
            String parolaGiocatore2 = sc.nextLine();
            long fineTempoMillisecondi2 = System.currentTimeMillis();
            long secondiTrascorsi2 = (fineTempoMillisecondi2 - inizioTempoMillisecondi2) / 1000;
            System.out.println("Secondi trascorsi: " + secondiTrascorsi2);

            if ((parolaGiocatore2.indexOf(parolaEstratta) >= 0) && (!parolaGiocatore2.equals(parolaEstratta))
                    && (secondiTrascorsi2 < 11)&&(paroleAmmesse.contains(parolaGiocatore2)&&(!paroleUtilizzate.contains(parolaGiocatore2))) ) {
                System.out.println("Risposta corretta");
                rispostaGicatore2.add(parolaGiocatore2);
                tempoGiocatore2 += secondiTrascorsi2;
                paroleUtilizzate.add(parolaGiocatore2);
            } else {
                System.out.println("Risposta non corretta");
            }

        }

        System.out.println("Risposte Giocatore 1 " + rispostaGicatore1.toString() + "secondi" + tempoGiocatore1);
        System.out.println("Risposta Giocatore 2 " + rispostaGicatore2.toString() + "secondi" + tempoGiocatore2);
        if (rispostaGicatore1.size() == rispostaGicatore2.size()) {
            System.out.println("Pareggio!");
            if (tempoGiocatore1 > tempoGiocatore2) {
                System.out.println("ha vinto il giocatore 2");
            } else if (tempoGiocatore1 < tempoGiocatore2) {
                System.out.println("ha vinto giocatore 1");
            } else {
                System.out.println("pareggio");
            }
        } else if (rispostaGicatore1.size() > rispostaGicatore2.size()) {
            System.out.println("ha vinto giocatore 1");
        } else {
            System.out.println("ha vinto giocatore 2");

        }

    }
}
