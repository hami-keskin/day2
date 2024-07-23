public class Main {
    public static void main(String[] args) {
        // Kullanıcıdan girdi almak için Scanner sınıfını kullanacağız.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Lütfen bir hesaplama girin: ");
        String input = scanner.nextLine();

        System.out.println("Girdi: " + input);

        scanner.close();
    }
}
