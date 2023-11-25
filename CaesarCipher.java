import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Şifrelemek istediğiniz metni girin: ");
        String plaintext = scanner.nextLine();

        System.out.print("Kaydırma miktarını girin: ");
        int shiftAmount = scanner.nextInt();

        // Şifreleme
        String encryptedText = encrypt(plaintext, shiftAmount);
        System.out.println("Şifrelenmiş Metin: " + encryptedText);

        // Şifreyi çözme
        String decryptedText = decrypt(encryptedText, shiftAmount);
        System.out.println("Çözülmüş Metin: " + decryptedText);
    }
}
