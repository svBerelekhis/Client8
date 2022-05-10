package command;

import java.io.Serializable;

/**
 * Энум, хранящий доступные команды
 * @autor Svetlana Berelekhis
 * @version 1.0
 */
public enum CommandNames implements Serializable {
    HELP("help : вывести справку по доступным командам"),
    INFO("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"),
    SHOW("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
    ADD("add {element} : добавить новый элемент в коллекцию"),
    UPDATE_ID("update id {element} : обновить значение элемента коллекции, id которого равен заданному"),
    REMOVE_BY_ID("remove_by_id id : удалить элемент из коллекции по его id"),
    CLEAR("clear : очистить коллекцию"),
    EXECUTE_SCRIPT("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
    EXIT("exit : завершить программу (без сохранения в файл)"),
    REMOVE_AT("remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)"),
    ADD_IF_MIN("add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции"),
    REORDER("reorder : отсортировать коллекцию в порядке, обратном нынешнему"),
    COUNT_LESS_THEN_NUMBER_OF_ROOMS("count_less_than_number_of_rooms numberOfRooms : вывести количество элементов, значение поля numberOfRooms которых меньше заданного"),
    FILTER_GREATER_THAN_TRANSPORT("filter_greater_than_transport transport : вывести элементы, значение поля transport которых больше заданного"),
    PRINT_DESCENDIND("print_descending : вывести элементы коллекции в порядке убывания"),
    NEW_USER("new_user : создать нового юзера"),
    CHANGE_PASS("change_pass : смена пароля у текущего пользователя"),
    AUTHORIZATION("authorization : смена пользователя");

    /** Строка-описание команды*/
    private final String description;

    /**
     * Конструктор - создание нового объекта
     * @param description - описание
     */
    CommandNames(String description) {
        this.description = description;
    }

    /**
     * Функция получения значения поля {@link CommandNames#description}
     * @return возвращает описание команды
     */
    public String getDescription() {
        return description;
    }
}
