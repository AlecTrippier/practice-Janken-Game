import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Janken {

    private Map<Integer, String> hands = new HashMap<Integer, String>();

    private List<String> results = new ArrayList<String>();

    int winCount = 0;
    int loseCount = 0;
    int draw = 0;

    private Scanner scanner; // Scannerインスタンス

    public Janken() {
        hands.put(1, "グー");
        hands.put(2, "チョキ");
        hands.put(3, "パー");

        results.add("あいこ");
        results.add("負け");
        results.add("勝ち");

        scanner = new Scanner(System.in); // Scannerインスタンスの作成
    }

    public void playGame() {
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

        String Hand = hands.get(playHand); // プレイヤーの手
        int cpuHandNumber = cpuHand(); // 1~3までのランダムな数字を取得
        String cpuHand = hands.get(cpuHandNumber); // CPU側のグーチョキパーを取得する
        String judge = judge(playHand, cpuHandNumber); // 勝敗判定

        System.out.println("Player : " + Hand); // Player : グー
        System.out.println("CPU : " + cpuHand);// CPU   : パー
        System.out.println("Result : " + judge);

        resultCount(judge); // カウント増減の処理を追加

        continueGame();
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

    public void resultCount(String judge) {
        switch(judge) {
            case "勝ち":
                winCount += 1;
                break;
            case "負け":
                loseCount += 1;
                break;
            case "あいこ":
                draw += 1;
                break;
        }
    }

    public void continueGame() {
        String input;
        int number;

        do {
            System.out.println("1:もう一度対戦する 2:終了する");
            input = scanner.next();
            if (input.matches("[1-2]")) {
                number = Integer.parseInt(input);
                break;
            }
            System.out.println("該当する半角数字で入力してください");
        } while (true);

        if (number == 1) {
            playGame();
        } else {
            System.out.println("最終結果：" + winCount + "勝 " + loseCount + "敗 " + draw + "引き分け");
        }
    }

    public void execution() {
        playGame();
    }

    public static void main(String[] args) {
        Janken janken = new Janken();
        janken.execution();
    }
}
