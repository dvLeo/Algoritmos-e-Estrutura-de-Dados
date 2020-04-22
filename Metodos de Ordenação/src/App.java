import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.Arrays;
import java.util.Random;
public class App {
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
    //Antes de chamar o método cujo tempo quer medir, chame
//        initClock();
//Após a execução do método a ser medido, chame
//        double res = getClockSec();
    public static void main(String[] args) {
        int num=1000;
        int[] vetor=geraVetor(num,1000);
        int[] instrucao = Metodos.bubbleSortv1(vetor);
        initClock();
        int[] vetor2=geraVetor(num,1000);
        int[] instrucao2 = Metodos.bubbleSortv2(vetor2);
        initClock();
        System.out.println("------Testes Solicitados------");
        System.out.println("\nNumero de elementos: 1.000");
        //System.out.println("Numero de instrucoes v1:"+Contagens.getInstrucoes(Metodos.bubbleSortv1(instrucao)));
        System.out.println("Numero de iteracoes v1:");
        System.out.println("Tempo v1:"+ getClockSec());
        System.out.println("Numero de instrucoes v2:"+instrucao2);
        System.out.println("Numero de iteracoes v2:");
        System.out.println("Tempo v1:"+ getClockSec());

        int num2=100000;
        int[] vetor3=geraVetor(num,100000);
        int[] instrucao3 = Metodos.bubbleSortv1(vetor3);
        initClock();
        int[] vetor4=geraVetor(num,100000);
        int[] instrucao4 = Metodos.bubbleSortv2(vetor4);
        initClock();
        System.out.println("\nNumero de elementos: 100.000");
        System.out.println("Numero de instrucoes v1:"+instrucao3);
        System.out.println("Numero de iteracoes v1:");
        System.out.println("Tempo v1:"+ getClockSec());
        System.out.println("Numero de instrucoes v2:"+instrucao4);
        System.out.println("Numero de iteracoes v2:");
        System.out.println("Tempo v2:"+ getClockSec());
    }

}
