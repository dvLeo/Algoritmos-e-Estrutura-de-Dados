import java.util.Random;

public class App {

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



    public static void main(String args[]) {

        int[] vetorGerado=geraVetor(50,50);
        int instrucao = separaParImpar.ParImparAux(vetorGerado);
        int[] vetorGerado2=geraVetor(50,50);
        int instrucao2 = separaParImpar.ParImparSemAux(vetorGerado2);
        System.out.println("------Testes Solicitados------");
        System.out.println("\nNumero de elementos: 100 (50 pares, 50 impares) \n***Com vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao);
        System.out.println("***Sem vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao2);

        int[] vetorGerado3=geraVetor(20,80);
        int instrucao3 = separaParImpar.ParImparAux(vetorGerado3);
        int[] vetorGerado4=geraVetor(20,80);
        int instrucao4 = separaParImpar.ParImparSemAux(vetorGerado4);
        System.out.println("\nNumero de elementos: 100 (20 pares, 80 impares) \n***Com vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao3);
        System.out.println("***Sem vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao4);

        int[] vetorGerado5=geraVetor(80,20);
        int instrucao5 = separaParImpar.ParImparAux(vetorGerado5);
        int[] vetorGerado6=geraVetor(80,20);
        int instrucao6 = separaParImpar.ParImparSemAux(vetorGerado6);
        System.out.println("\nNumero de elementos: 100 (80 pares, 20 impares) \n***Com vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao5);
        System.out.println("***Sem vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao6);

        int[] vetorGerado7=geraVetor(250000,250000);
        int instrucao7 = separaParImpar.ParImparAux(vetorGerado7);
        int[] vetorGerado8=geraVetor(250000,250000);
        int instrucao8 = separaParImpar.ParImparSemAux(vetorGerado8);
        System.out.println("\nNumero de elementos: 500.000 (250.000 pares, 250.000 impares) \n***Com vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao7);
        System.out.println("***Sem vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao8);

        int[] vetorGerado9=geraVetor(100000,400000);
        int instrucao9 = separaParImpar.ParImparAux(vetorGerado9);
        int[] vetorGerado10=geraVetor(100000,400000);
        int instrucao10 = separaParImpar.ParImparSemAux(vetorGerado10);
        System.out.println("\nNumero de elementos: 500.000 (100.000 pares, 400.000 impares) \n***Com vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao9);
        System.out.println("***Sem vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao10);

        int[] vetorGerado11=geraVetor(400000,100000);
        int instrucao11 = separaParImpar.ParImparAux(vetorGerado11);
        int[] vetorGerado12=geraVetor(400000,100000);
        int instrucao12 = separaParImpar.ParImparSemAux(vetorGerado12);
        System.out.println("\nNumero de elementos: 500.000 (400.000 pares, 100.000 impares) \n***Com vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao11);
        System.out.println("***Sem vetor auxiliar***");
        System.out.println("Numero de instrucoes:"+instrucao12);


    }
}
