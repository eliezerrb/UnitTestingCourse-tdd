package modulo01;

import modulo01.domain.Pagamento;

public class PagamentoService {

	private final TaxaService taxaService;
	
	private final DescontoService descontoService;
	
	public PagamentoService(TaxaService taxaService, DescontoService descontoService) {
		this.descontoService = descontoService;
		this.taxaService = taxaService;
	}

	public Pagamento pagar(Pagamento pg) {
		pg.setValor(taxaService.calculaValorTotalComTaxa(pg));
		descontoService.aplicaDesconto(pg);
		return pg;
	}
}
