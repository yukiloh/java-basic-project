package Method;

public class Student extends Person {
    private String name;
    public Student() {

    }

    public Student(String name,int age) {
        super(age);
        name = this.name;
    }
}
