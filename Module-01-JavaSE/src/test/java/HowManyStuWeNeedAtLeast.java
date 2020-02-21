import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


//一共有10道题，分值0、3、5，至少需要多少学生会出现4人分数相同。
public class HowManyStuWeNeedAtLeast {

    public static void main(String[] args) {    //括号外是解释每条代码的意义（括号内为对程序的解释）

        int iii = 0;
        while (iii <= 10000){       //控制循环，原本想while true的


            HashMap<Integer,Integer> count = new HashMap<>();   //map集合 count，key=学生分数，value=出现的次数

            for (int i = 0; i < 20; i++) {
                Random threeStatus = new Random();      //random一个3种题目的状态：0、3、5
                ArrayList<Integer> member = new ArrayList<>();      //单个学生的每题得分集合
                for (int i2 = 0; i2 < 10; i2++) {       //循环10遍（因为有10题目）
                    int status =  threeStatus.nextInt(3);   //每次循环的时候随机一个status，有3种情况：0、3、5
                    int score = getScore(status);       //调用getScore方法，返回一个每题的分数score
                    member.add(score);                  //把获得的每题分数添加入单个学生的答题情况的集合member
                }
                int sum = 0;
                for (int i1 = 0; i1 < member.size(); i1++) {    //统计单个学生的答题分数（把单个学生答题情况的集合member中每题的分数，累加给值sum）
                    sum = member.get(i1)+sum;
                }

                if (count.containsKey(sum)) {           //如果该分数出现过（如果map集合count中的key：sum有值，则返回true）
                    Integer value = count.get(sum);     //则加1（把出现的次数赋值给临时变量value）
                    value++;                            //（value加1）
                    if (value > 4){                     //如果出现次数大于4次，为本次程序要求的结果
                        System.out.print(count+"   ");  //把这个map集合输出打印
                        int total = 0;
                        for (Map.Entry<Integer,Integer> entry:count.entrySet()) {   //并统计一共有多少学生答题了
                            total = entry.getValue()+total;
                        }
                        System.out.println(total);      //打印这个统计的人数
                        break;
                    }
                    count.put(sum,value);
                }else {
                    count.put(sum,1);                   //如果这个成绩是第一次出现，则将其赋值为1
                }

            }
            iii++;
        }
    }

    private static int getScore(int status) {         //一个获得分数的方法，懒得解释
        int scoreevery = 0;
        if (status == 0) {
            scoreevery = 0;
        } else if (status == 1) {
            scoreevery = 3;
        } else if (status == 2) {
            scoreevery = 5;
        }
        return scoreevery;
    }
}






