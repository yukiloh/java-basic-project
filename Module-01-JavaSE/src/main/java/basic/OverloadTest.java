package basic;

public class OverloadTest {

    //看springboot源码发现有多个run,而且返回类型不同,因此进行了研究

    private Integer run(){
        return 1;
    }

    private void run(int a) {

    }

    private String run(String a) {
        return "";
    }

    //结论: 返回类型可以相同,但参数不可
}
