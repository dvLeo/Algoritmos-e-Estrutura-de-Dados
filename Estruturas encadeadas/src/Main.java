public class Main {
    public static void main(String[] args) {
        ColecaoEncadeada list = new ColecaoEncadeada();

        System.out.println("-First");
        list.addFirst("10");
        System.out.println(list);
        list.addFirst("20");
        System.out.println(list);
        list.addFirst("30");
        System.out.println(list);

        System.out.println("-Get");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        System.out.println("-Last");
        list.addLast("100");
        System.out.println(list);

        System.out.println("-Remove First");
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);

        System.out.println("-Remove Last");
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }

}
