package web.servlets.secondtime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Collections;

@WebServlet("/add2")
public class Jdbc2 extends HttpServlet {
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //ИНТЕРЕСНОЕ НАБЛЮДЕНИЕ, ЕСЛИ НЕ ЗАДАТЬ ЧАРСЕТ ДО СОЗДАНИЯ ПРИНВРАЙТЕРА, ТО РУССКИЙ НЕ БУДЕТ РАСПОЗНАВАТЬСЯ
        PrintWriter out= resp.getWriter();
        out.print("<h1>Для записи в БД Вам неоходимо ввести в соответсвующую информацию</h1>\n");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        out.print("<form action=doAdd>" +
                "  <label for=title> Добавить название книги:</label><br>" +
                "  <input type=text name=title value=><br>" +
                "  <label for=id> Добавить Id книги</label><br>\n" +
                "  <input type=text name=id value=><br>" +
                "  <label for=authId> Добавить Id автора</label><br>\n" +
                "  <input type=text name=authId value=><br>\n" +
                "  <label for=authName> Добавить имя автора</label><br>\n" +
                "  <input type=text name=authName value=><br>\n" +
                "  <label for=authLastName> Добавить фамилию автора</label><br>\n" +
                "  <input type=text name=authLastName value=><br>\n" +
                "  <input type=submit value=\"Добавить\">\n" +
                "</form> \n");
            }

}
