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

    public void insertionSort(int[] vet){
        int i, j, chave;
        for(j = 1; j<vet.length;j++){
            chave=vet[j];
            i = j - 1;
            while((i >= 0) && (vet[i] > chave)){
                vet[i+1] = vet[i];
                i = i - 1;
            }
            vet[i+1] = chave;
        }
    }

    public void mergeSort(int[] vet){
        mergeSort(vet, 0, vet.length-1);
    }
    public void mergeSort(int [] vet, int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSort(vet, inicio, meio);
            mergeSort(vet, meio+1, fim);
            merge(vet, inicio, meio, fim);
        }
    }

    private void merge(int[] vet, int inicio, int meio, int fim){
        int nL = meio - inicio+1; int nR = fim - meio;
        int[] L = new int[nL]; int [] R = new int[nR];
        System.arraycopy(vet, inicio, L, 0, nL);
        System.arraycopy(vet, meio+1, R,0, nR);
        int iL = 0; int iR = 0;
        for(int k = inicio; k<fim; k++){
            if(iR < nR){
                if (iL < nL) {
                    if (L[iL] < R[iR]) vet[k] = L[iL++];
                    else vet[k] = R[iR++];
                }
                else vet[k] = R[iR++];
            }
            else vet[k] = L[iL++];
        }
        }
    }
}