package cobranca;

public abstract class Cobranca {

    private int numero;
    protected String cliente;
    private float valorBase;
    private int diasAtraso;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getValorBase() {
        return valorBase;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public float calcularValorFinal() {
        if (this.diasAtraso <= this.getCarenciaDias()) {
            return this.valorBase;
        }
        Fatura fatura = new Fatura();
        fatura.acrescentarMulta(this.valorBase, ParametrosCobranca.getInstance().getMultaPadrao());
        float valorComMulta = fatura.getValor();
        fatura.calcularJuros(valorComMulta, ParametrosCobranca.getInstance().getTaxaJuros());
        float juros = fatura.getValor();
        return valorComMulta + juros;
    }

    public float calcularParcela(int parcelas) {
        Fatura fatura = new Fatura();
        fatura.parcelarFatura(this.calcularValorFinal(), parcelas);
        return fatura.getValor();
    }

    public abstract int getCarenciaDias();

    public String getTipo() {
        return "Cobranca";
    }

    public String getInfo() {
        return getTipo() + "{" +
                "numero=" + this.numero +
                ", cliente='" + this.cliente + '\'' +
                ", valorFinal=" + this.calcularValorFinal() +
                '}';
    }
}
