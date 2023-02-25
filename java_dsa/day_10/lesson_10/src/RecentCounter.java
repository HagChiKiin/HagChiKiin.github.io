public class RecentCounter {
    private int[] arr;
    private int head, tail;

    public RecentCounter() {
        arr = new int[10000];  //10^4
        head = 0;
        tail = -1;   // head= 0 tail = -1 tức là mảng chúng ta đang có là rỗng
    }
    public int ping(int t) {
        tail++;           // tăng tail.
        arr[tail] = t;    // gán t vào cuối mảng
        while (t- arr[head] > 3000) {  // nếu t - giá trị đầu của mảng > 3000 thì tăng head( loại bỏ phần tử đó)
            head++;
        }
        return tail-head + 1;
    }
}


