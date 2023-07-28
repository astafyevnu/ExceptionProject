import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        while (true) {

            String inputValue = UI.input();
            int errorCode = UI.lengthMatching(inputValue);

            if (errorCode == -1) {
                System.out.println("Введенно данных меньше шести слов");
                System.out.println("Повторите ввод: ");
                continue;
            } else if (errorCode == 1) {
                System.out.println("Введенно данных больше шести слов");
                System.out.println("Повторите ввод: ");
                continue;
            }

            String[] array = inputValue.split(" +");
            HashMap<String, String> data = new HashMap<>();
            try {
                data = Parser.parse(array);
            } catch (RuntimeException e) {
                System.out.println(e);
                System.out.println("Пожалуйста, повторите ввод данных: ");
                continue;
            }

            System.out.println("Получены следующие данные: ");
            System.out.println(data);
            System.out.println("Программа пробует записать данные в файл...");

            try {
                Writer.writing(data);
                System.out.println("Данные успешно записаны в файл: " + data.get("surname") + ".txt");

            } catch (IOException e) {
                System.out.println("Внимание! Произошло исключение IOException. Данные не записаны...");
                e.printStackTrace();
            }
            break;
        }

    }
}
