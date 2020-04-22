import java.util.Random;
public class App {
    public int[] geraVetor(int nroElem, int lim){
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


}
