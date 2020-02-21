package RedPacket;

import java.util.ArrayList;

public class GroupMaster extends User { //子类 群主，需要定义 发红包

    //定义构造方法
    public GroupMaster() {
        //super(); 默认赠送了
    }

    //有参构造方法+
    public GroupMaster(String userName, int wallet) {
        super(userName, wallet);
    }


    //发红包的方法。把红包分为若干个，所以返回的是int的集合；需要传入 发送金额 和 人数。
    public ArrayList<Integer> sendRedPacket(int sendMoney,int numbers){
        //创建一个集合，储存每个红包
        ArrayList <Integer> arrayList = new ArrayList<>();

        //发送的红包不能大于群主的wallet
        int balance = super.getWallet();

        if (balance < sendMoney) {
            System.out.println("Not Enough!");
            return arrayList;       //返回空集合
        }

        //设置扣钱
        super.setWallet(balance - sendMoney);

        //发红包了

        int avg = sendMoney / numbers;      //平均数
        int remainder = sendMoney % numbers;    //剩下的余数

        //塞入红包
        for (int i = 0; i < numbers-1; i++) {
            arrayList.add(avg);
        }

        //最后个红包
        int last = avg + remainder;
        arrayList.add(last);

        return arrayList;
    }

}
