//使用链表实现队列
public class LinkedListQueue<E> {

    private HeadAndTailLinkedList<E> ls;

    public LinkedListQueue(){
        ls = new HeadAndTailLinkedList<E>();
    }

    //查看队列是否为空
    public boolean isEmpty(){
        return ls.isEmpty();
    }

    //查看队列长度
    public int getSize(){
        return ls.getSize();
    }

    //入队操作
    public void enQueue(E e){
        ls.add(e);
    }

    //出队操作
    public E deQueue(){
        return ls.delete();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: first");
        sb.append(ls+" last");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> ls = new LinkedListQueue<>();

        ls.enQueue(0);
        ls.enQueue(1);
        System.out.println(ls);

        ls.deQueue();
        ls.deQueue();
        System.out.println(ls);
    }
}
