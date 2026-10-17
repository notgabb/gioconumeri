package it.gabriele.giocanumeri;

public class Giocatore extends Thread {

    private final String nome;
    private final String parola;
    private final int numero;

    /**
     * Crea una nuova istanza di un giocatore.
     * @param nome il nome del giocatore
     * @param parola la parola scelta dall'utente
     * @param numero il numero totale di caricamenti
     */
    public Giocatore(String nome, String parola, int numero) {
        this.nome = nome;
        this.parola = parola;
        this.numero = numero;
    }

    @Override
    public void run() {
        System.out.printf("Giocatore %s %n", nome);
        for (int i = 0; i < numero; i++) {
            System.out.printf("Caricando %d... %n", i);
        }

        int punteggio = parola.hashCode() % Integer.MAX_VALUE;

        System.out.printf("Parola: %s %n", parola.toUpperCase());
        System.out.printf("Punteggio: %d %n", punteggio);
    }

    /**
     * Ritorna il nome del giocatore.
     * @return il nome
     */
    public String nome() {
        return nome;
    }

    /**
     * Ritorna la parola scelta dall'utente.
     * @return la parola
     */
    public String parola() {
        return parola;
    }

    /**
     * Ritorna il numero totale di caricamenti.
     * @return il numero totale di caricamenti
     */
    public int numero() {
        return numero;
    }
}
