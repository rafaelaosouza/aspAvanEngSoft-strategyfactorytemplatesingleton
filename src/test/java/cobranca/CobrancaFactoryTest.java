package cobranca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CobrancaFactoryTest {

    @Test
    void deveRetornarExcecaoParaCobrancaInexistente() {
        try {
            Cobranca cobranca = CobrancaFactory.obterCobranca("Anual");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Cobrança inexistente", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaCobrancaInvalida() {
        try {
            Cobranca cobranca = CobrancaFactory.obterCobranca("Invalida");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Cobrança inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarCobrancaMensalidade() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Mensalidade");
        assertInstanceOf(CobrancaMensalidade.class, cobranca);
    }

    @Test
    void deveRetornarCobrancaAvulsa() {
        Cobranca cobranca = CobrancaFactory.obterCobranca("Avulsa");
        assertInstanceOf(CobrancaAvulsa.class, cobranca);
    }
}
