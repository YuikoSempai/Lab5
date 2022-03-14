package commands;

import data.Ticket;
import utility.CollectionManager;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * The command class for group_counting_by_price.
 */
public class Group_counting_by_price extends AbstractCommand{
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Group_counting_by_price(CollectionManager collection) {
        super(collection);
    }
    
    /**
     * Groups objects by price and displays the number of objects in each group
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {
        Map<Double, Integer> priceMap = new HashMap<>();
        for (Ticket ticket : collectionManager.getAllElements()) {
            priceMap.put(ticket.getPrice(), priceMap.getOrDefault(ticket.getPrice(),0)+1);
        }
        for (Map.Entry<Double, Integer> entry : priceMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
//            System.out.println(entry); - то же самое, только вместо пробела =
        }
    }
}
