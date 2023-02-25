public class MyArrayQueue {
    private static final int SIZE = 100;
    static int[] arr;
    static int head;
    static int tail;
//    public MyQueue(){
//        arr = new int[SIZE];
//
//    }
    public static int getSize(){
        return tail-head;
        // return size ò Queue  :so luong phan tu
    }
    public static int getFirst(){
        if(head==tail){
            System.out.println("rỗng");
        }
        return arr[head];
        // return the first element in queue  : phan tu dau tien
    }
    public static int remove(){
        int val = arr[head]; // save value
        head++; //remove
        return val;
        // remove the first elenment and return
    }
    public static void push(int val){
        if(head==tail){
            System.out.println("rỗng");
        }
        arr[tail]= val;
        tail++;
        // add a new element into queue
    }
    private static void print(){
        for (int i = head; i < tail ; i++) {
            System.out.print(arr[i]+"-");
        }
    }

    public static void main(String[] args) {
        arr = new int[SIZE];
        push(0);
        push(1);
        push(2);
        push(3);
        print();
        System.out.println("remove first= "+remove());
        print();
        System.out.println("remove first= "+remove());
        print();
        System.out.println("size= "+getSize());
    }

}
