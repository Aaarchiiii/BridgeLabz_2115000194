package D_25_02_25;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Base64;
public class EncryptDecryptCSV {
    private static final String AES = "AES";
    private static final String CSV_FILE = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/employees.csv";
    private static final String ENCRYPTED_CSV_FILE = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/encrypted_employees.csv";
    private static final String DECRYPTED_CSV_FILE = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/decrypted_employees.csv";
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }
    private static String encodeKey(SecretKey secretKey) {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
    private static SecretKey decodeKey(String keyStr) {
        byte[] decodedKey = Base64.getDecoder().decode(keyStr);
        return new SecretKeySpec(decodedKey, AES);
    }
    private static String encrypt(String value, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
    }
    private static String decrypt(String encryptedValue, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedValue)));
    }
    public static void writeEncryptedCSV(SecretKey secretKey) {
        List<String[]> employees = Arrays.asList(
                new String[]{"ID", "Name", "Department", "Salary", "Email"},
                new String[]{"101", "Archi", "IT", "60000", "archi@example.com"},
                new String[]{"102", "Mayank", "HR", "50000", "mayank@example.com"},
                new String[]{"103", "Naman", "Finance", "70000", "naman@example.com"},
                new String[]{"104", "Neha", "IT", "65000", "neha@example.com"},
                new String[]{"105", "Khushi", "Marketing", "55000", "khushi@example.com"}
        );
        try (CSVWriter writer = new CSVWriter(new FileWriter(ENCRYPTED_CSV_FILE))) {
            for (String[] row : employees) {
                if (!row[0].equals("ID")) {
                    row[3] = encrypt(row[3], secretKey);
                    row[4] = encrypt(row[4], secretKey);
                }
                writer.writeNext(row);
            }
            System.out.println("✅ Encrypted CSV file written: " + ENCRYPTED_CSV_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readDecryptedCSV(SecretKey secretKey) {
        try (CSVReader reader = new CSVReader(new FileReader(ENCRYPTED_CSV_FILE));
             CSVWriter writer = new CSVWriter(new FileWriter(DECRYPTED_CSV_FILE))) {
            List<String[]> allData = new ArrayList<>();
            String[] row;
            while ((row = reader.readNext()) != null) {
                if (!row[0].equals("ID")) {
                    row[3] = decrypt(row[3], secretKey);
                    row[4] = decrypt(row[4], secretKey);
                }
                allData.add(row);
            }
            for (String[] dataRow : allData) {
                System.out.println(Arrays.toString(dataRow));
                writer.writeNext(dataRow);
            }
            System.out.println("✅ Decrypted CSV file written: " + DECRYPTED_CSV_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            SecretKey secretKey = generateKey();
            String encodedKey = encodeKey(secretKey);
            System.out.println("🔑 Secret AES Key: " + encodedKey);
            SecretKey decodedKey = decodeKey(encodedKey);
            writeEncryptedCSV(decodedKey);
            readDecryptedCSV(decodedKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
