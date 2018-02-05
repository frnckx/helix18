import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/CookieServlet")
public class CookieServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Cookie[] cookies = req.getCookies();
        PrintWriter printWriter = resp.getWriter();

        for(Cookie c  : cookies){
        printWriter.write(" <br> Name: " + c.getName() + "Value: " + c.getValue()+ " <br>" );
                    }
                    printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        Cookie cookie = new Cookie("tesname","testvalue");
       //  cookie.setMaxAge();
        resp.addCookie(cookie);
        req.getRequestDispatcher("cookie.html").include(req,resp); // visszairányít


    }
}
