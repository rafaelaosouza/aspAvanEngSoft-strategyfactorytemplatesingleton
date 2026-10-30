package cobranca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaturaTest {

    @Test
    void deveAcrescentarMultaFatura() {
        Fatura fatura = new Fatura();
        fatura.acrescentarMulta(800.0f, 200.0f);
        assertEquals(1000.0f, fatura.getValor());
    }

    @Test
    void deveAplicarDescontoFatura() {
        Fatura fatura = new Fatura();
        fatura.aplicarDesconto(800.0f, 100.0f);
        assertEquals(700.0f, fatura.getValor());
    }

    @Test
    void deveCalcularJurosFatura() {
        Fatura fatura = new Fatura();
        fatura.calcularJuros(800.0f, 1.1f);
        assertEquals(880.0f, fatura.getValor());
    }

    @Test
    void deveParcelarFatura() {
        Fatura fatura = new Fatura();
        fatura.parcelarFatura(1000.0f, 4.0f);
        assertEquals(250.0f, fatura.getValor());
    }

    @Test
    void naoDeveParcelarFaturaEmZeroParcelas() {
        try {
            Fatura fatura = new Fatura();
            fatura.parcelarFatura(1000.0f, 0.0f);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Parcelas igual a zero", e.getMessage());
        }
    }

    @Test
    void deveCalcularValorMedioFatura() {
        Fatura fatura = new Fatura();
        fatura.calcularValorMedio(700.0f, 800.0f);
        assertEquals(750.0f, fatura.getValor());
    }

}
