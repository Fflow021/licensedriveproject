public class MotoristaComercial extends MotoristaGenerico{
    private String carga, tipoDeVeiculo;

    public MotoristaComercial(String nome, boolean carteiraProvisoria, String carga, String tipoDeVeiculo) {
        super(nome, carteiraProvisoria);
        this.carga = carga;
        this.tipoDeVeiculo = tipoDeVeiculo;
    }

    public String getCarga() {
        return carga;
    }

    public String getTipoDeVeiculo() {
        return tipoDeVeiculo;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                + "\nProvisória: " + isCarteiraProvisoria()
                + "\nID: " + getID()
                + "\nPontos: " + getPontos()
                + "\nTipo de Veiculo: " + this.tipoDeVeiculo
                + "\nCarga: " + this.carga ;
    }
}
