import java.util.ArrayList;

public class Tree {
    public class Node{
        private Node father;
        private String element;
        private ArrayList<Node> son;

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

        public void addSon(Node n){
            return;
        }

        public boolean removeSon(Node n){
            return true;
        }

        public Node getSon(int i){
            return son.get(i);
        }

        public int countSon(){
            return son.size();
        }

    }

}
