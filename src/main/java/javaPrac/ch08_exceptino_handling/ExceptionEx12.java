package javaPrac.ch08_exceptino_handling;

public class ExceptionEx12 {
    public static void main(String[] args) throws Exception{
        mathod1();
    }

    static void mathod1() throws Exception{
        method2();
    }

    static void method2() throws Exception{
        throw new Exception();
    }
}
