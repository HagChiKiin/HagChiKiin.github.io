import java.util.LinkedList;
import java.util.Queue;

public class QueueJava {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // ~ hàm push
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.offer(5);
        queue.peek(); // ~ hàm getFirst
//        queue.poll();// ~ hàm removeFirst
        System.out.println("phần tu dau tien là: "+queue.peek());
        System.out.println("phần tử đầu tiên xóa là: "+queue.poll());
        System.out.println(queue.peek());

    }
}
