public class Ex2 {
    public static int somatorio(int n){
        int som = -1; // -1 indica erro
        if ( n == 0 || n == 1)
            som = 1;
        else if (n >= 2)
            som = n = n+somatorio(n+1);
        return som;
    }

    public static void main (String[] args){
        System.out.println(somatorio(5));
    }
}

