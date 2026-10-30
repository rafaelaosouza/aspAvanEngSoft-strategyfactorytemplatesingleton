package cobranca;

public class CobrancaAvulsa extends Cobranca {

    public int getCarenciaDias() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "CobrancaAvulsa";
    }
}
