public class ColecaoEncadeada {
    private class Nodo{
        private String element;
        private Nodo refNext;


        public Nodo(String e) {
            element = e;
        }

        public void setElement(String e) {
            element = e;
        }

        public void setNext(Nodo n){
            refNext = n;
        }

        public String getElement() {
            return element;
        }

        public Nodo getNext() {
            return refNext;
        }
    }

    private Nodo ref = null;
    private int qtdElem = 0;

    public void addFirst(String a){
        Nodo novo = new Nodo(a);

        novo.setNext(ref);
        ref = novo;
        qtdElem++;
    }

    public String get(int pos){
        String res = null;
        Nodo aux;
        int i;

        if ((pos >= 0) && (pos < qtdElem))
        {
            if(ref != null)
            {
                aux = ref;
                for(i = 1 ; i <= pos; i++) {
                    aux = aux.getNext();
                }
                res = aux.getElement();
            }
        }
        else{
            throw (new IndexOutOfBoundsException());
        }
        return res;
    }

    public boolean addLast(String b){
        Nodo aux = ref;

        for(int i = 1; i < qtdElem; i++){
            aux = aux.getNext();
        }
        aux.setNext(new Nodo(b));
        return true;
    }

    public String removeFirst(){
        Nodo aux = ref;

        ref = aux.getNext();
        qtdElem--;
        return aux.getElement() ;
    }

    public String removeLast(){
        Nodo aux = ref;

        for(int i = 1; i < qtdElem; i++){
            aux = aux.getNext();
        }

        Nodo printRemove = aux.getNext();

        aux.setNext(null);
        qtdElem--;
        return printRemove.getElement();
    }

}
