package IOStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {     //FileOutputStream必定会报错,需要throws给父类IOexception
        FileOutputStream fos = new FileOutputStream("E:\\javatest\\FileOutputStreamTest.txt",false);   //实例化,续写开启true
        fos.write(121);      //写入单个字节
        System.out.println("==============================");


        byte[] bytes1 = {117,110,122,104,105};   //一次写入多个字节
        fos.write(bytes1,0,2);   //从列表bytes的位置0开始，一次写入len2个字节
        fos.write(bytes1,2,3);
        System.out.println("==============================");
        fos.write("操你妈".getBytes());        //利用String下的getBytes转换String为列表bytes
        fos.write("\r\n".getBytes());           //输入换行符，win下为\r\n   unix:/n     mac:/r



        fos.close();    //结束输入流，释放资源
    }
}
