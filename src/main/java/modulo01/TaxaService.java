package modulo01;

import modulo01.domain.Pagamento;
import modulo01.domain.TipoPagamento;

public class TaxaService {

	public static final double TAXA_PIX_VALUE = 0.03;
	public static final double TAXA_BOLETO_VALUE = 0.08;

	public double retornaTaxaPorTipoPagamento(TipoPagamento tipo) {
		if (tipo == TipoPagamento.PIX) {
			return TAXA_PIX_VALUE;
		}
		
		if (tipo == TipoPagamento.BOLETO) {
			return TAXA_BOLETO_VALUE;
		}
		return 0;
	}
	
	public double calculaValorTotalComTaxa(Pagamento pg) {
		return pg.getValor() + pg.getValor() * this.retornaTaxaPorTipoPagamento(pg.getTipo());
	}
	
	public double retornaValorSemTaxa(double valor) {
		return valor - (valor * TAXA_PIX_VALUE);
	}
	
}
