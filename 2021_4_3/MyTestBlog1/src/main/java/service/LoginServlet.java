package service;

import dao.UserInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int state = -1;
        String msg = "";

        /**步骤：
         * 1.获取参数
         * 2.调用数据库验证参数（用户名和密码）
         * 3.返回信息给前台
         */



        //1.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用数据库验证参数（用户名和密码）
        if(username!=null && password!=null){
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                state = userInfoDao.isLogin(userInfo)?200:100;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            msg = "操作失败，参数不全！";
        }
        //3.返回信息给前台
        HashMap<String,Object> result = new HashMap<>();
        result.put("state",state);
        result.put("msg",msg);
        ResultJSONUtils.writeMap(response,result);
    }
}
