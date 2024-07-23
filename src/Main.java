import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Sayı Map
    private static final Map<String, Integer> numberMap = new HashMap<>();
    // İşlem Map
    private static final Map<String, String> operatorMap = new HashMap<>();

    static {
        // Sayı Map
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
        numberMap.put("ten", 10);

        // İşlem Map
        operatorMap.put("add", "+");
        operatorMap.put("plus", "+");
        operatorMap.put("subtract", "-");
        operatorMap.put("minus", "-");
        operatorMap.put("less", "-");
        operatorMap.put("multiplied-by", "*");
        operatorMap.put("times", "*");
        operatorMap.put("divided-by", "/");
        operatorMap.put("over", "/");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hesaplama girin: ");
        String input = scanner.nextLine();

        // Girdiyi kelimelere bölme
        String[] words = input.split(" ");

        for (String word : words) {
            word = word.toLowerCase();
            if (numberMap.containsKey(word)) {
                System.out.println("Sayı: " + numberMap.get(word));
            } else if (operatorMap.containsKey(word)) {
                System.out.println("İşlem: " + operatorMap.get(word));
            }
        }

        scanner.close();
    }
}
