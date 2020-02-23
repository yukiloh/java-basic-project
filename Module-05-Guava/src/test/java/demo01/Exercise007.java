package demo01;


import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.CharSource;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//File
public class Exercise007 {

    private final String SOURCE_FILE = "C:\\Users\\Ash\\Documents\\Code\\JAVA\\java-basic-project\\Module-05-Guava\\src\\main\\resources\\test.txt";
    private final String TARGET_FILE = "C:\\Users\\Ash\\Documents\\Code\\JAVA\\java-basic-project\\Module-05-Guava\\src\\main\\resources\\target.txt";

    //copy 复制文件
    @Test
    void test01() throws IOException {
        File target = new File(TARGET_FILE);
        File from = new File(SOURCE_FILE);
        Files.copy(from, target);
        boolean exists = target.exists();
        //用于恢复测试前的状态,尽量不要对其他测试类产生影响
        if (exists){
            System.out.println("file is copied:"+ exists);
            boolean delete = target.delete();
            if (delete) System.out.println("delete success");
        }
    }


    //move 移动文件
    @Test
    void test02() throws IOException {
        File from = new File(SOURCE_FILE);
        File to = new File(TARGET_FILE);
        Files.move(from,to);
        //恢复
        if (to.exists()) {
            System.out.println("move success");
            Files.move(to,from);
            if (from.exists()) {
                System.out.println("restore success ");
            }
        }
    }


    //读取文件中的内容
    @Test
    void test03() throws IOException {
        //读取为字符串数组
        List<String> strings = Files.readLines(new File(SOURCE_FILE), Charsets.UTF_8);

        //用于展示结果,每个数组连接使用换行符
        String result = Joiner.on("\n").join(strings);
        System.out.println(result);



        //或者直接读取全部(CharSource),然后再readLines读取
        CharSource charSource = Files.asCharSource(new File(SOURCE_FILE), Charsets.UTF_8);
        //LineProcessor 来处理获取的每行内容; 传入的类型建议为list
        LineProcessor<List<String>> processor = new LineProcessor<List<String>>() {

            Integer count = 0;
            //用于返回值
            List<String> list = new ArrayList<>();

            @Override
            public boolean processLine(String s) {
                if (count == 3) return false;   //只读三行; 返回false后会中断继续读取次行
                list.add(s);
                count++;
                return true;
            }
            //设定返回的结果,readLines貌似会默认调用该结果
            @Override
            public List<String> getResult() {
                return list;
            }
        };
        List<String> list = charSource.readLines(processor);
        System.out.println(Arrays.toString(list.toArray()));


    }

    //write 写入文件
    @Test
    void test06() throws IOException {
        String testPath = "C:\\Users\\Ash\\Documents\\Code\\JAVA\\java-basic-project\\Module-05-Guava\\src\\main\\resources\\test2.txt";
        File testFile = new File(testPath);
        testFile.deleteOnExit();    //JVM退出时删除文件

        String testWord = "test test!";
        //进行写入文件操作
        Files.asCharSink(testFile,Charsets.UTF_8).write(testWord);
        //也可以用append的方式写入文件;    ↑操作会重新创建一个并写入
        //Files.asCharSink(testFile,Charsets.UTF_8, FileWriteMode.APPEND).write(testWord);

        //测试文件内容
        System.out.println(Files.asCharSource(testFile, Charsets.UTF_8).read());
    }


    //获取文件的hash值
    @Test
    void test04() throws IOException {
        File file = new File(SOURCE_FILE);
        HashCode hashCode = Files.asByteSource(file).hash(Hashing.sha256());
        System.out.println(hashCode);
    }
}
