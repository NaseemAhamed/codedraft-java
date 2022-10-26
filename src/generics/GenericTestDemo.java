package generics;

public class GenericTestDemo {
    //We can use the same attribute obj to accept both string and integer inside the class Test.
    public static void main(String[] args) {
        Test<String> t1 = new Test<>();
        t1.setObj("Test");
        System.out.println(t1.getObj());

        Test<Integer> t2 = new Test<>();
        t2.setObj(1);
        System.out.println(t2.getObj());
    }
}
