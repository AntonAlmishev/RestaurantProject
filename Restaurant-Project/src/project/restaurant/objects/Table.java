package project.restaurant.objects;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private int tableNumber;
    private static int incNumber = 0;
    private List<Client> clientsOnTable;
    private boolean tableIsFree;

    public Table() {

        this.tableNumber = ++incNumber;
        this.clientsOnTable = new ArrayList<>(4);
        this.tableIsFree = true;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public List<Client> getClientsOnTable() {
        return clientsOnTable;
    }

    public void setClientsOnTable(List<Client> clientsOnTable) {
        this.clientsOnTable = clientsOnTable;
    }

    public boolean isTableIsFree() {
        return tableIsFree;
    }

    public void setTableIsFree(boolean tableIsFree) {
        this.tableIsFree = tableIsFree;
    }
}
