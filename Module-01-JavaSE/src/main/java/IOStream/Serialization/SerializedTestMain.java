package IOStream.Serialization;

import org.junit.jupiter.api.Test;

import java.io.*;

public class SerializedTestMain {

    /*测试序列化一个对象*/

    @Test
    public void mainTest() throws IOException, ClassNotFoundException {
        /*创建一个对象,该对象必须实现Serializable接口*/
        UserModel userModel = new UserModel();
        userModel.setUsername("goudan");
        userModel.setUserAge(20);


        FileOutputStream fileOutputStream = new FileOutputStream("fooUser.txt");            /*新建一个文件流*/
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);           /*用文件流创建对象流*/
        objectOutputStream.writeObject(userModel);                                                  /*对象流内写入对象*/
        objectOutputStream.close();                                                                 /*先进后出得关闭流*/
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("fooUser.txt");               /*读取同理,过程略*/
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        UserModel userModel1 = (UserModel) objectInputStream.readObject();
        System.out.println(userModel1.getUsername());

        objectInputStream.close();
        fileInputStream.close();


    }
}
