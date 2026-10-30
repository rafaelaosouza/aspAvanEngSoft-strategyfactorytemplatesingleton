package cobranca;

public class OperacaoParcelamento implements Operacao {

    public float calcular(float valor1, float valor2) {
        if (valor2 == 0) {
            throw new IllegalArgumentException("Parcelas igual a zero");
        }
        else {
            return valor1 / valor2;
        }
    }
}
