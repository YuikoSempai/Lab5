package commands;

import data.Ticket;
import utility.CollectionManager;

import java.util.List;

/**
 * Class for command update_id
 */
public class Update_id extends AbstractCommand {
    final int countOfArguments = 10
    ;
    /**
     * Class constructor
     *
     * @param collection class for update elements from collection
     */
    public Update_id(CollectionManager collection) {
        super(collection);
    }

    /**
     * Update the id of the object that based on input values.
     * @param arguments id of element which we need to update
     */
    @Override
    public void execute(List<Object> arguments) {
        for(Ticket ticket: collectionManager.getAllElements()){
            if(ticket.getId() == (Long) arguments.get(0)){
                ticket.setId();
            }
        }
    }
}