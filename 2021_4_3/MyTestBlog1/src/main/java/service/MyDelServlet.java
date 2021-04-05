package service;

import dao.ArticleInfoDao;
import models.ArticleInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class MyDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = -1;
        String msg = "";

        //1.获得前端参数
        int id = Integer.parseInt(request.getParameter("id"));
        if(id>=0){
            //说明参数有效
            //2.业务处理【调用数据库进行文章删除】
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                //调用数据库删除数据方法
                int res = articleInfoDao.delArtileById(id);
                if(res>0){
                    //删除成功
                    succ=1;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else {
            msg = "参数无效";
        }

        //3.返回结果给前端
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.writeMap(response,result);
    }
}
