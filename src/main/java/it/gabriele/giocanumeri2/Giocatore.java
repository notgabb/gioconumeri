package it.gabriele.giocanumeri2;

public record Giocatore(String nome, String parola, int numero) implements Runnable {

    /**
     * Crea una nuova istanza di un giocatore.
     *
     * @param nome   il nome del giocatore
     * @param parola la parola scelta dall'utente
     * @param numero il numero totale di caricamenti
     */
    public Giocatore {
    }

    @Override
    public void run() {
        System.out.printf("Giocatore %s %n", nome);
        for (int i = 0; i < numero; i++) {
            System.out.printf("Caricando %d... %n", i);
        }

        int punteggio = parola.hashCode() % Integer.MAX_VALUE;
        String chiaveSuperSegreta = "MIPIACEJAVA";

        System.out.printf("Parola: %s %n", parola.toUpperCase());
        System.out.printf("Punteggio: %d %n", punteggio);

        String cifrato = cifra(parola.toUpperCase(), chiaveSuperSegreta);
        System.out.printf("Parola cifrata: %s %n", cifrato);
    }

    /**
     * Cifra una parola usando Vigenere
     * @param input la frase da cifrare
     * @param chiave la chiave da usare
     * @return la frase cifrata
     */
    private String cifra(String input, String chiave) {
        StringBuilder result = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char k = chiave.charAt(i % chiave.length());

            int charIndex = characters.indexOf(c);
            int keyIndex = characters.indexOf(k);

            int newCharIndex = (charIndex + keyIndex) % characters.length();
            result.append(characters.charAt(newCharIndex));
        }

        return result.toString();
    }
}
