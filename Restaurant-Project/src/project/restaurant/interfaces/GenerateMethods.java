package project.restaurant.interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.restaurant.objects.*;
import project.restaurant.objects.Item;

public interface GenerateMethods {
    static Map<String, Double> generateStorage() {
        Map<String, Double> products = new HashMap<>();

        products.put("Свинско месо", 50.0);
        products.put("Пилешко месо", 50.0);
        products.put("Телешко месо", 50.0);
        products.put("Риба тон", 25.0);
        products.put("Гъби", 25.0);
        products.put("Картофи", 30.0);
        products.put("Червени пиперки", 15.0);
        products.put("Моркови", 20.0);
        products.put("Тиквички", 20.0);
        products.put("Домати", 50.0);
        products.put("Чери домати", 30.0);
        products.put("Краставици", 40.0);
        products.put("Айсберг", 30.0);
        products.put("Царевица", 15.0);
        products.put("Червен лук", 20.0);
        products.put("Лук", 25.0);
        products.put("Маслини", 10.0);
        products.put("Сирене", 20.0);
        products.put("Моцарела", 30.0);
        products.put("Колекция сирена", 15.0);
        products.put("Готварска сметана", 15.0);
        products.put("Тесто", 15.0);
        products.put("Течен шоколад", 8.0);
        products.put("Еклерова торта", 20.0);
        products.put("Шоколадово суфле", 20.0);
        products.put("Бяло вино - Еленово Шардоне", 30.0);
        products.put("Червено вино - Еленово Каберне Совиньон", 30.0);
        products.put("Росиди Розе де Пино", 30.0);
        products.put("Уиски Glenfiddich", 10.0);
        products.put("Уиски Jameson", 20.0);
        products.put("Бира Heineken", 400.0);
        products.put("Бира Starobrno", 400.0);
        products.put("Кока Кола", 360.0);
        products.put("Студен чай", 360.0);
        products.put("Минерална вода", 480.0);

        return products;
    }

    static Menu generateMenu() {

        List<Item> salads = new ArrayList<>();
        List<Item> mainDishes = new ArrayList<>();
        List<Item> desserts = new ArrayList<>();
        List<Item> drinks = new ArrayList<>();

        salads.add(new Item("Салата Капрезе", 0.350, new BigDecimal("9.90")));
        salads.add(new Item("Гръцка салата", 0.450, new BigDecimal("8.90")));
        salads.add(new Item("Салата Туна", 0.450, new BigDecimal("9.90")));

        mainDishes.add(new Item("Телешки стек със сос от манатарки", 0.550, new BigDecimal("18.90")));
        mainDishes.add(
                new Item("Свинска вратна пържола с картофи по селски", 0.550, new BigDecimal("12.50")));
        mainDishes.add(new Item("Свински сач със зеленчуци", 0.850, new BigDecimal("17.90")));
        mainDishes.add(new Item("Пилешка кавърма", 0.550, new BigDecimal("9.90")));
        mainDishes.add(new Item("Пиле четири сирена", 0.550, new BigDecimal("10.90")));

        desserts.add(new Item("Еклерова торта", 0.250, new BigDecimal("6.00")));
        desserts.add(new Item("Шоколадово суфле", 0.250, new BigDecimal("6.90")));
        desserts.add(new Item("Палачинки с шоколад", 0.250, new BigDecimal("4.90")));

        drinks.add(new Item("Бяло вино - Еленово Шардоне", 0.300, new BigDecimal("8.90")));
        drinks.add(
                new Item("Червено вино - Еленово Каберне Совиньон", 0.300, new BigDecimal("8.90")));
        drinks.add(new Item("Росиди Розе де Пино", 0.300, new BigDecimal("7.80")));
        drinks.add(new Item("Уиски Glenfiddich", 0.100, new BigDecimal("6.90")));
        drinks.add(new Item("Уиски Jameson", 0.100, new BigDecimal("5.90")));
        drinks.add(new Item("Бира Heineken", 0.500, new BigDecimal("3.50")));
        drinks.add(new Item("Бира Starobrno", 0.500, new BigDecimal("3.50")));
        drinks.add(new Item("Кока Кола", 0.350, new BigDecimal("2.50")));
        drinks.add(new Item("Студен чай", 0.350, new BigDecimal("2.50")));
        drinks.add(new Item("Минерална вода", 0.300, new BigDecimal("2.00")));

        return new Menu(salads, mainDishes, desserts, drinks);
    }

    static int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    static List<Client> generateClients() {
        List<Client> clientList = new ArrayList<>();
        int clientsForTheDay = generateRandomNumber(15, 100);
        for (int i = 0; i < clientsForTheDay; i++) {

            BigDecimal clientWallet = BigDecimal.valueOf(generateRandomNumber(40, 100));

            clientList.add(new Client(clientWallet));
        }

        return clientList;
    }

    static List<Table> generateTables(int tableCapacity, List<Table> tableList) {
        for (int i = 0; i < tableCapacity; i++) {
            Table table = new Table();
            tableList.add(table);
        }
        return tableList;
    }
}
