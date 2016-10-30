package kz.epam.EAuction.command.commandFacade;

import kz.epam.EAuction.controller.services.SignupServices;
import kz.epam.EAuction.controller.services.UserService;
import kz.epam.EAuction.controller.services.serviceLocator.ServiceLocator;
import kz.epam.EAuction.library.Validator;
import kz.epam.EAuction.manager.AttributesEnum;
import kz.epam.EAuction.manager.ConfigurationManager;
import kz.epam.EAuction.manager.MessageManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Вит on 24.10.2016.
 */
public class SignupCommand implements Command {
    private final String PARAM_NAME_LOGIN = "login";
    private final String PARAM_NAME_PASSWORD = "password";
    private final String PARAM_NAME_EMAIL = "email";
    private final String PARAM_NAME_FIRST_NAME = "firstName";
    private final String PARAM_NAME_SECOND_NAME = "secondName";

    public SignupCommand(){}

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession(true);
        String login = Validator.stripHarmful(request.getParameter(PARAM_NAME_LOGIN));
        String password = Validator.stripHarmful(request.getParameter(PARAM_NAME_PASSWORD));
        String email = Validator.stripHarmful(request.getParameter(PARAM_NAME_EMAIL));
        String firstName = Validator.stripHarmful(request.getParameter(PARAM_NAME_FIRST_NAME));
        String secondName = Validator.stripHarmful(request.getParameter(PARAM_NAME_SECOND_NAME));
        SignupServices signupServices = (SignupServices)
                ServiceLocator.getService(AttributesEnum.SING_UP.toString());
        UserService userService = (UserService) ServiceLocator.getService(AttributesEnum.USER_SERVICE.toString());
        if (signupServices.Valid(login,PARAM_NAME_LOGIN) &&
                signupServices.Valid(password,PARAM_NAME_PASSWORD) &&
                signupServices.Valid(email, PARAM_NAME_EMAIL) &&
                signupServices.Valid(firstName, PARAM_NAME_FIRST_NAME) &&
                signupServices.Valid(secondName, PARAM_NAME_SECOND_NAME)){
            signupServices.createUser(login, password, email, firstName,secondName);
            if (userService.isAdmin(login)){
                session.setAttribute(AttributesEnum.ADMIN.toString(), true);
            }
            session.setAttribute(AttributesEnum.USER_NAME.toString(),login);
            session.setAttribute(AttributesEnum.USER_ENTER.toString(), true);
            request.setAttribute(AttributesEnum.WELCOME.toString(), login);
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.HOME_PAGE);
        } else {
            request.setAttribute(AttributesEnum.ERROR_MESSAGE.toString(),
                    MessageManager.getInstance().getProperty(MessageManager.REGISTER_ERROR_MESSAGE));
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE);
        }
        return page;
    }
}
