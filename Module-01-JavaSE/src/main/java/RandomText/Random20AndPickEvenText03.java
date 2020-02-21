package RandomText;

import java.util.ArrayList;
import java.util.Random;

//随机20个数，选出其中的偶数放入新的集合中
public class Random20AndPickEvenText03 {
    public static void main(String[] args) {
        //调用pick方法
        pickArrayList(randomArray());
    }
                  //这里写返回数值的类型？
    public static ArrayList<Integer> randomArray() {
        //创建20个随机数字，并放入一个集合arrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int tempRandom = random.nextInt(1000);
            arrayList.add(tempRandom);
        }
        System.out.println("random arraylist(20):  "+arrayList);//打印看下结果
        //最后传出 arrayList
        return arrayList;
    }
    public static void pickArrayList(ArrayList<Integer> arrayList){
        int count = 0;
        //导入arrayList，选出其中的偶数，放入evenArrayList，最后打印
        ArrayList<Integer> evenArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            int temp = arrayList.get(i);
            if (temp % 2 ==0) {
                evenArrayList.add(temp);
                count ++;
            }
        }
        System.out.println("even objber("+count+"):  "+evenArrayList);
    }
}
