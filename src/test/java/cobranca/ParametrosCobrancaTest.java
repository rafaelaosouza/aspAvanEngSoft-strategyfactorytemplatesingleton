package cobranca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParametrosCobrancaTest {

    @Test
    public void deveRetornarTaxaJuros() {
        ParametrosCobranca.getInstance().setTaxaJuros(0.1f);
        assertEquals(0.1f, ParametrosCobranca.getInstance().getTaxaJuros());
    }

    @Test
    public void deveRetornarMultaPadrao() {
        ParametrosCobranca.getInstance().setMultaPadrao(20.0f);
        assertEquals(20.0f, ParametrosCobranca.getInstance().getMultaPadrao());
    }

    @Test
    public void deveRetornarSempreAMesmaInstancia() {
        assertSame(ParametrosCobranca.getInstance(), ParametrosCobranca.getInstance());
    }

}
