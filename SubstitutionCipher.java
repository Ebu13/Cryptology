import java.util.Random;
import java.util.Scanner;

public class SubstitutionCipher {

    public static final char[] alfabe = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static int[] anahtarolustur() {
        int[] key = new int[alfabe.length];

        for (int i = 0; i < alfabe.length; i++) {
            key[i] = i + 1;
        }

        Random r = new Random();
        for (int i = alfabe.length - 1; i > 0; i--) {
            int index = r.nextInt(i + 1);

            int temp = key[i];
            key[i] = key[index];
            key[index] = temp;
        }

        return key;
    }

    public static int alfabesirasi(char harf) {
        if ('A' <= harf && harf <= 'Z') {
            return harf - 'A' + 1;
        } else if ('a' <= harf && harf <= 'z') {
            return harf - 'a' + 1;
        } else {
            return -1;
        }
    }

    public static String encrypt(String text, int[] key) {
        char[] textChars = text.toCharArray();
        StringBuilder encryptedText = new StringBuilder();

        for (char currentChar : textChars) {
            int order = alfabesirasi(currentChar);

            if (order != -1) {
                int substitutedOrder = key[order - 1];
                encryptedText.append(alfabe[substitutedOrder - 1]);
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Girmek istediğiniz metin nedir?");
        String text = scanner.nextLine();

        int[] key = anahtarolustur();
        String encryptedText = encrypt(text, key);

        System.out.println("Şifrelenmiş Metin: " + encryptedText);

        System.out.println("Generated Key:");
        for (int i = 0; i < alfabe.length; i++) {
            char substitutedChar = (char) (key[i] + 64);
            System.out.println(alfabe[i] + " -> " + substitutedChar);
        }
    }
}