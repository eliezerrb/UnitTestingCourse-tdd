package modulo01;

import modulo01.domain.Pagamento;
import modulo01.domain.TipoPagamento;

public class DescontoService {
	
	private static final double DESCONTO_PIX = 0.03;
	
	public Pagamento aplicaDesconto(Pagamento pg) {
		if (pg.getTipo().equals(TipoPagamento.PIX)) {
			double valorComDesconto =  pg.getValor() - (pg.getValor() * DESCONTO_PIX);
			pg.setValor(valorComDesconto);
		}
		return pg;
	}

}
