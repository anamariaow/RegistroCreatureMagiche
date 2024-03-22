import java.util.ArrayList;
import java.util.List;

public class RegistroCreature {
    //ArrayList
    private List<CreaturaMagica> registro;

    protected RegistroCreature() {
        this.registro = new ArrayList<>();
    }
    public void aggiungiCreatura(CreaturaMagica creatura) throws DatiCreatureNonValidiException {
        if (!isValidCreatura(creatura)) {
            throw new DatiCreatureNonValidiException("Dati non validi per la creatura magica.");
        }

        if (isCreaturaPresente(creatura.getNome())) {
            throw new DatiCreatureNonValidiException("Una creatura magica con lo stesso nome è già presente nel registro.");
        }

        registro.add(creatura);
        System.out.println("Creatura magica aggiunta con successo al registro!");
    }

    public void rimuoviCreatura(String nomeCreatura) {
        registro.removeIf(creatura -> creatura.getNome().equals(nomeCreatura));
        System.out.println("Creatura magica rimossa con successo dal registro!");
    }

    public void visualizzaElencoCreature() {
        if (registro.isEmpty()) {
            System.out.println("Nessuna creatura magica presente nel registro.");
        } else {
            System.out.println("-- Elenco Creature Magiche --");
            registro.forEach(this::stampaCreatura);
        }
    }

    public CreaturaMagica cercaCreaturaPerNome(String nomeCreatura) {
        return registro.stream()
                .filter(creatura -> creatura.getNome().equals(nomeCreatura))
                .findFirst()
                .orElse(null);
    }

    private boolean isValidCreatura(CreaturaMagica creatura) {
        return creatura != null &&
                creatura.getNome() != null && !creatura.getNome().isEmpty() &&
                creatura.getTipo() != null && !creatura.getTipo().isEmpty() &&
                creatura.getAbilitaSpeciale() != null && !creatura.getAbilitaSpeciale().isEmpty() &&
                creatura.getLivelloPotenza() >= 0;
    }

    private boolean isCreaturaPresente(String nomeCreatura) {
        return registro.stream().anyMatch(creatura -> creatura.getNome().equals(nomeCreatura));
    }

    public void stampaCreatura(CreaturaMagica creatura) {
        System.out.println("Nome: " + creatura.getNome() + " - Tipo: " + creatura.getTipo() +
                " - Abilità Speciale: " + creatura.getAbilitaSpeciale() + " - Livello: " + creatura.getLivelloPotenza());
    }

    protected class DatiCreatureNonValidiException extends Exception {
        public DatiCreatureNonValidiException(String s) {

        }
    }
}