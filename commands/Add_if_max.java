/**
 * The command class for add_if_max.
 */

package commands;

import data.Ticket;
import utility.CollectionManager;

import java.util.List;

public class Add_if_max extends Add{

    final int countOfArguments = 10;

    /**
     * Class constructor
     *
     * @param collection class for add new elements to collection
     */
    public Add_if_max(CollectionManager collection) {
        super(collection);
    }

    @Override
    public void execute(List<Object> arguments) {
        Ticket ticket = createObject(arguments);
        if (collectionManager.last().compareTo(ticket)>0){
            collectionManager.add(ticket);
        }
    }
}
