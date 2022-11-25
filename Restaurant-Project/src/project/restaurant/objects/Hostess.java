package project.restaurant.objects;

import project.restaurant.models.Staff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static project.restaurant.interfaces.GenerateMethods.generateRandomNumber;

public class Hostess extends Staff
{
  List<Hostess> hostesses = new ArrayList<>();

  public Hostess(String firstName, String lastName, int salary) {
    super(firstName, lastName, salary);
  }

  public List<Hostess> getHostesses()
  {
    return hostesses;
  }

  public void setHostesses(List<Hostess> hostesses)
  {
    this.hostesses = hostesses;
  }

  public void getClientsOnTable(Iterator<Client> clientIterator, Restaurant restaurant, Table table, List<Table> tableList){

    int clientsForTheTable = generateRandomNumber(2, 5);
    List<Client> clientGroup = new ArrayList<>();

    for (int j = 0; j < clientsForTheTable; j++) {
      if (clientIterator.hasNext()) {
        clientGroup.add(clientIterator.next());
      }
    }
    table.setTableIsFree(false);
    table.setClientsOnTable(clientGroup);

    if (tableList.size() < restaurant.getRestaurantTableCapacity()) {
      tableList.add(table);
      restaurant.setTables(tableList);
    }
  }
}
