import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 显示前端接收到的信息
 */
public class ServletTest1 extends HttpServlet {

    //处理方法类型为GET的请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //设置页面编码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //获取前端提交过来的参数
        String num1 = req.getParameter("num1");

        PrintWriter writer = resp.getWriter();//得到输出对象
        writer.println("获得了一个参数: "+num1);

    }
}
