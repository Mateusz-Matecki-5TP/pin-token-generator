import java.util.Scanner;

public class Form {
    private static final Scanner scanner = new Scanner(System.in);

    public static int menu() {
        System.out.println("---------------------------");
        System.out.println("[1] Wygeneruj nowy PIN/Token");
        System.out.println("[2] Wyświetl historię");
        System.out.println("[3] Wyjdź");
        System.out.print(">> ");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
            case 2:
            case 3:
                return option;
            default:
                System.out.println("---------------------------");
                System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                return menu();
        }
    }

    public static int getLength() {
        System.out.println("---------------------------");
        System.out.print("Wprowadź długość kodu (4, 6, 12, 16): ");

        int length = scanner.nextInt();
        switch (length) {
            case 4:
            case 6:
            case 12:
            case 16:
                return length;
            default:
                System.out.println("---------------------------");
                System.out.println("Nieprawidłowa długość. Spróbuj ponownie.");
                return getLength();
        }
    }

    public static int getOption() {
        System.out.println("---------------------------");
        System.out.println("Wygenerowano PIN/Token");
        System.out.println("[1] Wyświetl");
        System.out.println("[2] Zapisz do pliku");
        System.out.print(">> ");

        int option = scanner.nextInt();
        System.out.println();

        switch (option) {
            case 1:
            case 2:
                return option;
            default:
                System.out.println("---------------------------");
                System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                return getOption();
        }
    }

    public static void display(String result) {
        System.out.println("---------------------------");
        System.out.println("Wygenerowany kod: " + result);
    }
}
