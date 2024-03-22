public class CreaturaMagica {
    //attributi
    private String nome;
    private String tipo;
    private String abilitaSpeciale;
    private int livelloPotenza;

    //costruttore
    public CreaturaMagica(String nome, String tipo, String abilitaSpeciale, int livelloPotenza) {
        this.nome = nome;
        this.tipo = tipo;
        this.abilitaSpeciale = abilitaSpeciale;
        this.livelloPotenza = livelloPotenza;
    }
    //getter e setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAbilitaSpeciale() {
        return abilitaSpeciale;
    }

    public void setAbilitaSperciale(String abilitaSpeciale) {
        this.abilitaSpeciale = abilitaSpeciale;
    }

    public int getLivelloPotenza() {
        return livelloPotenza;
    }

    public void setLivelloPotenza(int livelloPotenza) {
        this.livelloPotenza = livelloPotenza;
    }
}
