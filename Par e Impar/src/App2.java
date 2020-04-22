import java.util.Random;
public class App2 {

    private static int[] geraVetor(int nroPares, int nroImpares){
        int [] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                        (nroPares + nroImpares > 0)) {

            res = new int[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                novoNum = rnd.nextInt(98)+1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    res[contPar+contImpar] = novoNum;
                    contPar++;
                }
                else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    res[contPar+contImpar] = novoNum;
                    contImpar++;
                }
            }
        }
        return res;
    }
    public static void run(int par, int impar) {
        int[] vetorGerado=geraVetor(par,impar);
        int instrucao = separaParImpar.ParImparAux(vetorGerado);
        int instrucao2 = separaParImpar.ParImparSemAux(vetorGerado);

        System.out.println("Numero de elementos:"+(par+impar)+"pares:"+par+"impares:"+impar);
        System.out.println("Versão com auxiliar:"+ "Numero de instrucoes:" +instrucao);
        System.out.println("Versão sem auxiliar:"+ "Numero de instrucoes:" +instrucao2+ "\n");


    }
    public static void main(String[] args) {
        System.out.println("------Testes Solicitados------");
        run(50,50);
        run(20,80);
        run(80,20);
        run(250000,250000);
        run(100000,400000);
        run(400000,100000);
    }
}
//TESTANDO o RUN