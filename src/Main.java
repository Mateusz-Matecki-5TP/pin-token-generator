import java.util.List;

public class Main {
    public static void main(String[] args) {
        while(true) {
            menu();
        }
    }

    public static void menu() {
        int option = Form.menu();
        switch(option) {
            case 1:
                generate();
                break;
            case 2:
                getHistory();
                break;
            case 3:
                exit();
                break;
        }
    }

    public static void generate() {
        int length = Form.getLength();

        Validator validator = Validator.getInstance();
        if (!validator.canGenerateNew()) {
            System.out.println("---------------------------");
            System.out.println("Zbyt szybko próbujesz wygenerować nowy PIN/Token. Spróbuj ponownie później.");
            return;
        }

        Generator generator = new Generator(length);
        String result = generator.getResult();
        boolean isHistorySaved = validator.saveGeneratedText(result);

        if(!isHistorySaved) {
            System.err.println("Nie udało się zapisać historii.");
        }

        int option = Form.getOption();
        switch (option) {
            case 1:
                Form.display(result);
                break;
            case 2:
                boolean success = FileManager.saveToFile("result.txt", result);
                if (success) {
                    System.out.println("---------------------------");
                    System.out.println("Zapisano do pliku result.txt");
                }
                break;
        }
    }

    public static void getHistory() {
        Validator validator = Validator.getInstance();
        List<String> history = validator.getHistory();

        System.out.println("---------------------------");

        if (history.isEmpty()) {
            System.out.println("Brak historii.");
        } else {
            System.out.println("Historia twoich PIN'ów/Tokenów (pierwszy najnowszy):");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }

    public static void exit() {
        System.exit(0);
    }
}