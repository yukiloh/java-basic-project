package IOStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriterExercise {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("E:\\javatest\\FileReaderWriterTest.txt",false); //也支持续写，false=不续写
        FileReader fr = new FileReader("E:\\javatest\\FileReaderWriterTest.txt");

        fw.write("あ"+"    "+"啊");
        fw.flush();     //字符流写入时只会写入到内存，强制刷新flush或close后才会写入到文件中


        int len;        //读取单个字符流的方法
        while ((len = fr.read()) != -1){
            System.out.println(len);    //使int len强转为char类型
//        }

//        int len2;       //读取多个字符的方法
//        char[] chars = new char[1024];
//        while ((len2 = fr.read(chars)) != -1){
//            System.out.println(new String(chars,0,len2));
        }
        fr.close();
        fw.close();
    }
}
