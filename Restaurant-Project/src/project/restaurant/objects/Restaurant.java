package project.restaurant.objects;

import static project.restaurant.interfaces.GenerateMethods.generateMenu;
import static project.restaurant.interfaces.GenerateMethods.generateStorage;
import static project.restaurant.interfaces.GenerateMethods.generateTables;

import java.math.BigDecimal;
import java.util.*;

import project.restaurant.interfaces.ColorAble;

public class Restaurant implements ColorAble {
  /*
  This class implements our restaurant.
  it includes his name, revenue, free tables and turnover which we will calculate later
   */

    private String restaurantName;
    private BigDecimal revenue;
    private BigDecimal turnover;
    private List<Waiter> waiters;
    private List<Chef> chefs;

    private List<Hostess> hostesses;
    private int restaurantTableCapacity;
    private Menu menu;
    private Storage storage;
    private List<Table> tables;
    private boolean restaurantIsFull;

    public Restaurant(String restaurantName, BigDecimal revenue, BigDecimal turnover,
                      int restaurantTableCapacity) {
        this.restaurantName = restaurantName;
        this.revenue = revenue;
        this.turnover = turnover;
        this.restaurantTableCapacity = restaurantTableCapacity;
        this.restaurantIsFull = false;
        tables = new ArrayList<>();
        waiters = new ArrayList<>();
        chefs = new ArrayList<>();
    }

    public void setWaiters(List<Waiter> waiters) {
        this.waiters = waiters;
    }

    public boolean isRestaurantIsFull() {
        return restaurantIsFull;
    }

