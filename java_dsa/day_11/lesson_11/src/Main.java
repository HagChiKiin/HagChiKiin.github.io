public class Main {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.equals(s2));
    }
    private int myHashString(String s){
       char[] value = s.toCharArray();
       int h = 0;
       if(value.length > 0){
           for (char c : value) {
               h = 31 * h + c;
           }
       }
        return h;
    }
    static class MyObject{
        int val;
        MyObject(int val){
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            MyObject myObject = (MyObject) o;
            return this.val == myObject.val;
        }

    }
}
