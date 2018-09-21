public class Main {

    public static void main(String args[]){

        //测试栈
        /*Stack<Integer> stack = new Stack<>();
        for (int i=0;i<stack.getLength()-2;i++){
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);*/

        //测试普通队列
        /*Queue<Integer> queue = new Queue<>();
        for (int i=0;i<queue.getLength()-2;i++){
            queue.enQueue(i);
        }
        System.out.println(queue);
        queue.deQueue();
        System.out.println(queue);
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue);
        queue.enQueue(8);
        System.out.println(queue);*/

        //测试循环队列
        /*CircleQueue<Integer> cq = new CircleQueue<>();
        for (int i=0;i<cq.getLength()-2;i++){
            cq.enCircleQueue(i);
        }
        System.out.println(cq);
        cq.deCircleQueue();
        cq.deCircleQueue();
        System.out.println(cq);
        cq.enCircleQueue(-1);
        cq.enCircleQueue(-1);
        cq.enCircleQueue(-1);
        System.out.println(cq);*/
    }

}
