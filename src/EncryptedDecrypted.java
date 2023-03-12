import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EncryptedDecrypted {

    private final Scanner scanner = new Scanner(System.in);
    private final CaesarCipher cesarCipher = new CaesarCipher();

    public void encryptedDecrypted(boolean flag) throws IOException {

        System.out.println("Введіть шлях до файлу для його " + (flag ? "зашифрування" : "розшифрування"));
        String path = scanner.nextLine();

        System.out.println("Введіть ключ:");
        int key = Integer.parseInt(scanner.nextLine());

        Path newPath = PathHelper.buildFileName(path, flag ? "_encrypted" : "_decrypted");

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));
             BufferedWriter writer = Files.newBufferedWriter(newPath)) {
            while (reader.ready()) {
                String string = reader.readLine();
                String encryptedDecrypted = flag ? cesarCipher.encrypt(string, key) : cesarCipher.decrypt(string, key);
                writer.write(encryptedDecrypted + System.lineSeparator());
            }
        }
        System.out.println("Вміст файлу " + newPath.getFileName() + (flag ? " зашифровано" : " розшифровано") +
                System.lineSeparator());
    }
}
