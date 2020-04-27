public class Ex3 {
    public static int fibonnacci(int n)
    {
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        else if(n>2){
            return fibonnacci(n-1)+fibonnacci(n-2);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(fibonnacci(10));
    }
}
