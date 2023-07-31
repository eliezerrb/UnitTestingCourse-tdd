package modulo01;

import modulo01.domain.Pagamento;
import modulo01.domain.TipoPagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PagamentoServiceTest {
    
    @Mock
    private TaxaService mockedtaxaService;
    
    @Mock
    private DescontoService mockedDescontoService;
    
    @BeforeAll
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    }	

    @Test
    public void deveRetornarOValorPagoQuantoForPassadoUmPagamentoPix() {
        Pagamento pg = new Pagamento(TipoPagamento.PIX, 100, "PAGAMENTO01");
        
        Mockito.when(mockedtaxaService.calculaValorTotalComTaxa(pg)).thenReturn(112.0);
        Mockito.when(mockedDescontoService.aplicaDesconto(pg)).thenReturn(pg);
        
        PagamentoService pgService = new PagamentoService(mockedtaxaService, mockedDescontoService);
        Pagamento resultado = pgService.pagar(pg);
        Assertions.assertEquals(112, resultado.getValor(), 0);
    }
}
