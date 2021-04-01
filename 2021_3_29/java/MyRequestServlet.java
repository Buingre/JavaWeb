import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //获取请求的方法
        String method = req.getMethod();
        String uri = req.getRequestURI();
        String contentType = req.getContentType();
        //输出获取参数的信息
        PrintWriter writer = resp.getWriter();
        writer.println(String.format("<h2>method:%s</h2>",method));
        writer.println(String.format("<h2>uri:%s</h2>",uri));
        writer.println(String.format("<h2>contentType:%s</h2>",contentType));

    }
}
