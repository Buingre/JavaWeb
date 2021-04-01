import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyReseponseServlet_Tiaozhuan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        //实现重定向
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        if(name!=null&& pwd!=null && name.equals("root")&&pwd.equals("root")){
            //用户名+密码正确，跳转
            //方法1
//            resp.setStatus(301);
//            resp.setHeader("location","http://www.baidu.com");
            //方法2：
            resp.sendRedirect("http://www.baidu.com");


        }else {
            PrintWriter writer = resp.getWriter();
            writer.println("<h1>输入的用户名或密码有误！</h1>");
        }

    }
}
