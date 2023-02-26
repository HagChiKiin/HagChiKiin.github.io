import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashMap {
    // array of buckets
    private static final int SIZE = 10000;
    private List<Node>[] buckets; //  private Node[] b; -> implement linkedlist by myselt

    public MyHashMap() {
        buckets = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }

    }

    public void put(int key, int value) {
        // biến key thành 1 index: hashFunction
        int hashIndex = hashFunction(key);
        // lay ra bucket để chứa
        List<Node> bucket = buckets[hashIndex];
        if (bucket == null) {

        }
        // nếu bucket chưa co key này
        // check xem bucket co node key nay chua
        Node node = new Node(key, value);
        int indexOfKey = bucket.indexOf(node);
        if (indexOfKey == -1) {
            bucket.add(node);
        } else {
            bucket.get(indexOfKey).value = value;
        }
//        if(bucket.contains(node)){
//            // bucket đã chứa key -> ghi đè giá trị value mơi
//            int indexOfKey = bucket.indexOf(node);
//            bucket.get(indexOfKey).value = value;
//
//        }else {
//            bucket.add(node);
//        }

        // nếu bucket đã có key này

    }

    public int get(int key) {
        // tim hash index
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        // nếu bucket chưa co key này
        // check xem bucket co node key nay chua
        Node node = new Node(key, -1);
        int indexOfKey = bucket.indexOf(node);
        if (indexOfKey == -1) {
            // bucket chua co key nay va return -1
            return -1;
        } else {
            // bucket da co key nay va return valuel
            return bucket.get(indexOfKey).value;
        }
    }

    public void remove(int key) {
        // tim hash index
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        // nếu bucket chưa co key này
        // check xem bucket co node key nay chua
        Node node = new Node(key, -1);
        // bucket da co key nay va return valuel
        bucket.remove(node);
    }

    private int hashFunction(int key) {
        // size = 1000, key =5 ->5, key=100 ->100,key = 10005 ->5 -> collision
        return key % SIZE;
    }

    static class Node {
        public int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return this.key == node.key;
        }
        // object 1 equal voi object 2 khi 2thang là 1, tro den cung 1 object trong bo nho, cung dia chi
        // implement equal:
        // co the cho phep 2object = nhau khi content cua no giong nhau ma ko can la cung 1 ob hay cung dia chi


        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

}
