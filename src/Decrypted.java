import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Decrypted {
    private final Scanner scanner = new Scanner(System.in);
    private final CaesarCipher caesarCipher = new CaesarCipher();

    public void decrypted() throws IOException {

        System.out.println("Введіть повний шлях до файлу для його розшифровки:");
        String pathEncryptedFile = scanner.nextLine();

        System.out.println("Введіть ключ шифрування:");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введіть повний шлях до файлу, до якого записати розшифрований текст:");
        String pathNotEncryptedFile = scanner.nextLine();

        try (var reader = Files.newBufferedReader(Paths.get(pathEncryptedFile));
             var writer = Files.newBufferedWriter(Paths.get(pathNotEncryptedFile))
        ) {
            while (reader.ready()) {
                String string = reader.readLine();
                String decryptString = caesarCipher.decrypt(string, key);
                writer.write(decryptString + System.lineSeparator());
            }
        }
        System.out.println("Вміст файлу розшифровано." + System.lineSeparator());
    }
}