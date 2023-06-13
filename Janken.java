import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

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

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int playHand;
        String input;
        do {
            System.out.println("1:グー 2:チョキ 3:パー");
            input = scanner.next();
            if (input.matches("[1-3]")) {
                playHand = Integer.parseInt(input);
                break;
            }
            System.out.println("該当する半角数字で入力してください");
        } while (true);

        scanner.close();

        String Hand = hands.get(playHand); // プレイヤーの手
        int cpuHandNumber = cpuHand(); // 1~3までのランダムな数字を取得
        String cpuHand = hands.get(cpuHandNumber); // CPU側のグーチョキパーを取得する
        String judge = judge(playHand, cpuHandNumber); // 勝敗判定

        System.out.println("Player : " + Hand); // Player : グー
        System.out.println("CPU : " + cpuHand);// CPU   : パー
        System.out.println("Result : " + judge);

    }

    public int cpuHand() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1; // 1~3までのランダムな数字を出力
        return randomNumber;
    }

    public String judge(int player, int cpu) {
        if (player == cpu) {
            return results.get(0); // あいこ
        } else if ((player == 1 && cpu == 2) || (player == 2 && cpu == 3) || (player == 3 && cpu == 1)) {
            return results.get(2); // 勝ち
        } else {
            return results.get(1); // 負け
        }
    }

    public void execution() {
        playGame();

    }
}