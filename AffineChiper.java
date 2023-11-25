import java.util.Scanner;

public class AffineChiper {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sifrelenecek metni girin: ");
        String metin = scanner.nextLine();

        System.out.print("a değerini girin (a ve 26 aralarinda asal olmalidir): ");
        int a = scanner.nextInt();

        System.out.print("b değerini girin (0 ve 25 arasında bir tam sayı olmalıdır): ");
        int b = scanner.nextInt();

        String sifreliMetin = sifrele(metin, a, b);

        System.out.println("Sifreli Metin: " + sifreliMetin);

        scanner.close();
    }

    public static String sifrele(String metin, int a, int b) {
        StringBuilder sifreliMetin = new StringBuilder();

        for (int i = 0; i < metin.length(); i++) {
            char karakter = metin.charAt(i);

            if (Character.isLetter(karakter)) {
                char baslangic = Character.isUpperCase(karakter) ? 'A' : 'a';
                sifreliMetin.append((char) ((a * (karakter - baslangic) + b) % 26 + baslangic));
            } else {
                sifreliMetin.append(karakter);
            }
        }

        return sifreliMetin.toString();
    }
}
