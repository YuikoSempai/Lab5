package commands;

import data.Ticket;
import data.TicketType;
import utility.CollectionManager;

import java.util.Iterator;
import java.util.List;
/**
 * The command class for remove_any_by_type.
 */
public class Remove_any_by_type extends AbstractCommand {
    final int countOfArguments = 1;
    /**
     * Class constructor
     *
     * @param collection class for remove elements from collection
     */
    public Remove_any_by_type(CollectionManager collection) {
        super(collection);
    }



    /**
     * Removes an item from the collection if its type the input value.
     * @param arguments type of elements which we need to remove
     */
    @Override
    public void execute(List<Object> arguments) {
        TicketType type = TicketType.valueOf(((String) arguments.get(0)).toUpperCase());
        Iterator<Ticket> iter = collectionManager.iterator();
        while (iter.hasNext()) {
            iter.next();
            Ticket ticket = (Ticket) iter;
            if (ticket.equalsByType(type)) {
                iter.remove();
            }
        }
    }
}
