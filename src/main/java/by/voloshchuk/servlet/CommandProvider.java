package by.voloshchuk.servlet;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private static final CommandProvider instance = new CommandProvider();

    private Map<CommandName, Command> commands = new HashMap<>();

    private CommandProvider() {
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        //TODO парсинг строки url тк html должен писаться через abc-asd
        // <input type="hidden" name="command" value="registration">
        CommandName name = CommandName.valueOf(commandName);
        Command command;
        if (null != name) {
            command = commands.get(name);
        } else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }

}
