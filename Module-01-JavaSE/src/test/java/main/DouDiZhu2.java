//package main;
//
//import java.util.*;
//
//public class DouDiZhu2 {
//
//    public static void main(String[] args) {
//        long a = System.currentTimeMillis();
//
//        HashMap<Integer,String> hashMapPokerPool = new HashMap();
//        List<String> pokerType = List.of("黑桃","红桃","草花","方块");
//        List<String> pokerNumNormal = List.of("A","2","3","4","5","6","7","8","9","10","J","Q","K");
//        ArrayList<Integer> pokerValue = new ArrayList<>();
//        int index = 0;
//
//        for (String number :pokerNumNormal) {
//            for (String color: pokerType) {
//                hashMapPokerPool.put(index,color+number);
//                pokerValue.add(index);
//                index++;
//            }
//        }
//        hashMapPokerPool.put(index,"Joker");
//        pokerValue.add(index);
//        index++;
//        hashMapPokerPool.put(index,"joker");
//        pokerValue.add(index);
//
//        Collections.shuffle(pokerValue);
//        ArrayList<Integer> playPoker1 = new ArrayList<>();
//        ArrayList<Integer> playPoker2 = new ArrayList<>();
//        ArrayList<Integer> playPoker3 = new ArrayList<>();
//        ArrayList<Integer> hiddenCard = new ArrayList<>();
//
//        for (int i = 0; i < pokerValue.size(); i++) {
//            int ind = pokerValue.get(i);
//            if (ind >= 51) {
//                hiddenCard.add(ind);
//            }else if (ind % 3 ==0) {
//                playPoker1.add(ind);
//            }else if (ind % 3 ==1) {
//                playPoker2.add(ind);
//            }else if (ind % 3 ==2) {
//                playPoker3.add(ind);
//            }
//        }
//
//        Collections.sort(playPoker1);
//        Collections.sort(playPoker2);
//        Collections.sort(playPoker3);
//        Collections.sort(hiddenCard);
//
//
//        showPoker("player1",hashMapPokerPool,playPoker1);
//        showPoker("player1",hashMapPokerPool,playPoker2);
//        showPoker("player1",hashMapPokerPool,playPoker3);
//        showPoker("Hidden",hashMapPokerPool,hiddenCard);
//        long b = System.currentTimeMillis();
//        System.out.println("used time :"+(b-a));
//    }
//
//    public static void showPoker(String name,HashMap<Integer,String> poker,ArrayList<Integer> list) {
//        System.out.println("name:  "+name);
//        for (Integer key:list) {
//            String value = poker.get(key);
//            System.out.print(value+"  ");
//        }
//        System.out.println();
//    }
//}