package cobranca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CobrancaAvulsaTest {

    @BeforeEach
    void setUp() {
        ParametrosCobranca.getInstance().setTaxaJuros(0.1f);
        ParametrosCobranca.getInstance().setMultaPadrao(20.0f);
    }

    @Test
    void deveManterValorBaseSemAtraso() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Avulsa");
        cobranca.setValorBase(500.0f);
        cobranca.setDiasAtraso(0);
        assertEquals(500.0f, cobranca.calcularValorFinal());
    }

    @Test
    void deveAplicarMultaEJurosComUmDiaDeAtraso() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Avulsa");
        cobranca.setValorBase(500.0f);
        cobranca.setDiasAtraso(1);
        assertEquals(572.0f, cobranca.calcularValorFinal());
    }

    @Test
    void deveRetornarInformacoes() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Avulsa");
        cobranca.setValorBase(500.0f);
        cobranca.setDiasAtraso(1);
        cobranca.setCliente("Marcelo");
        cobranca.setNumero(2);
        assertEquals("CobrancaAvulsa{numero=2, cliente='Marcelo', valorFinal=572.0}", cobranca.getInfo());
    }
}
