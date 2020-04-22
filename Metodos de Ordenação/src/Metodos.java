public class Metodos {
    public static int[] bubbleSortv1(int[] vet) {
        int aux = 0;
        int iteracoes = 0;
        int instrucoes = 0;
        for (int i = 0; i < vet.length; i++) {
            iteracoes++;
            instrucoes += 4;
            for (int j = 0; j < vet.length - 1; j++) {
                iteracoes++;
                instrucoes += 9;
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                    instrucoes += 9;
                }
            }
        }
        return vet;
    }

    public static int[] bubbleSortv2(int[] vet) {
        boolean trocou = true;
        int aux = 0;
        int iteracoes = 0;
        int instrucoes = 0;
        while (trocou) {
            iteracoes++;
            instrucoes += 3;
            trocou = false;
            for (int i = 0; i < vet.length - 1; i++) {
                iteracoes++;
                instrucoes += 9;
                if (vet[i] > vet[i + 1]) {
                    aux = vet[i];
                    vet[i] = vet[i + 1];
                    vet[i + 1] = aux;
                    trocou = true;
                    instrucoes += 10;
                }
            }
        }
        return vet;
    }
}