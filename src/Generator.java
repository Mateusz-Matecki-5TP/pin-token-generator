import java.security.SecureRandom;
import java.util.Random;

public class Generator {
    private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();
    private String result;

    Generator(int length) {
        switch (length) {
            case 4:
            case 6:
                result = generatePin(length);
                break;

            case 12:
            case 16:
                result = generateToken(length);
                break;
        }
    }

    public String generatePin(int length) {
        Random random = new Random();
        StringBuilder pin = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            pin.append(digit);
        }

        return pin.toString();
    }

    public String generateToken(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    public String getResult() {
        return result;
    }
}
