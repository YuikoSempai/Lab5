/**
 * Class for parse input arguments.
 */
package utility;

import commands.*;
import commands.interfaces.CommandInterface;
import data.TicketType;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ArgumentsParser {
    /**
     * Checks all input values and validates them. Does not check values if Scanner read from file.
     *
     * @return List<Object>
     */
    static public List<Object> parseArguments(CommandInterface command) {
        List<Object> arguments = new ArrayList<>();
        if (!Console.getReadFromFileStatus()) {
            if (command instanceof Add || command instanceof Remove_greater ||
                    command instanceof Remove_lower || command instanceof Update_id) {
                System.out.println("Введите название билета");
                arguments.add(Console.next());
                System.out.println("Введите цену за билет");
                Double price = (Double) read(Double::valueOf);
                while (price<=0){
                    System.out.println("Повторите ввод");
                    price=(Double) (read(Double::valueOf));
                }
                arguments.add(price);
                System.out.println("Введите поле comment");
                arguments.add(Console.next());
                System.out.println("Введите координату x");
                Integer x = (Integer) read(Integer::valueOf);
                while (x <= -960){
                    System.out.println("Повторите ввод");
                    x=(Integer) (read(Integer::valueOf));
                }
                arguments.add(x);
                System.out.println("Введите координату y");
                arguments.add(read(Float::valueOf));
                System.out.println("Выберите и введите тип билета:");
                for (TicketType type : TicketType.values()) {
                    System.out.println(type);
                }
                arguments.add(read(TicketType::valueOf));
                System.out.println("Введите дату рождения персонажа в формате yyyy-MM-dd");
                arguments.add(read((String str) -> LocalDate.parse(str, DateTimeFormatter.ISO_LOCAL_DATE)));
                System.out.println("Введите рост персонажа");
                Float height = (Float) read(Float::valueOf);
                while (height <= 0){
                    System.out.println("Повторите ввод");
                    height=(Float) (read(Float::valueOf));
                }
                arguments.add(height);
                System.out.println("Введите вес персонажа");
                Integer weight = (Integer) read(Integer::valueOf);
                while (weight <= 0){
                    System.out.println("Повторите ввод");
                    weight=(Integer) (read(Integer::valueOf));
                }
                arguments.add(weight);
                System.out.println("Введите passportId персонажа");
                arguments.add(Console.next());
                return arguments;
            }

            if (command instanceof Execute_script) {
                boolean flag = true;
                while (flag) {
                    String filePath = Console.nextLine();
                    Path path = Paths.get(filePath);
                    try {
                        if (Files.exists(path)) {
                            flag = false;
                            arguments.add(filePath);
                        } else {
                            System.out.println("Файл не существует, повторите ввод");
                        }
                    } catch (SecurityException e) {
                        System.out.println("Ошибка прав доступа к файлу");
                    }
                }
            }
            if (command instanceof Remove_by_id) {
                arguments.add(read(Long::valueOf));
            }
        } else {
            arguments = parseArgumentsFromFIle(command);
        }
        return arguments;
    }

    /**
     * @param command - command which arguments need to parse.
     * @return list with (Object) arguments
     */
    public static List<Object> parseArgumentsFromFIle(CommandInterface command) {
        List<Object> arguments = new ArrayList<>();

        for (int i = 0; i < command.getCountOfArguments(); i++) {
            arguments.add(Console.next());
        }

        return arguments;
    }

    /**
     * Validate input for fields
     *
     * @param check - function for validate new field
     * @return the field that passed verification.
     */
    private static Object read(Function<String, Object> check) {
        while (true) {
            String str = Console.next();
            try {
                return check.apply(str);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Ошибка ввода, попробуйте ещё раз");
            }
        }
    }
}

