import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Calc extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //1.获得前端提交的参数
        Integer num1 = Integer.parseInt(req.getParameter("number1"));
        Integer num2 = Integer.parseInt(req.getParameter("number2"));
        //2.进行业务逻辑处理（只实现了加法）
        Integer ret = num1+num2;
        //3.将结果返回客户端
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>计算的结果为："+ret+"</h1>");

    }
}
