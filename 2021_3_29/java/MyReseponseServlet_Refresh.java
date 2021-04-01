import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MyReseponseServlet_Refresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        //实现页面自动刷新

//        resp.setHeader("Refresh","1");
        resp.setIntHeader("Refresh",1);
        PrintWriter writer = resp.getWriter();
        writer.println(String.format("<h1>Data:%s</h1>",new Date()));



    }
}
