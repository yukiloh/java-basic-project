package IOStream;

import java.io.NotSerializableException;

public class PersonConstructionMethod extends NotSerializableException {

    private int Bust;
    private int Waist;
    private int hip;

    private String name;
    private int stature;    //身高
    private int age;
    private transient String sex;    //瞬时关键词，隐藏了sex关键词不写入文件
//    private static final long serialVersionUID = 100L;        //可以自定义序列号,注意名称

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonConstructionMethod(String name, int stature, int age,String sex) {
        this.name = name;
        this.stature = stature;
        this.age = age;
        this.sex = sex;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStature() {
        return stature;
    }

    public void setStature(int stature) {
        this.stature = stature;
    }



    public PersonConstructionMethod() {
    }
}
