import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    //cookie代码写入
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通用属性
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //创建cookie
        Cookie usernameCookie = new Cookie("username","java");
        //设置cookie的最大存活时间
        usernameCookie.setMaxAge(60);//最大存活时间60s

        //用来告诉客户端存储cookie信息
        response.addCookie(usernameCookie);

        // 创建第二个cookie
        Cookie pwdCookie = new Cookie("pwd","pwd");
        pwdCookie.setMaxAge(-1);
        response.addCookie(pwdCookie);//这样客户端才能存储！！！！！！

        //提示用户cookie存储成功
        PrintWriter writer = response.getWriter();
        writer.println("<h1>cookie存储成功</h1>");

    }
}
