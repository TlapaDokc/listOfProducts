import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static <list> void listOutput(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию и введите ее номер: " + "\n" +
                    "1. Добавить продукт" + "\n" +
                    "2. Показать продукт" + "\n" +
                    "3. Удалить продукт" + "\n" +
                    "4. Найти продукт");
            String inputOperation = sc.next();
            int numberOperation;
            try {
                numberOperation = Integer.parseInt(inputOperation);
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести цифру от 1 до 4");
                continue;
            }

            if (numberOperation == 1) {
                System.out.println("Какую покупку хотите добавить?");
                String inputProduct = sc.next();
                list.add(inputProduct);
                System.out.println("Итого в списке покупок: " + list.size());
                continue;
            }

            if (numberOperation == 2) {
                System.out.println("Список покупок: ");
                listOutput(list);
                continue;
            }

            if (numberOperation == 3) {
                if (!list.isEmpty()) {
                    System.out.println("Список покупок: ");
                    listOutput(list);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    String removeObject = sc.next();
                    int numberRemoveObject;
                    try {
                        numberRemoveObject = Integer.parseInt(removeObject);
                    } catch (NumberFormatException e) {
                        System.out.println("Покупка " + removeObject + " удалена, ");
                        list.remove(removeObject);
                        if (!list.isEmpty()) {
                            System.out.println("список покупок: ");
                            listOutput(list);
                            continue;
                        } else {
                            System.out.println("Список пуст");
                            continue;
                        }
                    }
                    System.out.println("Покупка " + removeObject + " удалена, ");
                    list.remove(numberRemoveObject - 1);
                    if (!list.isEmpty()) {
                        System.out.println("список покупок: ");
                        listOutput(list);
                        continue;
                    } else {
                        System.out.println("Список пуст");
                        continue;
                    }
                }
                System.out.println("Список пуст");
                continue;
            }

            if (numberOperation == 4) {
                if (!list.isEmpty()) {
                    System.out.println("Введите текст для поиска: ");
                    String search = sc.next();
                    String item;
                    boolean match;
                    List<Integer> flag = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        item = list.get(i);
                        search.toLowerCase();
                        item.toLowerCase();
                        match = item.contains(search);
                        if (match) {
                            System.out.println((i + 1) + ". " + list.get(i));
                        } else {
                            flag.add(i);
                        }
                    }
                    if (flag.size() == list.size()) {
                        System.out.println("Совпадений нет");
                    }
                    continue;
                } else {
                    System.out.println("Список пуст");
                    continue;
                }
            }
            System.out.println("Вы ввели не корректное значение");
            continue;
        }
    }
}
