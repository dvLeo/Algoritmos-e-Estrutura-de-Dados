import java.util.ArrayList;
import java.util.List;

public class Tree {
    public class Node{
        private Node father;
        private String element;
        private ArrayList<Node> son = new ArrayList<>();

        public Node(String e) {
            element = e;
        }

        public Node getFather() {
            return father;
        }

        public void setFather(Node father) {
            this.father = father;
        }

        public String getElement() {
            return element;
        }

        public void setElement(String element) {
            this.element = element;
        }

        public ArrayList<Node> getSon() {
            return son;
        }

        public void addSon(Node n){
            son.add(n);
        }

        public boolean removeSon(Node n){
           return son.remove(n);
        }

        public Node getSon(int i){
            return son.get(i);
        }

        public int countSon(){
            return son.size();
        }

    }

    private Node searchNodeRef(String element, Node target){
        Node res = null;
        if(target!=null) {
            if (target.getElement().equals(element)) {
                res = target;
            }
        }else {
            Node aux = null;
            int i = 0;
            while((aux == null) && (i < target.countSon())){
                aux = searchNodeRef(element, target.getSon(i));
                i++;
            }
            res = aux;
        }
        return res;
    }

    Node refRoot = null;

    public boolean add(String element, String father){
        Node n = new Node(element);
        Node aux = null;
        boolean res = false;
        //verifica se esta inserido na raiz
        if(father == null){
            //atualiza o pai da raiz
            if(refRoot != null){
                n.addSon(refRoot);
                refRoot.setFather(n);
            }
            //atualiza a raiz
            refRoot = n;
            res = true;
         //insere no meio da arvore
        }else{
            aux = searchNodeRef(father, refRoot);
            if (aux != null){
                aux.addSon(n);
                res = true;
            }
        }
        return res;
    }

    public List<String> traversalPre(){
        List<String> res = new ArrayList<>();
        traversalPre(refRoot, res);
        return res;
    }
    public void traversalPre(Node n, List<String> res){
        if(n != null){
            res.add(n.getElement());
            for(int i = 0; i < n.countSon(); i++){
                traversalPre(n.getSon(i), res);
            }
        }
    }

    public List<String> traversalPos(){
        List<String> res = new ArrayList<>();
        traversalPre(refRoot, res);
        return res;
    }
    public void traversalPos(Node n, List<String> res){
        if(n != null){
            for(int i = 0; i < n.countSon(); i++){
                traversalPos(n.getSon(i), res);
            }
            res.add(n.getElement());
        }
    }



}
