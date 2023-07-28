import java.util.Scanner;

public interface UI {
    public static String input() {
        System.out.println("*****************************************************************");
        System.out.println("Введите данные латиницей, в одну строку, через пробел ");
        System.out.println("<Фамилия> <Имя> <Отчество> <датарождения> <номертелефона> <пол> ");
        System.out.println("Слова могут быть в любом порядке... ");
        System.out.println("*****************************************************************");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int lengthMatching(String str) {
        int len = str.split(" +").length;
        if (len == 6) {
            return 0;
        } else if (len < 6) {
            return -1;
        } else {
            return 1;
        }
    }
}
