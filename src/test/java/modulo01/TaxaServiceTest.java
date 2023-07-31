package modulo01;

import modulo01.domain.Pagamento;
import modulo01.domain.TipoPagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TaxaServiceTest {

    @Test
    public void deveRetornarATaxaCorretaQuandoOPagamentoForDoTipoPix() {
        TaxaService taxaService = new TaxaService();
        double taxaRetornada = taxaService.retornaTaxaPorTipoPagamento(TipoPagamento.PIX);
        Assertions.assertEquals(TaxaService.TAXA_PIX_VALUE, taxaRetornada, 0.000);
    }

    @Test
    public void deveRetornarATaxaCorretaQuandoOPagamentoForDoTipoBoleto() {
        TaxaService taxaService = new TaxaService();
        double taxaRetornada = taxaService.retornaTaxaPorTipoPagamento(TipoPagamento.BOLETO);
        Assertions.assertEquals(TaxaService.TAXA_BOLETO_VALUE, taxaRetornada, 0.000);
    }

    @Test
    public void deveRetornarOValorTotalCalculadoQuandoForPassadoQualquerTipoPagamento() {
        Pagamento pg = new Pagamento(TipoPagamento.PIX, 100, "PAGAMENTO01");
        
        TaxaService taxaService = Mockito.spy(TaxaService.class);
        Mockito.when(taxaService.retornaTaxaPorTipoPagamento(TipoPagamento.PIX)).thenReturn(0.06);
        
        double resultadoPagamento = taxaService.calculaValorTotalComTaxa(pg);
        
        Mockito.verify(taxaService.retornaTaxaPorTipoPagamento(TipoPagamento.PIX));
    }

}
