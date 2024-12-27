import org.mindrot.jbcrypt.BCrypt;
import java.util.Scanner;

public class PasswordEncryptionApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedPassword = "";

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Encriptar contrasenya");
            System.out.println("2. Verificar contrasenya");
            System.out.println("3. Sortir");
            System.out.print("Seleccioneu una opcio: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Encriptar contrasenya
                    System.out.print("Introduiu la contrasenya en clar: ");
                    String plainPassword = scanner.nextLine();
                    encryptedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt(10));
                    System.out.println("Contrasenya encriptada: " + encryptedPassword);
                    break;

                case 2:
                    // Verificar contrasenya
                    if (encryptedPassword.isEmpty()) {
                        System.out.println("No hi ha cap contrasenya encriptada disponible. Executeu l'opció 1 primer.");
                        break;
                    }

                    System.out.print("Introduïu la contrasenya en clar: ");
                    String passwordToVerify = scanner.nextLine();

                    System.out.print("Introduïu la clau encriptada: ");
                    String encryptedKey = scanner.nextLine();

                    if (BCrypt.checkpw(passwordToVerify, encryptedKey)) {
                        System.out.println("La contrasenya coincideix amb la clau encriptada.");
                    } else {
                        System.out.println("La contrasenya NO coincideix amb la clau encriptada.");
                    }
                    break;

                case 3:
                    // Sortir
                    System.out.println("Sortint de l'aplicacio. Adeu!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opcio no valida. Si us plau, trieu una opcio entre 1 i 3.");
            }
        }
    }
}
