package commands;

import data.Ticket;
import utility.CollectionManager;

import java.util.Iterator;
import java.util.List;
/**
 * The command class for remove_lower.
 */
public class Remove_lower extends AbstractCommand {
    final int countOfArguments = 10;
    /**
     * Class constructor
     *
     * @param collection class for remove elements from collection
     */
    public Remove_lower(CollectionManager collection) {
        super(collection);
    }

    /**
     * Removes an item from the collection if an object created based on input values is lower.
     * @param arguments arguments for create a new ticket to compare.
     */
    @Override
    public void execute(List<Object> arguments) {

        Iterator<Ticket> iterator = collectionManager.iterator();
        Add add = new Add(this.collectionManager);
        try{
            Ticket ticketToCompare = add.createObject(arguments);
            while (iterator.hasNext()){
                Ticket ticket = iterator.next();
                if (ticket.compareTo(ticketToCompare)<0){
                    iterator.remove();
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}