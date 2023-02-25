import java.util.LinkedList;
import java.util.Queue;

public class lc933 {
    class RecentCounter {
        Queue<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            //3002 vs 1 . loại 1
            while (!queue.isEmpty() && t- queue.peek() > 3000){
                queue.poll();
            }
            queue.offer(t);
            return queue.size();
        }
    }
}
