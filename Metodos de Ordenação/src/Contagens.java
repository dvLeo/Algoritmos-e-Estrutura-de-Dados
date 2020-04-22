public class Contagens {
    private int instrucoes = 0;
    private int iteracoes = 0;

    public void contInstrucoes(int n){
        instrucoes = instrucoes + n;
    }

    public void contIteracoes(int n){
        iteracoes = iteracoes + n;
    }

    public int getInstrucoes() {return instrucoes;}
    public int getIteracoes() {return iteracoes;}

}
