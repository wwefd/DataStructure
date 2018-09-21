//使用数组实现普通队列（非循环）
public class Queue<E> {

    private Array<E> array;

    public Queue(int length){
        array = new Array<>(length);
    }

    public  Queue(){
        array = new Array<>();
    }

    //获得队列长度
    public int getLength(){
        return array.getLength();
    }

    //获得队列中元素个数
    public int getSize(){
        return array.getSize();
    }

    //判断队列是否为空
    public boolean isEmpety(){
        return array.isEmpty();
    }

    //入队操作
    public void enQueue(E e){
        array.addElement(e);
    }

    //出队操作
    public E deQueue(){
        return array.deleteFirst();
    }

    //查看队首元素
    public E getFirst(){
        return array.findFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("First Queue:[");
        for (int i=0;i<array.getSize();i++){
            res.append(array.findElementByIndex(i));
            if(i!=array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] Last");
        return res.toString();
    }

}
