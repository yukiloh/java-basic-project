//package IOStream;
//
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class FileInputOutputStreamExercise {
//    public static void main(String[] args) throws IOException {
//        long a = new TimeCounter().start();
//        FileInputStream fis = new FileInputStream("E:\\javatest\\0001.png");
//        FileOutputStream fos = new FileOutputStream("E:\\javatest\\0002.png",false);
//        byte[] bytes = new byte[1024];
//        int len;
//        while((len = fis.read(bytes)) !=-1){        //获取的读取bytes返回的是字节长度,如果读取完毕返回0,没有读取到返回-1
//            fos.write(bytes,0,len);             //用1024数组读取耗时2毫秒,用单个字节读取需要84毫秒;
//            System.out.println(new String(bytes,0,len));
//        }
//
//        fis.close();
//        fos.close();
//        new TimeCounter().end(a);
//    }
//}
