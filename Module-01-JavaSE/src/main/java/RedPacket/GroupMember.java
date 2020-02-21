package RedPacket;

import java.util.ArrayList;
import java.util.Random;

public class GroupMember extends User{  //子类 群员，需要定义 收红包


    public GroupMember() {
    }

    public GroupMember(String userName, int wallet) {
        super(userName, wallet);
    }

    //收红包的方法
    public void receiveRedPacket(ArrayList<Integer> list){
        //随机获取一个红包(索引号）
        int random = new Random().nextInt(list.size());

        //拿出（删除）一个红包（索引号）
        int delta = list.remove(random);

        //获取原钱包的数值
        int balance = super.getWallet();

        //把获取的红包加入到钱包中
        super.setWallet(delta + balance);
    }

}
