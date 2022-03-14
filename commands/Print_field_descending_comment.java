package commands;

import data.Ticket;
import utility.CollectionManager;

import java.util.ArrayList;
import java.util.List;
/**
 * The command class for print_filed_descending_comment.
 */
public class Print_field_descending_comment extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Print_field_descending_comment(CollectionManager collection) {
        super(collection);
    }


    /**
     * Print the values of the comment field of all elements in descending order
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {

        List<String> commentFields = new ArrayList<>();

        for (Ticket ticket: collectionManager.getAllElements()) {
            commentFields.add(ticket.getComment());
        }
        System.out.println("test");
        for (int i =commentFields.size()-1;i>0;i--){
            System.out.println(commentFields.get(i));
        }
    }
}