import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Sayı ve işlem Map
    private static final Map<String, Double> numberMap = new HashMap<>();
    private static final Map<String, String> operatorMap = new HashMap<>();

    static {
        // Sayı Map
        numberMap.put("zero", 0.0);
        numberMap.put("one", 1.0);
        numberMap.put("two", 2.0);
        numberMap.put("three", 3.0);
        numberMap.put("four", 4.0);
        numberMap.put("five", 5.0);
        numberMap.put("six", 6.0);
        numberMap.put("seven", 7.0);
        numberMap.put("eight", 8.0);
        numberMap.put("nine", 9.0);
        numberMap.put("ten", 10.0);

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

        // Sayı ve işlemler liste
        List<String> items = new ArrayList<>();

        // Girdiyi kelimelere bölme
        String[] words = input.split(" ");

        for (String word : words) {
            word = word.toLowerCase();
            if (numberMap.containsKey(word)) {
                items.add(String.valueOf(numberMap.get(word)));
            } else if (operatorMap.containsKey(word)) {
                items.add(operatorMap.get(word));
            } else {
                System.out.println("Bilinmeyen kelime: " + word);
                return;
            }
        }

        // çarpma ve bölme
        for (int j = 0; j < items.size(); j++) {
            if (items.get(j).equals("*") || items.get(j).equals("/")) {
                double leftNumber = Double.parseDouble(items.get(j - 1));
                double rightNumber = Double.parseDouble(items.get(j + 1));
                double tempResult = 0.0;

                if (items.get(j).equals("*")) {
                    tempResult = leftNumber * rightNumber;
                } else if (items.get(j).equals("/")) {
                    tempResult = leftNumber / rightNumber;
                }

                items.set(j - 1, String.valueOf(tempResult)); // Güncellenen sonucu listeye koy
                items.remove(j + 1); // Kullanılmış olan sayıyı listeden çıkar
                items.remove(j); // Kullanılmış olan işlemi listeden çıkar
                j--;
            }
        }

        // toplama ve çıkarma
        for (int j = 0; j < items.size(); j++) {
            if (items.get(j).equals("+") || items.get(j).equals("-")) {
                double leftNumber = Double.parseDouble(items.get(j - 1));
                double rightNumber = Double.parseDouble(items.get(j + 1));
                double tempResult = 0.0;

                if (items.get(j).equals("+")) {
                    tempResult = leftNumber + rightNumber;
                } else if (items.get(j).equals("-")) {
                    tempResult = leftNumber - rightNumber;
                }

                items.set(j - 1, String.valueOf(tempResult)); // Güncellenen sonucu listeye koy
                items.remove(j + 1); // Kullanılmış olan sayıyı listeden çıkar
                items.remove(j); // Kullanılmış olan işlemi listeden çıkar
                j--;
            }
        }

        double finalResult = Double.parseDouble(items.get(0));
        System.out.println("Sonuç: " + finalResult);
        scanner.close();
    }
}
