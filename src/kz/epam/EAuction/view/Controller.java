package kz.epam.EAuction.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Вит on 21.10.2016.
 */
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Controller(){
        super();
    }


    /*protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }*/

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        processRequest(request, response);



    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
       /* String page = null;
        boolean isThrowable = false;
        if (request.getParameter("throwable") != null){
            isThrowable = request.getParameter("throwable").equals("yes");
        }
        if (!isThrowable){
            CommandInvoker commandInvoker = CommandInvoker.getInstance();
        }*/
    }

}
