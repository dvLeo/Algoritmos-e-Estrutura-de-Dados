public class Ex1 {
    public static int fatorial(int n){
        int fat = -1; // -1 indica erro
        if ( n == 0 || n == 1)
            fat = 1;
        else if (n >= 2)
            fat = n = n*fatorial(n-1);
        return fat;
    }

    public static void main (String[] args){
        System.out.println(fatorial(5));
    }
}

