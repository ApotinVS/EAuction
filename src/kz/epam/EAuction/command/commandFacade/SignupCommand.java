package kz.epam.EAuction.command.commandFacade;

import kz.epam.EAuction.controller.services.SignupServices;
import kz.epam.EAuction.controller.services.serviceLocator.ServiceLocator;
import kz.epam.EAuction.library.Validator;
import kz.epam.EAuction.manager.AttributesEnum;

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
                ServiceLocator.getService(AttributesEnum.USER_SERVICE.toString());
        UserS
        return null;
    }
}
