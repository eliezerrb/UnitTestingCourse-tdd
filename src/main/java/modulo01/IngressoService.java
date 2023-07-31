package modulo01;

import modulo01.domain.TipoIngresso;
import modulo01.exceptions.TipoIngressoNaoEncontradoException;

public class IngressoService {

    public static int PORCENTAGEM_DESCONTO_INFANTIL = 50;
    public static int PORCENTAGEM_DESCONTO_ESTUDANTE = 50;
    public static int PORCENTAGEM_DESCONTO_NORMAL = 0;

    public double calculaDescontoPorTipoDoTicket(TipoIngresso tipoIngresso, double valor) throws TipoIngressoNaoEncontradoException {
        switch (tipoIngresso) {
            case ESTUDANTE:
                return this.calculaValorDoDesconto(valor, PORCENTAGEM_DESCONTO_ESTUDANTE);
            case INFANTIL:
                return this.calculaValorDoDesconto(valor, PORCENTAGEM_DESCONTO_INFANTIL);
            case NORMAL:
                return this.calculaValorDoDesconto(valor, PORCENTAGEM_DESCONTO_NORMAL);
            default:
                throw new TipoIngressoNaoEncontradoException("Tipo de ingresso não encontrado");
        }
    }

    private double calculaValorDoDesconto(double valor, int porcentagem) {
        return valor + (valor * porcentagem);
    }
}
