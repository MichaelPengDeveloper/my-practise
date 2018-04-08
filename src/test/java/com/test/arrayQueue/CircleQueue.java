package com.test.arrayQueue;

/**
 * Created by Administrator on 2018/3/30.
 */
public class CircleQueue {

    private int[] a = null;

    private int head = 0 ;

    private int tail = 0;

    private int len = 0;

    public CircleQueue(int len){
        this.len = len;
        a = new int[len];
    }

    private int insert(int x){
        if (isFull()){
            System.out.println("circle queue is Full");
            return -1;
        }else {
            a[tail] = x;
            //逻辑上实现首尾相连，循环队列
            tail = (tail + 1) % len;
            //返回最近插入的元素
            return x;
        }
    }

    //pop from circle queue
    private int pop(){
        if (isNull()){
            System.out.println("circle queue is Null");
            return -1;
        }else {
            int n = a[head];
            //头结点不断追赶尾结点
            head = (head + 1) % len;
            //返回最近弹出的元素
            return n;
        }
    }

    //get head for circle queue
    private int head(){
        return a[head];
    }

    //get tail for circle queue
    private int tail(){
        return a[(tail + len - 1) % len];
    }

    private boolean isFull(){
        //有个规定，要给队尾留出一个空间来
        //如果不留出一个空间，举个例子，创建大小为12的数组，索引值为0~11.不断向其中添加元素
        //当添加到tail=11之后，就把tail置为(tail+1)%12 = 0
        //那么这时候无论判断队列isFull还是isNull都将返回true
        //所以为了防止这种情况的发生，当向tail=10添加元素之后，
        //把tail置为(tail+1)%12，然后在判断(tail+1)%12==head，这时判断isFull还是isNull就不会发生相冲突的情况
        if ((tail + 1) % len == head){
            return true;
        }else {
            return false;
        }
    }

    //check is null
    private boolean isNull(){
        //首尾相等的话则为空
        if (head == tail){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(4);
        System.out.println(circleQueue.insert(1));
        System.out.println(circleQueue.insert(2));
        System.out.println(circleQueue.insert(3));
        System.out.println(circleQueue.insert(4));
        for(int i = 0; i < 4; i++){
            System.out.println(circleQueue.pop());
        }

    }

}
