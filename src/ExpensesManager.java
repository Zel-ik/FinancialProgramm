import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories; // Замените на таблицу с именем expensesByCategories

    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // Создайте таблицу
    }

    // Добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        // Замените на работу с таблицей
        if (expensesByCategories.containsKey(category)){ // Проверьте наличие категории
            ArrayList<Double> list = expensesByCategories.get(category); // Получите список трат в этой категории
            list.add(expense); // Добавьте трату
    } else {
            ArrayList<Double> newExpense = new ArrayList<>();
            newExpense.add(expense);// Создайте новый список трат и добавьте в него сумму
            expensesByCategories.put(category,newExpense); // Сохраните категорию и новый список трат в хеш-таблицу
    }
        if (moneyBeforeSalary < 1000) {
        System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
    }
        return moneyBeforeSalary;
}


    void printAllExpensesByCategories() {
        // Замените логику для работы с таблицами
        for(String category : expensesByCategories.keySet()) {
            System.out.println(category);

            for (ArrayList<Double> expenses : expensesByCategories.values()) {
                for (double expense : expenses) {
                    System.out.println(expense);
                }
            }
        }
    }

    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpense(String category) {
        double maxExpense = 0;
        if(expensesByCategories.containsKey(category)) {
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double exp : expenses) {
                if (exp > maxExpense) {
                    maxExpense = exp;
                }
            }
            return maxExpense;
        }else System.out.println("Такой категории пока нет.");
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // Таблица называется иначе
        System.out.println("Траты удалены.");
    }
}