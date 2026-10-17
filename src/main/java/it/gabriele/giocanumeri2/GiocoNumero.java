package it.gabriele.giocanumeri2;

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

            Thread t1 = new Thread(gabriele);
            Thread t2 = new Thread(emanuele);

            t1.start();
            t2.start();

            System.out.println("======== Lista thread disponibili ========");
            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                System.out.println("---------------------");
                System.out.println("Thread: " + thread.getName());
                System.out.println("ID: " + thread.threadId());
                System.out.println("Stato: " + thread.getState());
                System.out.println("Priorità: " + thread.getPriority());
                System.out.println("Attivo: " + thread.isAlive());
            }

            t1.join();
            t2.join();

            Thread.sleep(1000);

            new ContaPrimi(0, 500000).start();
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
