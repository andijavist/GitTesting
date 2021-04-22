package web.servlets.secondtime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//стырил отсюда https://stackoverflow.com/questions/36939633/tomcat-servlet-mapping-vs-webservlet-annotation
@WebServlet("/bam")//МАПИМ ЧЕРЕЗ АННОТАЦИЮ
public class JDBSServletJDBC extends HttpServlet {
    //первую строку просто надо запомнить или содрать тут https://jdbc.postgresql.org/documentation/head/connect.html
    //препод вместо localhost почему то пишет 127.0.0.1 (коненчо одно и то же, но почему то именно IP, а не DNS)
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //в этом коде без этой строки не работает хтмл кодировка
        resp.setContentType("text/html;charset=UTF-8");
        //ОЧЕНЬ ОБЯЗАТЕЛЬНАЯ ТЕМА ДЯЛ ЗАГРУЗЧИКА КЛАССОВ!!!!!!!!!!!!!!!!
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter out = resp.getWriter();

        //СОЗДАЕМ КОННЕККШН И СТЕЙТМЕНТ
        try {
            Connection connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select b.book_id, b.title, a.author_name, a.last_name" +
                                                       " from books b join authors a " +
                                                       "on a.author_id = b.author_id");
            out.print("<style>\n" +
                    "table {\n" +
                    "  font-family: arial, sans-serif;\n" +
                    "  border-collapse: collapse;\n" +
                    "  width: 100%;\n" +
                    "}\n" +
                    "\n" +
                    "td, th {\n" +
                    "  border: 1px solid #dddddd;\n" +
                    "  text-align: left;\n" +
                    "  padding: 8px;\n" +
                    "}\n" +
                    "\n" +
                    "tr:nth-child(even) {\n" +
                    "  background-color: #dddddd;\n" +
                    "}\n" +
                    "</style>");

out.print("<table>\n");
            out.print("<h3>ТАБЛИЦА АВТОРОВ</h3>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "    <th>Номер книги</th>\n" +
                    "    <th>Загшоловок</th>\n" +
                    "  </tr>\n"
                    );
            while (set.next()) {out.print(
                            "  <tr>\n" +
                            "    <td>"+set.getInt(1)+"</td>\n" +
                            "    <td>"+set.getString(2)+"</td>\n" +
                            "  </tr>\n"                            );
                               }
            out.print("</table>\n");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            out.print("<h4>ohshi</h4>");
        }
    }
}
