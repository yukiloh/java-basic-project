package IOStream;

import java.io.*;



//一个练习序列号、反序列化的类
public class SerialObjectInOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        objOutputStream();
        objInputStream();

    }

    private static void objOutputStream() throws IOException {      //序列号(写入)       多用于写入一个object(?)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\Code\\java-code\\step1\\src\\IOStream\\SerialTest.txt"));
        oos.writeObject(new PersonConstructionMethod("Tom",180,20,"man"));
        oos.close();
        //和所有流一样三部走,注意要用writeObject而不是write
    }

    private static void objInputStream() throws IOException, ClassNotFoundException {   //反序列化(读取),这里抛出了2个异常
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\Code\\java-code\\step1\\src\\IOStream\\SerialTest.txt"));
        Object obj = ois.readObject();
        ois.close();
        System.out.println(obj);    //不知道为什么打印了 IOStream.PersonConstructionMethod

        PersonConstructionMethod p = (PersonConstructionMethod) obj;        //重新用一个P类接受对象
        System.out.println(p.getName()+"  "+p.getStature()+"    "+p.getAge()+"    "+p.getSex());
        //Tom  180    20    null    因为sex定义了瞬时关键词transient，即使赋值了man也没有写入文本中

    }
}
