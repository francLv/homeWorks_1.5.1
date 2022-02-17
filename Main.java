import java.util.Scanner;
//import java.lang.String;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static String ask(String massage, String example) {
        System.out.println(massage);
        System.out.println("Например: " + example);
        System.out.println(">> ");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }
    public static int extractTime(String task, String phrase) {
        int pos = task.indexOf(phrase);
        pos += phrase.length();
        String timeStr = task.substring(pos, pos + 2);
        timeStr = timeStr.trim();
        return Integer.parseInt(timeStr);
    }

    public static void main(String[] args) {
        String name = ask("Имя", "Петя");

        int totalTime = 0;
        int totalFinishTime = 0;
        int maxTime = 0;
        int taskCount = 0;
        while (true) {
            String input = ask(
                    "Введи задачу на сегодня или end для выхода",
                    "Буду программировать, начну с 11 и закончу в 17 часов"

            );
            if(input.equals("end")){
                break;
            }
            int startTime = extractTime(input, "начну с "); // время старта
            int endTime = extractTime(input, "закончу в "); // и окончания нашей задачи
            int spentTime = endTime - startTime; //  и время, которое на нее тратит пользователь
            totalTime += spentTime; // обновим наши переменные статистики
            totalFinishTime = Math.max(totalFinishTime, totalTime); // выбираем максимальное из двух
            maxTime = Math.max(maxTime, spentTime);
            taskCount ++;// увеличиваем счетчик задач
        }
        System.out.println(
                "Уважаемый, " + name + "! О Ваших планах на сегодня:\n" +
                        " Всего задач: " + taskCount + "\n" +
                        " Последняя закончится в " + totalFinishTime + "\n" +
                        " В среднем задача занимает " +
                        (taskCount != 0 ? (totalTime * 60) / taskCount : 0) + " минут\n" +
                        " Самая продолжительная задача на сегодня займет " +
                        totalTime + " часов\n" +
                        "УДАЧИ НА СЕГОДНЯ!"
        );// покажем статистику
    }
}
