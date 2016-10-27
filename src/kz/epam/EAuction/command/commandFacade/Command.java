package kz.epam.EAuction.command.commandFacade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Вит on 24.10.2016.
 */
public interface Command {
    public String execute (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException;
}
