import static project.restaurant.interfaces.GenerateMethods.generateClients;
import static project.restaurant.interfaces.GenerateMethods.generateRandomNumber;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project.restaurant.objects.Client;
import project.restaurant.objects.Restaurant;
import project.restaurant.objects.Table;
import project.restaurant.objects.Waiter;


public class Main {

    static Restaurant restaurant = new Restaurant("При Шестаците", new BigDecimal(420),
            new BigDecimal(0), 15);

    public static void main(String[] args) {
        restaurant.open();
        work(restaurant);
        restaurant.close();
    }

    private static void work(Restaurant restaurant) {

        Iterator<Client> clientIterator = generateClients().listIterator();

        List<Table> tableList = new ArrayList<>();

        while (clientIterator.hasNext()) {

            if (restaurant.isRestaurantIsFull()) {
                System.out.println("The restaurant is full, if you'd like, you could wait for a table to get free.");

                restaurant.setRestaurantIsFull(false);

                int randomTable = generateRandomNumber(0, restaurant.getTables().size());
                tableList.get(randomTable).setTableIsFree(true);
            }

            for (Table table : restaurant.getTables()) {

                if (!table.isTableIsFree()) {
                    continue;
                }

                restaurant.getHostesses().get(generateRandomNumber(0, restaurant.generateHostesses().size()))
                        .getClientsOnTable(clientIterator, restaurant, table, tableList);

                checkTheWaiterInCharge(restaurant, table);

            }
            restaurant.setRestaurantIsFull(true);
        }

    }

    private static void checkTheWaiterInCharge(Restaurant restaurant, Table table) {

        if (table.getTableNumber() <= 5) {
            restaurant.getWaiters().get(0).getOrder(table, restaurant);
            pay(restaurant.getWaiters().get(0), table.getClientsOnTable());

        } else if (table.getTableNumber() > 5 && table.getTableNumber() <= 10) {
            restaurant.getWaiters().get(1).getOrder(table, restaurant);
            pay(restaurant.getWaiters().get(1), table.getClientsOnTable());

        } else if (table.getTableNumber() > 10 && table.getTableNumber() <= 15) {
            restaurant.getWaiters().get(2).getOrder(table, restaurant);
            pay(restaurant.getWaiters().get(2), table.getClientsOnTable());
        }
    }

    private static void pay(Waiter waiter, List<Client> clientGroup) {
        for (Client client : clientGroup) {
            client.payBill(waiter);
        }
    }
}

