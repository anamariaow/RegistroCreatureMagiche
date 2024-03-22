import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroCreature registroCreature = new RegistroCreature();

        System.out.println("Benvenuto nel Registro delle Creature Magiche di Mystica!\n");

        while (true) {
            System.out.println("-- Operazioni Disponibili --");
            System.out.println("1. Aggiungi creatura magica");
            System.out.println("2. Rimuovi creatura magica");
            System.out.println("3. Visualizza elenco creature magiche");
            System.out.println("4. Cerca creatura magica");
            System.out.println("5. Sfida una creatura");
            System.out.println("6. Esci\n");

            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline residuo

            switch (scelta) {
                case 1:
                    aggiungiCreatura(scanner, registroCreature);
                    break;
                case 2:
                    rimuoviCreatura(scanner, registroCreature);
                    break;
                case 3:
                    registroCreature.visualizzaElencoCreature();
                    break;
                case 4:
                    cercaCreatura(scanner, registroCreature);
                    break;
                case 5:
                    // Implementa la logica per la sfida di una creatura
                    break;
                case 6:
                    System.out.println("Arrivederci!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private static void aggiungiCreatura(Scanner scanner, RegistroCreature registroCreature) {
        System.out.println("\n-- Aggiungi Creatura Magica --");
        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci tipo (Draco/Elementale/Folletto): ");
        String tipo = scanner.nextLine();
        System.out.print("Inserisci abilità speciale: ");
        String abilitaSpeciale = scanner.nextLine();
        System.out.print("Inserisci livello di potenza: ");
        int livelloPotenza = scanner.nextInt();

        CreaturaMagica nuovaCreatura = new CreaturaMagica(nome, tipo, abilitaSpeciale, livelloPotenza);

        try {
            registroCreature.aggiungiCreatura(nuovaCreatura);
        } catch (RegistroCreature.DatiCreatureNonValidiException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    private static void rimuoviCreatura(Scanner scanner, RegistroCreature registroCreature) {
        System.out.println("\n-- Rimuovi Creatura Magica --");
        System.out.print("Inserisci nome della creatura da rimuovere: ");
        String nomeDaRimuovere = scanner.nextLine();

        registroCreature.rimuoviCreatura(nomeDaRimuovere);
    }

    private static void cercaCreatura(Scanner scanner, RegistroCreature registroCreature) {
        System.out.println("\n-- Cerca Creatura Magica --");
        System.out.print("Inserisci nome della creatura da cercare: ");
        String nomeDaCercare = scanner.nextLine();

        CreaturaMagica creaturaTrovata = registroCreature.cercaCreaturaPerNome(nomeDaCercare);

        if (creaturaTrovata != null) {
            System.out.println("Creatura magica trovata:");
            registroCreature.stampaCreatura(creaturaTrovata);
        } else {
            System.out.println("Creatura magica non trovata.");
        }
    }

    private static class DatiCreatureNonValidiException extends Throwable {
    }
}