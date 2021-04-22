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

@WebServlet("/add")
public class AddToDb extends HttpServlet {
private static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
private static final String LOGIN = "postgres";
private static final String PASSWORD = "postgres";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //странная тема с формой, сначала ты ее рисуешь, апотом из нее ты получаешь
        // значения для методов, это очень странно
        ///
        //возможно такой метод только для jsp страницы так как всегда приходит null. завтра попробую!!!
        PrintWriter out = resp.getWriter();

        out.print("<form action=>\n" +
                "  <label for=\"title\">Добавить название книги:</label><br>\n" +
                "  <input type=\"text\" name=\"title\" value=\"\"><br>\n" +
                "  <input type=\"submit\" value=\"Добавить\">\n" +
                "</form> \n");


        String title = req.getParameter("title");
        if (title != null) {
            try {
                Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                PreparedStatement st = con.prepareStatement("insert into books(title) values (?)");
                st.setString(1, title);
                st.executeUpdate();

                out.print("Назавание книги \"" + title + "\" добавлено");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String path = "/bam";
         //ЭТО ВАРИК, ЕЛСИ МЫ ПРОКИДЫВАЕМ НАШ ЗАПРОС С АРГУМЕНТАМИ
//            ServletContext servletContext = getServletContext();
            //   RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/bam");
        //    requestDispatcher.forward(req, resp);
            //ВАРИК АДРЕСАЦИИ НА СТАТИКУ
            resp.sendRedirect("bam");//причем имя пишется!!! как просто URI
        }
    }
}
