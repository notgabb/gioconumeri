package it.gabriele.giocanumeri;

import java.util.Scanner;

public class GiocoNumero {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int numero = leggiNumero("Inserisci un numero > ", scanner);

            System.out.print("Inserisci una parola: ");
            String parola = scanner.nextLine();

            Giocatore gabriele = new Giocatore("Gabriele", parola, numero);
            Giocatore emanuele = new Giocatore("Emanuele", parola, numero);

            gabriele.start();
            emanuele.start();

            gabriele.join();
            emanuele.join();
        } catch (Exception e) {
            System.err.println("Error in console!");
            e.printStackTrace(System.err);
        }
    }

    private static int leggiNumero(String input, Scanner scanner) {
        while (true) {
            try {
                System.out.print(input);

                String numeroStr = scanner.nextLine();
                return Integer.parseInt(numeroStr);
            } catch (Exception e) {
                System.out.println("Hai inserito un numero non valido!");
            }
        }
    }
}
