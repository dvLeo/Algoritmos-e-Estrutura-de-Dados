public class Ex2 {
    public static int somatorio(int n){
        if ( n == 0 )
            return 1;
        else
            return  n+somatorio(n-1);

    }

    public static void main (String[] args){
        System.out.println(somatorio(5));
    }
}

