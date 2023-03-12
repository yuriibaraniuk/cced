import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypted {
    private final Scanner scanner = new Scanner(System.in);
    private final CaesarCipher caesarCipher = new CaesarCipher();

    public void encrypted() throws IOException {

        System.out.println("Введіть повний шлях до файлу для його зашифрування:");
        String pathNotEncrypted = scanner.nextLine();

        System.out.println("Введите ключ шифрования:");
        int key = Integer.parseInt(scanner.nextLine());

        System.out.println("Введіть повний шлях до файлу, який написати зашифрований текст:");
        String pathEncrypted = scanner.nextLine();

        try (var reader = Files.newBufferedReader(Paths.get(pathNotEncrypted));
             var writer = Files.newBufferedWriter(Paths.get(pathEncrypted))
        ) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encryptString = caesarCipher.encrypt(string, key);
                writer.write(encryptString + System.lineSeparator());
            }
        }
        System.out.println("Вміст файлу зашифрований." + System.lineSeparator());
    }
}