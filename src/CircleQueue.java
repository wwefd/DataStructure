//循环队列的实现
public class CircleQueue<E> {
    private E[] data;
    private int size;//size记录队列元素数量(tail+length-font)%length
    private int font,tail;//font记录头指针，tail记录尾指针

    public CircleQueue(int length){
        data = (E[])new Object[length+1];
        font = 0;
        tail = 0;
        size = 0;
    }

    public CircleQueue(){
        this(11);
    }

    //判断循环队列是否为空
    public boolean isEmpty(){
        return tail == font;
    }

    //获取魂环队列容量
    public int getLength(){
        return data.length-1;
    }

    //队列扩容
    public void change(int newLength){
        E[] newData = (E[])new Object[newLength+1];
        for (int i=0;i<size;i++){
            newData[i] = data[(i+font)%data.length];
        }
        data = newData;
        font = 0;
        tail = size;
    }

    //入队
    public void enCircleQueue(E e){
        //判断队列是否已满，如果满了进行扩容
        if((tail+1)%data.length==font){
            change(getLength()*2);
        }
        /*if(size==data.length-1){
            change(data.length*2);
        }*/
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    //出队
    public E deCircleQueue(){
        //判断队列是否为空，为空抛出异常
        if(tail == font){
            throw new IllegalArgumentException("queue is empty,can not dequeue");
        }
        E res = data[font];
        data[font] = null;
        font = (font+1)%data.length;
        size--;
        if(size<getLength()/4&&data.length/2!=0){
            change(data.length/2);
        }
        return res;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("font:"+ font +" CircleQueue [");
       for (int i=font;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length!=tail){
                res.append(",");
            }
       }
        res.append("] tail:"+tail);
        return res.toString();
    }
}
