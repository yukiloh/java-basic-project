package guava03io;


import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//File
public class Exercise007Files {

    private final String SOURCE_FILE = "C:\\Users\\Ash\\Documents\\Code\\JAVA\\java-basic-project\\Module-05-Guava\\src\\main\\resources\\test.txt";
    private final String TARGET_FILE = "C:\\Users\\Ash\\Documents\\Code\\JAVA\\java-basic-project\\Module-05-Guava\\src\\main\\resources\\target.txt";



    //Files工具类的一瞥
    @Test
    void test00(){

        final String path = "/";    //  F:\
        final String filePath = "F:\\Code\\Java\\java-basic\\Module-05-Guava\\src\\test\\java\\demo01\\Exercise001Joiner.java";

        System.out.println(Files.isDirectory().test(new File(path)));
        System.out.println(Files.isFile().test(new File(filePath)));

    }


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


    // 谨记,source用于读取,sink用于写入!

    //利用asCharSource/asByteSource 读取文件中的内容
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


        //对于非char文件,可以用byteSource来读取
        ByteSource byteSource = Files.asByteSource(new File(SOURCE_FILE));
        System.out.println(Arrays.toString(byteSource.read()));

    }

    //利用asCharSink/asByteSink 写入文件
    @Test
    void test05() throws IOException {
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


        //补充,关于touch,类似于Linux的touch,会进行文件的创建,并修改 最后修改时间 为现在(如果失败则报错)
        //Files.touch(testFile);

    }


    //从charSource向charSink复制
    @Test
    void test07() throws IOException {
        File sourceFile = new File(SOURCE_FILE);
        File targetFile = new File(TARGET_FILE);
        targetFile.deleteOnExit();

        CharSource charSource = Files.asCharSource(sourceFile, Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(targetFile, Charsets.UTF_8);

        System.out.println(charSource.copyTo(charSink));  //会返回字符数
        System.out.println(Files.asCharSource(targetFile, Charsets.UTF_8).read());  //打印查看内容
    }


    //其他charSource的补充
    @Test
    void test08() throws IOException {
        //warp:将char转换为charSource
        CharSource abcd = CharSource.wrap("abcd");
        CharSource efgh = CharSource.wrap("efgh");

        //concat 拼接任意CharSource
        CharSource newCharSourch = CharSource.concat(abcd, efgh);
        System.out.println(newCharSourch.read());


    }



    //获取文件的hash值
    @Test
    void test04() throws IOException {
        File file = new File(SOURCE_FILE);
        HashCode hashCode = Files.asByteSource(file).hash(Hashing.sha256());
        System.out.println(hashCode);
    }


    //遍历文件夹
    @Test
    void test06() throws IOException {
        File root = new File("C:\\Users\\Ash\\Documents\\Code\\JAVA\\java-basic-project\\Module-05-Guava\\src");

        Traverser<File> fileTraverser = Files.fileTraverser();
        //遍历树形结构时,会分化出 深度优先 和 广度优先
        //深度优先又可以分化出先序遍历(pre order)和后序遍历(post order)
        //先序遍历 pre order: 先根后左再右
        //后序遍历 post order: 先左后右再根       //补充:中序遍历:先左,再根,后右
        Iterable<File> files = fileTraverser.depthFirstPreOrder(root);

        //通过获取的迭代来遍历,利用Consumer来制定文件筛选规则
        files.forEach(new Consumer<File>() {
            @Override
            public void accept(File file) {
                if (file.isFile()) {
                    System.out.println(file.toString());
                }
            }
        });

        //补充:据说以前fileTraverser是利用双向队列
    }


}
