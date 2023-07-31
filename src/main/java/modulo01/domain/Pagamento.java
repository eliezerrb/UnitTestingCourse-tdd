package modulo01.domain;

public class Pagamento {
	private TipoPagamento tipo;
	private double valor;
	private String descricao;

	public Pagamento(TipoPagamento tipo, double valor, String descricao) {
		super();
		this.tipo = tipo;
		this.valor = valor;
		this.descricao = descricao;
	}

	public TipoPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
