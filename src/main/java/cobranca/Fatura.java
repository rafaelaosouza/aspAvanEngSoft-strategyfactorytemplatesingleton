package cobranca;

public class Fatura {

    private float valor;

    public float getValor() {
        return valor;
    }

    public void acrescentarMulta(float valorFatura, float multa) {
        Calculadora calculadora = new Calculadora(valorFatura, multa);
        this.valor = calculadora.calcular(new OperacaoMulta());
    }

    public void aplicarDesconto(float valorFatura, float desconto) {
        Calculadora calculadora = new Calculadora(valorFatura, desconto);
        this.valor = calculadora.calcular(new OperacaoDesconto());
    }

    public void parcelarFatura(float valorFatura, float parcelas) {
        Calculadora calculadora = new Calculadora(valorFatura, parcelas);
        this.valor = calculadora.calcular(new OperacaoParcelamento());
    }

    public void calcularJuros(float valorFatura, float taxa) {
        Calculadora calculadora = new Calculadora(valorFatura, taxa);
        this.valor = calculadora.calcular(new OperacaoJuros());
    }

    public void calcularValorMedio(float valorFatura1, float valorFatura2) {
        Calculadora calculadora = new Calculadora(valorFatura1, valorFatura2);
        this.valor = calculadora.calcular(new OperacaoMedia());
    }

}
