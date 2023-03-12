import java.io.*;

public class Menu {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("""
                    Виберіть дію, ввівши її номер:\s
                    1. Зашифрувати текст у файлі за допомогою ключа.\s
                    2. Розшифрувати текст у файлі за допомогою ключа.\s
                    3. Підібрати ключ до зашифрованого тексту у файлі (brute force).\s
                    4. Розшифрувати текст у файлі методом статичного перебору.\s
                    5. Виходу із програми""");

            String answer = reader.readLine();

            switch (answer) {
                case ("1") -> new EncryptedDecrypted().encryptedDecrypted(true);
                case ("2") -> new EncryptedDecrypted().encryptedDecrypted(false);
                case ("3") -> new Bruteforce().bruteforce();
                case ("4") -> new Parsing().parse();
                case ("5") -> {return;}
            }
        }
    }
}