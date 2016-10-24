package kz.epam.EAuction.view;

import java.io.IOException;

/**
 * Created by Вит on 21.10.2016.
 */
public class Controller extends javax.servlet.http.HttpServlet {
    private static int count = 0;
    /*protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }*/

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        count++;

        request.setAttribute("current_count",count);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
