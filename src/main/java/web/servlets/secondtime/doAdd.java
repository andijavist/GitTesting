package web.servlets.secondtime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;

@WebServlet("/doAdd")
public class doAdd extends HelloServlet{
    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN = "postgres";
    private final static String PASSWORD = "postgres";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String title = req.getParameter("title");
        String id = req.getParameter("id");
        String authId = req.getParameter("authId");
        String authName = req.getParameter("authName");
        String authLastName = req.getParameter("authLastName");

    if (((title!=null)||(id!=null)
                      ||(authId!=null)
                      ||(authName!=null)
                      ||(authLastName!=null))
                      ||((!title.isEmpty())
                      ||(!id.isEmpty())
                      ||(!authId.isEmpty())
                      ||(!authName.isEmpty())
                      ||(!authLastName.isEmpty())))
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            PreparedStatement statement = con.prepareStatement("insert into books (title, book_id) values(?,?)");
            statement.setString(1,title);
            statement.setInt(2,Integer.valueOf(id));
            statement.executeUpdate();
            statement = con.prepareStatement("insert into authors (author_id, author_name, last_name) values(?,?,?)");
            statement.setInt(1,Integer.valueOf(authId));
            statement.setString(2,authName);
            statement.setString(3,authLastName);
            statement.executeUpdate();
            con.close();
            out.print("<form action=bam\n" +
                    "  <label for=\"title\">Все добавлено:</label><br>\n" +
                    "  <input type=\"submit\" value=\"Смотреть таблицу\">\n" +
                    "</form> \n");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            out.print("чего то не так");
        }
    }
    else out.print("веталик, ты че");
    }
}
