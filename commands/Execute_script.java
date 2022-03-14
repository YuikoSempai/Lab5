/**
 * The command class for execute_script.
 */

package commands;

import utility.CollectionManager;
import utility.Console;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Execute_script extends AbstractCommand {
    final int countOfArguments = 1;
    static final List<Path> pathList = new ArrayList<>(); // почему не HashSet?

    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Execute_script(CollectionManager collection) {
        super(collection);
    }

    /**
     * Executes the script along the path that is passed to it
     * @param arguments path for script
     */
    @Override
    public void execute(List<Object> arguments) {
        String filePath = (String) arguments.get(0);
        try {
            Path path = Paths.get(filePath.replace("/","//"));
            if(!pathList.contains(path)) {
                Console.scannerIn = new Scanner(path);
                Console.setReadFromFileStatus(true);
                pathList.add(path);
            }else{
                System.out.println("Данный скрипт уже запущен");
            }
        }catch (Exception e){
            System.out.println("Wrong path for command");
        }
    }

    /**
     * Removes the path where the script was executed from the list of paths for currently running scripts
     */
    static public void deleteLastPath(){
        pathList.remove(pathList.size()-1);
    }
}