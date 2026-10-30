package cobranca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CobrancaMensalidadeTest {

    @BeforeEach
    void setUp() {
        ParametrosCobranca.getInstance().setTaxaJuros(0.1f);
        ParametrosCobranca.getInstance().setMultaPadrao(20.0f);
    }

    @Test
    void deveManterValorBaseDentroDaCarencia() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Mensalidade");
        cobranca.setValorBase(1000.0f);
        cobranca.setDiasAtraso(5);
        assertEquals(1000.0f, cobranca.calcularValorFinal());
    }

    @Test
    void deveAplicarMultaEJurosAposCarencia() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Mensalidade");
        cobranca.setValorBase(1000.0f);
        cobranca.setDiasAtraso(6);
        assertEquals(1122.0f, cobranca.calcularValorFinal());
    }

    @Test
    void deveParcelarValorFinal() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Mensalidade");
        cobranca.setValorBase(1000.0f);
        cobranca.setDiasAtraso(6);
        assertEquals(374.0f, cobranca.calcularParcela(3));
    }

    @Test
    void naoDeveParcelarEmZeroParcelas() {
        try {
            Cobranca cobranca = CobrancaFactory.obterCobranca("Mensalidade");
            cobranca.setValorBase(1000.0f);
            cobranca.calcularParcela(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Parcelas igual a zero", e.getMessage());
        }
    }

    @Test
    void deveRetornarInformacoes() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Mensalidade");
        cobranca.setValorBase(1000.0f);
        cobranca.setDiasAtraso(6);
        cobranca.setCliente("Marco");
        cobranca.setNumero(1);
        assertEquals("Cobranca{numero=1, cliente='Marco', valorFinal=1122.0}", cobranca.getInfo());
    }
}
