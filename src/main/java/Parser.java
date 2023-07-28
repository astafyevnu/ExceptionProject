import java.util.HashMap;

public class Parser {
    public static HashMap<String, String> parse(String[] array) throws RuntimeException {

        int count = 0;
        HashMap<String, String> data = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            if (array[i].equalsIgnoreCase("m") || array[i].equalsIgnoreCase("f")) {
                if (data.get("sex") == null) {
                    data.put("sex", array[i]);
                } else {
                    throw new RuntimeException("Дублирование пола в " + (i + 1) + " слове");
                }
                continue;
            }

            if (array[i].matches("^[0-9]+$")) {
                if (data.get("phone") == null) {
                    data.put("phone", array[i]);
                } else {
                    throw new RuntimeException("Дублирование номера телефона в " + (i + 1) + " слове");
                }
                continue;
            }

            if (array[i].matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                if (data.get("date") == null) {
                    data.put("date", array[i]);
                } else {
                    throw new RuntimeException("Дублирование даты в " + (i + 1) + " слове");
                }
                continue;
            }

            if (array[i].matches("^[a-zA-Z]+$") && count == 0) {
                data.put("surname", array[i]);
                count++;
                continue;
            }

            if (array[i].matches("^[a-zA-Z]+$") && count == 1) {
                data.put("name", array[i]);
                count++;
                continue;
            }

            if (array[i].matches("^[a-zA-Z]+$") && count == 2) {
                data.put("patronymic", array[i]);
                count++;
                continue;
            }

            if (array[i].matches("^[a-zA-Z]+$") && count == 3) {
                throw new RuntimeException("Дублирование отчества в " + (i + 1) + " слове");
            }

            throw new RuntimeException("Программа не смогла распознать " + (i + 1) + " слово");

        }

        return data;

    }
}
