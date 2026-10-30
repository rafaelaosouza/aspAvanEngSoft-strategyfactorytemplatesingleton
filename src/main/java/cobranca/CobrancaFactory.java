package cobranca;

public class CobrancaFactory {

    public static Cobranca obterCobranca(String tipo) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("cobranca.Cobranca" + tipo);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cobrança inexistente");
        }
        if (!(objeto instanceof Cobranca)) {
            throw new IllegalArgumentException("Cobrança inválida");
        }
        return (Cobranca) objeto;
    }
}
