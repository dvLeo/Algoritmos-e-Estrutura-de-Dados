public class Pesquisa {
    int pesqDiretra(int[] vet, int valor) {
        int res = -1;
        for (int i = 0; ((i < vet.length) && (vet[i] != valor)); i++) {
            if (i < vet.length)
                res = i;
        }
        return res;
    }

    int pesqBinaria(int[] vet, int valor){
        int low = 0;
        int high = vet.length -1;
        int pesq = low + ((high-low)/2);
        while (low <= high){
            if(vet[pesq] > valor)
                high = pesq -1;
            else if (vet[pesq] < valor)
                low = pesq +1;
            else
                return pesq;
            pesq = low + ((high - low)/2);
        }
        return -1;
    }
}
