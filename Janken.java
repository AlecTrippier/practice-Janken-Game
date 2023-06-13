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
        System.out.println(hands.get(playHand));
    }



    public void execution() {
        playGame();
    }
}