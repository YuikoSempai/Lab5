
package commands;

import data.Ticket;
import utility.CollectionManager;

import java.util.List;
/**
 * The command class for save.
 */
public class Show extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for show elements from collection
     */
    public Show(CollectionManager collection) {
        super(collection);
    }
    
    /**
     * print all elements of collection.
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {
        for (Ticket ticket : collectionManager.getAllElements()) {
            System.out.println(ticket.toString());
        }
    }
}
