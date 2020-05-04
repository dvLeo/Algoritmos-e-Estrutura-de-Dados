import java.util.Arrays;
import java.util.Random;
public class App {

    //Gerador de vetor e tempo
    public static int[] geraVetor(int nroElem, int lim){
        int dummy;
        int [] res = null;
        int cont = 0;
        Random rnd = new Random(System.nanoTime() * System.currentTimeMillis());

        if (nroElem >= 0) {

            res = new int[nroElem];

            while (cont < nroElem) {
                dummy = rnd.nextInt(lim)+1;
                dummy = rnd.nextInt(lim)+1;
                res[cont++] = rnd.nextInt(lim)+1;
            }
        }
        return res;
    }
    private static long tempoIni = 0, tempoFim = 0;
    public static void initClock() {
        tempoIni = tempoFim = System.nanoTime();
    }
    public static double getClockSec() {
        double res;
        tempoFim = System.nanoTime();
        res = ((double)tempoFim - (double)tempoIni) / (double)1000000000.0;
        return res;
    }

//Main

//Antes de chamar o método cujo tempo quer medir, chame
//initClock();
//Após a execução do método a ser medido, chame
//        double res = getClockSec();
    public static void main(String[] args) {
        int num0=10;
        int[] vetor0=geraVetor(num0,1000);
        int num=1000;
        int[] vetor=geraVetor(num,1000);
        int num2=100000;
        int[] vetor2=geraVetor(num,100000);

        System.out.println("------Testes Solicitados------");
        System.out.println("\n -----BubbleSort-----");
        System.out.println("Tempo BS v1: "+ getClockSec());
        initClock();
        Metodos.bubbleSortv1(vetor);
        System.out.println("Tempo BS v1: "+ getClockSec());
        initClock();
        Metodos.bubbleSortv1(vetor2);

        System.out.println("\nTempo BS v2: "+ getClockSec());
        initClock();
        Metodos.bubbleSortv2(vetor);
        System.out.println("Tempo BS v2: "+ getClockSec());
        initClock();
        Metodos.bubbleSortv2(vetor2);

        System.out.println("\n -----InsertionSort-----");
        System.out.println("Tempo Insert: "+ getClockSec());
        initClock();
        Metodos.insertionSort(vetor);
        System.out.println("Tempo Insert: "+ getClockSec());
        initClock();
        Metodos.insertionSort(vetor2);

        System.out.println("\n------Merge Sort------ ");
        System.out.println("Tempo vetor de 10 elem: "+ getClockSec());
        initClock();
        Metodos.mergeSort(vetor0);
        System.out.println("Tempo vetor de 1.000 elem: "+ getClockSec());
        initClock();
        Metodos.mergeSort(vetor);
        System.out.println("Tempo vetor de 100.000 elem: "+ getClockSec());
        initClock();
        Metodos.mergeSort(vetor2);
    }

}
