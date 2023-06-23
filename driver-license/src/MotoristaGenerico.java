import java.util.Random;;
public class MotoristaGenerico {
    private String nome;
    private int ID, pontos;
    private boolean carteiraProvisoria;

    public MotoristaGenerico(String nome, boolean carteiraProvisoria) {
        this.nome = nome;
        this.carteiraProvisoria = carteiraProvisoria;
        Random random = new Random();
        this.ID = random.nextInt(1000);
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }

    public boolean isCarteiraProvisoria() {
        return carteiraProvisoria;
    }

    public int getPontos() {
        return pontos;
    }

    public void addPontos(int num) {
        if(this.pontos >= 40 || carteiraProvisoria) {
            System.out.println("CNH suspensa.");

        }

        this.pontos += num;
    }

    @Override
    public String toString() {
    return "Nome: " + this.nome
            + "\nProvisória: " + this.carteiraProvisoria
            + "\nID: " + this.ID
            + "\nPontos: " + this.pontos;
    }
}
