public class TestLinkedList {

    public static void main(String[] args){
        LinkedList<Integer> ls = new LinkedList<>();
        for (int i=0;i<10;i++){
            ls.addNode(i);
        }
        System.out.println(ls);
        ls.addNodeByIndex(-1,4);
        System.out.println(ls);
        System.out.println(ls.getByIndex(2));
        System.out.println(ls.getElement(-2));
        ls.deleteByIndex(0);
        System.out.println(ls);
    }
}
