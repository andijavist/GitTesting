package web.servlets.secondtime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

//
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");//НЕ СИЛЬНО РЕАГИРУЕТ НА АНГЛИЙСКИЙ!но на русский выдает "??????????????", надо понять, как выводить русский
        System.out.println("привет с фронта");
        PrintWriter out = resp.getWriter();
     out.print("<h1>HELLONA  HOY</h1></dr>");//</br> не обязательно, все равно после этой строки делается перевод
     out.print("Server time "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd hh:mm:ss.SS")));
        HttpSession session = req.getSession();
        out.print("</br>"+"Session  - " + session.toString()+"</br>"+"ID - "+ session.getId());
        out.print("</br>");
        out.print("Now is ");
        out.print((session.isNew()?"New":"Old") + " session");
        out.print("</br>");
        out.print("cookies = " + req.getCookies());
        out.print("</br>");
        out.print("ReqURI = " + req.getRequestURI());
        out.print("</br>");
        out.print("ReqURL = " + req.getRequestURL());
        out.print("</br>");
        out.print("ReqMethod = " + req.getMethod());
        out.print("</br>");
        out.print("ReqContextPath = " + req.getContextPath());
        out.print("</br>");
        out.print("ReqSessionId = " + req.getRequestedSessionId());
        out.print("</br>");
        out.print("Servlet Path = " + req.getServletPath());
        out.print("</br>");
//        НЕОБХОДИМО ВЫВЕСТИ ИМЕНА ЗАГОЛОВКОВ В КОЛЛЕКЦИЮ (СЕТ) А ПОТОМ
        // ПО ЭТИМ ИМЕНАМ ВЫВЕСТИ КАЖДЫ ЗАГОЛОВОК ЧЕРЕЗ МЕТОД REQ.GETHEADER(NAME)
        //ЧУДНЫМ СПОСОБОМ СОЗДАЕМ ИТЕРАТОР req.getHeaderNames().asIterator()
        //так как getHeaderNames() является объектом ENUMERATION<> (НЕ ПОНЯТНО ЧТО ЭТО ЗА ХЕРОТА)
        out.print("<h4> ReqHeaders</h4>");
        Iterator <String> iter  = req.getHeaderNames().asIterator();
        while (iter.hasNext()){
            String name = iter.next();
            out.print(name +" "+  req.getHeader(name)+"</br>");

        }
        //данный код скачан с сайта https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro
        //СНАЧАЛА ОТРИСОВЫВАЕМ СТИЛИ
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
        //ПОТОМ ОТРИСОВЫВАЕМ СОДЕРЖАНИЕ ТАБЛИЦЫ
        out.print("<h4>HTML Table</h4>\n" +
                "\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>Company</th>\n" +
                "    <th>Contact</th>\n" +
                "    <th>Country</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Alfreds Futterkiste</td>\n" +
                "    <td>Maria Anders</td>\n" +
                "    <td>Germany</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Centro comercial Moctezuma</td>\n" +
                "    <td>Francisco Chang</td>\n" +
                "    <td>Mexico</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Ernst Handel</td>\n" +
                "    <td>Roland Mendel</td>\n" +
                "    <td>Austria</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Island Trading</td>\n" +
                "    <td>Helen Bennett</td>\n" +
                "    <td>UK</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Laughing Bacchus Winecellars</td>\n" +
                "    <td>Yoshi Tannamuri</td>\n" +
                "    <td>Canada</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Magazzini Alimentari Riuniti</td>\n" +
                "    <td>Giovanni Rovelli</td>\n" +
                "    <td>Italy</td>\n" +
                "  </tr>\n" +
                "</table>"
        );
    }
}
