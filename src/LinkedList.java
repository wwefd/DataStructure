//单链表的实现
public class LinkedList<E> {

    private class Node<E>{
        public E node;
        public Node next;
        public Node(E e,Node next){
            this.node = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return node+"" ;
        }
    }

    private Node<E> dummyhead;//虚拟表头dummyhead
    private int size;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node n = dummyhead.next;
        for (int i=0;i<size;i++){
            sb.append(n);
            n = n.next;
            sb.append("->");
            if (i==size-1){
                sb.append("NULL");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public LinkedList(){
        dummyhead = new Node<E>(null,null);
        size = 0;
    }

    //向链表表头中插入一个新节点
    public void addNode(E e){
        dummyhead.next = new Node<E>(e,dummyhead.next);
        size++;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向链表中index位置插入一个新节点
    public void addNodeByIndex(E e,int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("add failed,Illegal index");
        }
        Node pre = dummyhead;
        for (int i=0;i<index;i++){
            pre = pre.next;
        }
        pre.next = new Node(e,pre.next);
        size++;
    }

    //取出链表中第index位置的元素
    public Node getByIndex(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("get failed,Illegal index");
        }
        Node cur = dummyhead.next;
        for (int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur;
    }

    //取出链表中第一个元素
    public E getFirst(){
        Node<E> first = dummyhead.next;
        return first.node;
    }

    //判断链表中是否存在元素e
    public boolean getElement(E e){
        Node flag = dummyhead.next;
        while (flag!=null){
            if(flag.node == e){
                return true;
            }
            flag = flag.next;
        }
        return false;
    }

    //删除链表中第index位置的元素
    public E deleteByIndex(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("delete failed,Illegal index");
        }
        Node<E> pre = dummyhead;
        for (int i=0;i<index;i++){
            pre = pre.next;
        }
        Node<E> res = pre.next;
        pre.next = res.next;
        res.next = null;
        size--;
        return res.node;
    }

}
