package modulo01;

import modulo01.domain.Pagamento;
import modulo01.domain.TipoPagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;

public class TaxaServiceTest2 {
	
	@Test
	public void deveRetornarOValorMaisOValorTaxaQuandoOTipoPagamentoForPix() {
		// Given
		Pagamento pg = new Pagamento(TipoPagamento.CARTAO_CREDITO, 100, "PAGAMENTO01");
		
		// WHEN
		TaxaService mockedTaxaService = Mockito.spy(TaxaService.class);
		Mockito.when(mockedTaxaService.retornaTaxaPorTipoPagamento(any())).thenReturn(0.10);

		double valorTotal = mockedTaxaService.calculaValorTotalComTaxa(pg);
		
		// THEN
		Assertions.assertEquals(110, valorTotal, 0.00);
	}
	
	@Test
    public void deveChamarORetornaTaxaPorTipoPagamentoComOParametroPixQuandoForPassadoUmPagamentoPix() {
        //given
		Pagamento pg = new Pagamento(TipoPagamento.PIX, 100, "PAGAMENTO01");
		TaxaService taxaService = Mockito.spy(TaxaService.class);
		Mockito.doReturn(0.06).when(taxaService).retornaTaxaPorTipoPagamento(TipoPagamento.PIX);

		//When
        double resultadoPagamento = taxaService.calculaValorTotalComTaxa(pg);
        
        //then
        //estou chamado o método retornaTaxaPorTipoPagamento ?
        Mockito.verify(taxaService).retornaTaxaPorTipoPagamento(TipoPagamento.PIX);
    }
	
	@Test
    public void deveRetornarOValorTotalCalculadoQuandoForPassadoQualquerTipoPagamento() {
        //given
		Pagamento pg = new Pagamento(TipoPagamento.PIX, 100, "PAGAMENTO01");
		TaxaService taxaService = Mockito.spy(TaxaService.class);
		Mockito.doReturn(0.06).when(taxaService).retornaTaxaPorTipoPagamento(TipoPagamento.PIX);

		//When
        double resultadoPagamento = taxaService.calculaValorTotalComTaxa(pg);
        
        //then
        //estou chamado o método retornaTaxaPorTipoPagamento ?
        Mockito.verify(taxaService).retornaTaxaPorTipoPagamento(TipoPagamento.PIX);
		Assertions.assertEquals(106, resultadoPagamento, 0.00);
    }
	
	@Test
    public void deveRetornarOValorSemTaxaQuandoForPassadoQualquerValor() {
        //given
		Pagamento pg = new Pagamento(TipoPagamento.PIX, 100, "PAGAMENTO01");
		TaxaService taxaService = Mockito.spy(TaxaService.class);
		Mockito.doReturn(50.0).when(taxaService).retornaValorSemTaxa(anyDouble());

		//When
        double resultadoPagamento = taxaService.retornaValorSemTaxa(100.0);
        
        //then
		Assertions.assertEquals(50.0, resultadoPagamento, 0.00);
    }

}
