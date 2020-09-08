package by.ginko.command.grouppresons;

import by.ginko.command.Command;
import by.ginko.command.CommandResult;
import by.ginko.exception.IncorrectDataException;
import by.ginko.exception.ServiceException;
import by.ginko.model.Person;
import by.ginko.service.PersonService;
import by.ginko.util.pages.Page;
import static by.ginko.command.grouppresons.constant.GroupConstant.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {

        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}

