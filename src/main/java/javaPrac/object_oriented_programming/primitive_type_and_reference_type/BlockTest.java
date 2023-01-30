package javaPrac.object_oriented_programming.primitive_type_and_reference_type;

public class BlockTest {
    static {
        System.out.println("static { }");  // 초기 한번만 실행
    }

    {
        System.out.println("{ }");  // 인스턴스 생성마다 실행
    }

    public BlockTest() {
        System.out.println("생성자");
    }
    public static void main(String[] args) {
        System.out.println("BlockTest bt = new BlockTest(); ");
        BlockTest bt = new BlockTest();

        System.out.println("BlockTest bt2 = new BlockTest(); ");
        BlockTest bt2 = new BlockTest();
    }
}
