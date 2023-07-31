package modulo01;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {

    public static int maiorValor(List<Integer> lista) {
        int maior = 0;
        for (int valor: lista) {
            if (valor > maior) {
                maior = valor;
            }
        }
        return maior;
    }

    public static int menorValor(List<Integer> lista) {
        int menor = 0;
        for (int valor: lista) {
            if (valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }

    public static int media(List<Integer> lista) {
        int sum = 0;
        for (int valor: lista) {
            sum += valor;
        }
        return sum / lista.size();
    }

    public static int mediana(List<Integer> lista) {
        List<Integer> listaOrdenada = lista.stream().sorted().collect(Collectors.toList());
        boolean eImpar = lista.size() % 2 == 1;
        int indiceDoMeio = (lista.size() / 2) + 1;
        if (eImpar) {
            return listaOrdenada.get(indiceDoMeio);
        }
        int indiceDoMeio2 = (lista.size() / 2);
        return (listaOrdenada.get(indiceDoMeio) + listaOrdenada.get(indiceDoMeio2)) / 2;
    }
}
