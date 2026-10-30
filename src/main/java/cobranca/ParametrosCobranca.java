package cobranca;

public class ParametrosCobranca {

    private ParametrosCobranca() {};
    private static ParametrosCobranca instance = new ParametrosCobranca();
    public static ParametrosCobranca getInstance() {
        return instance;
    }

    private float taxaJuros;
    private float multaPadrao;

    public float getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(float taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public float getMultaPadrao() {
        return multaPadrao;
    }

    public void setMultaPadrao(float multaPadrao) {
        this.multaPadrao = multaPadrao;
    }
}
