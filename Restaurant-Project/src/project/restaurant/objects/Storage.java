package project.restaurant.objects;

import project.restaurant.interfaces.ColorAble;

import java.util.Map;

public class Storage implements ColorAble {
    public Map<String, Double> availableProducts;

    public Storage(Map<String, Double> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public Map<String, Double> getAvailableProducts() {
        return availableProducts;
    }

    public void printStorage() {
        System.out.println(ANSI_YELLOW + "Складова наличност:" + "\n");

        for (Map.Entry<String, Double> product : availableProducts.entrySet()) {
            if (product.getKey().equalsIgnoreCase("Минерална вода") || product.getKey().equalsIgnoreCase("Студен чай") ||
                    product.getKey().equalsIgnoreCase("Кока Кола") || product.getKey().equalsIgnoreCase("Бира Starobrno") ||
                    product.getKey().equalsIgnoreCase("Бира Heineken")) {
                System.out.printf("%-40s  %.2f бр. \n", product.getKey(), product.getValue());
            } else if (product.getKey().equalsIgnoreCase("Уиски Jameson") || product.getKey().equalsIgnoreCase("Уиски Glenfiddich") ||
                    product.getKey().equalsIgnoreCase("Росиди Розе де Пино") || product.getKey().equalsIgnoreCase("Червено вино - Еленово Каберне Совеньон") ||
                    product.getKey().equalsIgnoreCase("Бяло вино - Еленово Шардоне") || product.getKey().equalsIgnoreCase("Готварска сметана")) {
                System.out.printf("%-40s  %.2f л. \n", product.getKey(), product.getValue());
            } else {
                System.out.printf("%-40s  %.2f кг. \n", product.getKey(), product.getValue());
            }
        }
        System.out.println(ANSI_RESET);
    }
}
