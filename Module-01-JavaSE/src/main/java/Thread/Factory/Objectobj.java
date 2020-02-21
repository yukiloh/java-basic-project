package Thread.Factory;



//定义一个对象类，包含对象的大小，还有T/F值
public class Objectobj {
    int number;
    boolean flag ;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Objectobj(boolean flag) {
        this.flag = flag;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Objectobj(int number) {
        this.number = number;
    }

    public Objectobj() {
    }
}
