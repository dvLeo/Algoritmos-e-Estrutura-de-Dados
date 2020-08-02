import java.util.Scanner;

public class App {
    static Scanner sc =  new Scanner(System.in);

    public static void main(String[] args) {
        Indice indice = new Indice();
        indice.readBook("alice.txt");
        while(true){
            switch (menu()){
                case 1:
                    System.out.println(indice);
                    break;
                case 2:
                    System.out.println("Informe a palavra:");
                    System.out.println(indice.searchPalavra(sc.next()));
                    break;
            }
        }
    }

    public static int menu(){
        System.out.println("[1] Exibir todo o índice remissivo");
        System.out.println("[2] Pesquisar palavra");
        return sc.nextInt();
    }
}