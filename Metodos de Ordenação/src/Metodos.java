public class Metodos {
    public static int[] bubbleSortv1(int[] vet) {
        int aux = 0;
        int iteracoes = 0;
        int instrucoes = 2;
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
        System.out.println("BubbleSort v1 >> Instruções: "+instrucoes);
        System.out.println("BubbleSort v1 >> Iterações: "+iteracoes);
        return vet;
    }

    public static int[] bubbleSortv2(int[] vet) {
        boolean trocou = true;
        int aux = 0;
        int iteracoes = 0;
        int instrucoes = 2;
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
        System.out.println("BubbleSort v2 >> Instruções: "+instrucoes);
        System.out.println("BubbleSort v2 >> Iterações: "+iteracoes);
        return vet;
    }

    public static int[] insertionSort(int[] vet){
        int iteracoes = 0;
        int instrucoes = 2;
        int i, j, chave;
        for(j = 1; j<vet.length;j++){
            iteracoes++;
            chave=vet[j];
            i = j - 1;
            instrucoes+=12;
            while((i >= 0) && (vet[i] > chave)){
                iteracoes++;
                instrucoes+=6;
                vet[i+1] = vet[i];
                i = i - 1;
            }
            vet[i+1] = chave;
            instrucoes+=3;
        }
        System.out.println("InsertSort >> Instruções: "+instrucoes);
        System.out.println("InsertSort >> Iterações: "+iteracoes);
        return vet;
    }

    public static void mergeSort(int[] vet){
        mergeSort(vet, 0, vet.length-1);
    }
    public static void mergeSort(int [] vet, int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSort(vet, inicio, meio);
            mergeSort(vet, meio+1, fim);
            merge(vet, inicio, meio, fim);
        }
    }

    private static void merge(int[] vet, int inicio, int meio, int fim){
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


    public static void quickSort(int[] vet, int low, int high){
        int pivot = 0;
        if ((high-low) > 0)
            pivot = partition(vet, low, high);
            quickSort(vet, low, pivot-1);
            quickSort(vet, pivot+1, high);
    }

    public static int partition(int [] vet, int low, int high) {
        int i, p, firsthigh;
        firsthigh = low;
        p = high;
        for (i = low; i < high; i++){
            if (vet[i] < vet[p]){
                int aux=vet[firsthigh];
                vet[firsthigh]=vet[i];
                vet[i]=aux;
                firsthigh = firsthigh + 1;
            }
        }
        int aux=vet[firsthigh];
        vet[firsthigh]=vet[i];
        vet[i]=aux;
        return firsthigh;
    }
}