    public void setRestaurantIsFull(boolean restaurantIsFull) {
        this.restaurantIsFull = restaurantIsFull;
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public int getRestaurantTableCapacity() {
        return restaurantTableCapacity;
    }

    public void setRestaurantTableCapacity(int restaurantCapacity) {
        this.restaurantTableCapacity = restaurantCapacity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Waiter> getWaiters() {
        return waiters;
    }

    public List<Hostess> getHostesses() {
        return hostesses;
    }

    public void setHostesses(List<Hostess> hostesses) {
        this.hostesses = hostesses;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void open() {
        setMenu(generateMenu());
        printMenu();
        setStorage(new Storage(generateStorage()));
        setChefs(generateChefs());
        setTables(generateTables(restaurantTableCapacity, getTables()));
        setWaiters(generateWaiters());
        setHostesses(generateHostesses());

    }

    public void close() {
        storage.printStorage();
        getProductPopularity();
        accountancy();
    }

    public List<Hostess> generateHostesses(){
        List<Hostess> hostessList = new ArrayList<>();

        hostessList.add(new Hostess("Николета", "Лозанова", 70));
        hostessList.add(new Hostess("Рая", "Пеева", 70));

        return hostessList;
    }
    public List<Waiter> generateWaiters() {
        List<Waiter> waiterList = new ArrayList<>();

        waiterList.add(new Waiter("Елена", "Наумова", 50, new BigDecimal(0),
                new BigDecimal(40),
                new BigDecimal(0)));

        waiterList.add(new Waiter("Биляна", "Димитрова", 50,
                new BigDecimal(0),
                new BigDecimal(40),
                new BigDecimal(0)));

        waiterList.add(new Waiter("Ивана", "Джешкович", 50,
                new BigDecimal(0),
                new BigDecimal(40),
                new BigDecimal(0)));

        return waiterList;
    }

    public List<Chef> generateChefs() {
        List<Chef> chefList = new ArrayList<>();

        chefList.add(new Chef("Иван", "Георгиев", 90));

        chefList.add(new Chef("Мария", "Петрова", 90));

        chefList.add(new Chef("Георги", "Георгиев", 90));

        chefList.add(new Chef("Ивана", "Тихомирова", 90));

        return chefList;
    }


    public Map<String, Integer> soldStuff(List<String> allSoldItemsFromMenu) {

        Map<String, Integer> products = new TreeMap<>();

        for (String item : allSoldItemsFromMenu) {
            if (products.containsKey(item)) {
                products.put(item, products.get(item) + 1);
            } else {
                products.put(item, 1);
            }
        }
        return products;
    }

    public void deleteFromTheMenu(String keyMin) {
        Menu newMenu = generateMenu();
        for (int i = 0; i < newMenu.getSalads().size(); i++) {

            if (newMenu.getSalads().get(i).getProductName().equals(keyMin)) {
                newMenu.getSalads().remove(newMenu.getSalads().get(i));
            }
        }
        for (int i = 0; i < newMenu.getMainDishes().size(); i++) {

            if (newMenu.getMainDishes().get(i).getProductName().equals(keyMin)) {
                newMenu.getMainDishes().remove(newMenu.getMainDishes().get(i));
            }

        }
        for (int i = 0; i < newMenu.getDesserts().size(); i++) {
            if (newMenu.getDesserts().get(i).getProductName().equals(keyMin)) {
                newMenu.getDesserts().remove(newMenu.getDesserts().get(i));
            }
        }
        for (int i = 0; i < newMenu.getDrinks().size(); i++) {
            if (newMenu.getDrinks().get(i).getProductName().equals(keyMin)) {
                newMenu.getDrinks().remove(newMenu.getDrinks().get(i));
            }
        }
        newMenu.printNewMenu();
    }

    public void printMenu() {
        System.out.println(ANSI_YELLOW + "Меню При Шестаците");
        getAllSalads();
        getAllMainDishes();
        getAllDeserts();
        getAllDrinks();
    }

    public void getAllDrinks() {
        int counter = 0;

        System.out.println(ANSI_RED + "Напитки");
        for (Item item : generateMenu().getDrinks()) {
            System.out.printf("|%-2d. %-45s %.3f мл. %20.2f лв.| \n",
                    ++counter, item.getProductName(), item.getProductAmount(), item.getProductPrice());
        }
        System.out.println(ANSI_RESET);
    }

    public void getAllDeserts() {
        int counter = 0;
        System.out.println(ANSI_CYAN + "Десерти");
        for (Item item : generateMenu().getDesserts()) {
            System.out.printf("|%-2d. %-45s %.3f гр. %20.2f лв.| \n",
                    ++counter, item.getProductName(), item.getProductAmount(), item.getProductPrice());
        }
        System.out.println(ANSI_RESET);
    }

    public void getAllSalads() {
        int counter = 0;
        System.out.println(ANSI_GREEN + "Салати");
        for (Item item : generateMenu().getSalads()) {
            System.out.printf("|%-2d. %-45s %.3f гр. %20.2f лв.| \n",
                    ++counter, item.getProductName(), item.getProductAmount(), item.getProductPrice());
        }
        System.out.println(ANSI_RESET);
    }

    public void getAllMainDishes() {
        int counter = 0;
        System.out.println(ANSI_BLUE + "Основни ястия");
        for (Item item : generateMenu().getMainDishes()) {
            System.out.printf("|%-2d. %-45s %.3f гр. %20.2f лв.| \n",
                    ++counter, item.getProductName(), item.getProductAmount(), item.getProductPrice());
        }
        System.out.println(ANSI_RESET);
    }

    public void getProductPopularity() {

        Map<String, Integer> allProducts = soldStuff(waiters.get(0).getAllOrdersForTheDay());

        System.out.println(ANSI_PURPLE + "Днес бяха поръчани: ");

        allProducts.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.printf("%-45s %d бр. \n", k.getKey(), k.getValue()));
        System.out.println(ANSI_RESET);
        //k.getKey() + ": " + k.getValue())

        String keyMin = Collections.min(allProducts.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(ANSI_CYAN + "Най-слабо продаваният продукт е: " + keyMin + ANSI_RESET);

        String keyMax = Collections.max(allProducts.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println(ANSI_CYAN + "Най-добре продаваният продукт е: " + keyMax + ANSI_RESET);
        System.out.println(ANSI_RESET);

        deleteFromTheMenu(keyMin);
    }

    public void accountancy() {

        BigDecimal turnoverForTheDay = new BigDecimal(0);

        for (Waiter waiter : getWaiters()) {
            turnoverForTheDay = turnoverForTheDay.add(waiter.getTurnoverWallet());
        }
        System.out.printf(ANSI_GREEN + "Оборотът за деня е: %.2f лв.\n", turnoverForTheDay);
        System.out.println(ANSI_RESET);

        System.out.println(ANSI_PURPLE + "Сервитьорките получили бакшиш са:");
        for (Waiter waiter : getWaiters()) {
            if (waiter.getTips().compareTo(BigDecimal.ZERO) > 0) {
                System.out.printf("%s %s - %.2f лв. \n", waiter.getFirstName(), waiter.getLastName(), waiter.getTips());
            }
        }
        System.out.println(ANSI_RESET);
    }
}

