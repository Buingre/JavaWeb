package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 */
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        int state = -1;//200表示接口执行成功
        String msg = "";
        //1.接收前端的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        if(username==null||password==null){
            msg = "参数不正确";
        }else {
            //操作数据库，进行插入操作
            //UserInfo
            //UserInfoDao
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            //调用数据库的方法
            UserInfoDao userInfoDao = new UserInfoDao();
            //调用插入方法，操作数据库
            try {
                boolean result = userInfoDao.add(userInfo);
                if(result){
                    //操作成功
                    state = 200;
                }else{
                    //操作数据库失败
                    state = 100;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        //{"state":100,"msg":"msg"}
        //writer.println("{\"state\":"+state+",\"msg\":\""+msg+"\"}");
        //todo:hashmap-->字符串
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", state);
        result.put("msg", msg);
        ObjectMapper mapper = new ObjectMapper();
        // 调用统一的输出方法进行输出
        ResultJSONUtils.write(response, mapper.writeValueAsString(result));



    }
}
