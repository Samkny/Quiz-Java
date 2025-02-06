/* 	Per la compilazione :
	javac src/Main.java src/Libreria.java src/DatabaseConnection.java -d out
	Per l'eseguire l'applicazione :
	java -cp out Main
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Aggiungi nuovo libro");
            System.out.println("2. Visualizza tutti i libri");
            System.out.println("3. Cerca libro per titolo");
            System.out.println("4. Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il titolo del libro: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Inserisci l'autore del libro: ");
                    String autore = scanner.nextLine();
                    System.out.print("Inserisci l'anno di pubblicazione: ");
                    int anno = scanner.nextInt();
                    libreria.aggiungiLibro(titolo, autore, anno);
                    break;
                case 2:
                    libreria.visualizzaLibri();
                    break;
                case 3:
                    System.out.print("Inserisci il titolo del libro: ");
                    String titoloRicerca = scanner.nextLine();
                    libreria.cercaLibroPerTitolo(titoloRicerca);
                    break;
                case 4:
                    System.out.println("Uscita in corso");
                    scanner.close();
                    return;
                default:
                    System.out.println("La scelta non è valida");
            }
        }
    }
}