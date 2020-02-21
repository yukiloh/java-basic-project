import java.util.*;

public class DouDiZhu {

    public static void main(String[] args) {
        long A = System.currentTimeMillis();

        //3人斗地主
        //组牌
        HashMap<Integer,String> hashMapPokerPool = new HashMap<>();
        //JDK9
        List<String> pokerType = List.of("黑桃","红桃","草花","方块");
        List<String> pokerNumNormal = List.of("A","2","3","4","5","6","7","8","9","10","J","Q","K");
        List<String> pokerNumSpecial = List.of("JOKER","joker");

        ArrayList<String> pokerValue = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 13; i1++) {
                String str = pokerType.get(i) + pokerNumNormal.get(i1);
                pokerValue.add(str);
            }
        }
        for (int j = 0; j < 2; j++) {
            pokerValue.add(pokerNumSpecial.get(j));
        }
        for (int i2 = 0; i2 < 54; i2++) {
            hashMapPokerPool.put(i2,pokerValue.get(i2));
        }
        System.out.println(hashMapPokerPool);

        //洗牌shuffle,添加入新集合pokerKeyNew
        ArrayList<Integer> pokerKey = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            pokerKey.add(i);
        }
        ArrayList<Integer> pokerKeyNew = new ArrayList<>();
        for (int i = 54; i > 0; i--) {
            Random random = new Random();
            int r = random.nextInt(i);
            pokerKeyNew.add(pokerKey.get(r));
            pokerKey.remove(r);
        }
        show(pokerKeyNew,hashMapPokerPool);
        long B = System.currentTimeMillis();
        System.out.println("used time :"+(B-A));

    }

    public static void show(ArrayList<Integer> pokerKeyNew,HashMap<Integer,String>hashMapPokerPool) {

        //发牌
        ArrayList<Integer> playPoker1 = new ArrayList<>();
        ArrayList<Integer> playPoker2 = new ArrayList<>();
        ArrayList<Integer> playPoker3 = new ArrayList<>();

        for (int i = 51; i > 0;) {
            Random random = new Random();
            int r1 = random.nextInt(i);
            i--;
            playPoker1.add(pokerKeyNew.get(r1));
            pokerKeyNew.remove(r1);
            int r2 = random.nextInt(i);
            i--;
            playPoker2.add(pokerKeyNew.get(r2));
            int r3 = random.nextInt(i);
            pokerKeyNew.remove(r2);
            i--;
            playPoker3.add(pokerKeyNew.get(r3));
            pokerKeyNew.remove(r3);
        }

        Collections.sort(playPoker1);
        Collections.sort(playPoker2);
        Collections.sort(playPoker3);

        ArrayList<String> playPoker1new = new ArrayList<>();
        ArrayList<String> playPoker2new = new ArrayList<>();
        ArrayList<String> playPoker3new = new ArrayList<>();
        ArrayList<String> hiddenPoker = new ArrayList<>();

        for (int i = 0; i < playPoker1.size(); i++) {
            playPoker1new.add(hashMapPokerPool.get(playPoker1.get(i)));
            playPoker2new.add(hashMapPokerPool.get(playPoker2.get(i)));
            playPoker3new.add(hashMapPokerPool.get(playPoker3.get(i)));
        }
        for (int i = 0; i < pokerKeyNew.size(); i++) {
            hiddenPoker.add(hashMapPokerPool.get(pokerKeyNew.get(i)));
        }

        //亮牌
        System.out.println("play1: "+playPoker1new);
        System.out.println("play2: "+playPoker2new);
        System.out.println("play3: "+playPoker3new);
        System.out.println("hidden : "+hiddenPoker);

    }
}