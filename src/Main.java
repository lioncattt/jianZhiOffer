public class Main {

    public static void main(String[] args) {
        new B().A();
        System.out.println("Hello World!");
    }
}

abstract class A {
    abstract void A();
}

class B extends A {

    @Override
    void A() {
        System.out.println("halo");
    }
}
