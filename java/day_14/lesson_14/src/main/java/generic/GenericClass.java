package generic;

public class GenericClass<T> {

        public T obj;

        public T getObj() {
            return obj;
        }

        public void add(T obj){
            this.obj = obj;
        }

    public static void main(String[] args) {
        //Use Integer
        GenericClass<Integer> myGeneric1 = new GenericClass<Integer>();
        myGeneric1.add(3);
        System.out.println(myGeneric1.getObj());

        //Use String
        GenericClass<String> myGeneric2 = new GenericClass<String>();
        myGeneric2.add("java");
        System.out.println(myGeneric2.getObj());
    }
}
