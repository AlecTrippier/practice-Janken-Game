import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Janken {

    private Map<Integer, String> hands = new HashMap<Integer, String>();

    private List<String> results = new ArrayList<String>();



    public Janken() {
        hands.put(1, "グー");
        hands.put(2, "チョキ");
        hands.put(3, "パー");

        results.add("あいこ");
        results.add("負け");
        results.add("勝ち");
    }

    public int playGame() {

        Scanner scanner = new Scanner(System.in);
        int playHand;
        do{
            // 1:グー 2:チョキ 3:パー
            System.out.println("1:グー 2:チョキ 3:パー");
            // 整数値の入力を受け付ける
            //hasNextIntで判定、nextIntは入力値の代入
            if (scanner.hasNextInt()) {
                playHand = scanner.nextInt();
                // 入力が整数の場合の処理
                if(playHand >= 1 && playHand <= 3){
                    break;
                }
            }
            System.out.println("該当する半角数字で入力してください");
        } while (true);

        scanner.close();
        System.out.println(playHand);
    }


    public void execution() {

    }
}