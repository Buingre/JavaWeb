package dao;

import models.UserInfo;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对 userinfo 表的数据操作（增删改查用户表）
 */
public class UserInfoDao {

    /**
     * 增加用户 《-------》对应注册功能
     * @param userInfo  传入userInfo对象
     * @return
     */
    public  boolean add(UserInfo userInfo) throws SQLException {
        boolean result = false;//默认没有进行添加操作--》为false
        //还是要非空校验
        if(userInfo.getUsername()!=null && userInfo.getPassword()!=null){
            //if 是正常的参数
            Connection connection = DBUtils.getConnect();
            String sql = "insert into userinfo(username,password) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userInfo.getUsername());
            statement.setString(2,userInfo.getPassword());
            result = statement.executeUpdate()>=1?true:false;
            // 关闭连接
            DBUtils.close(connection,statement,null);
        }
        return result;
    }

    /**
     *   校验用户 《-------》对应登录功能
     * @param userInfo
     * @return
     * @throws SQLException
     */
    public boolean isLogin(UserInfo userInfo) throws SQLException {
        boolean result = false;
        //还是要进行非空校验
        if(userInfo.getUsername()!=null && userInfo.getPassword()!=null
                && !userInfo.getUsername().equals("") && !userInfo.getPassword().equals("")){
            //开始经典4？部曲
            Connection connection = DBUtils.getConnect();
            String sql = "select * from userinfo where username=? and password=? and state=1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userInfo.getUsername());
            statement.setString(2,userInfo.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){//如果有这个值的话  if为true
                result = true;
            }

        }


        return result;
    }

    //todo:笔记！！！！
    /**
     * 获取userInfo对象
     * 主要是为了得到uid
     * @param userInfo
     * @return
     * @throws SQLException
     */
    public UserInfo getUserInfo(UserInfo userInfo) throws SQLException {
        UserInfo user = new UserInfo();
        //todo:如果出问题可能是这里的问题
        // 还是要非空校验
        if(userInfo.getUsername()!=null && userInfo.getPassword()!=null
                && !userInfo.getUsername().equals("") && !userInfo.getPassword().equals("")){
            Connection connection = DBUtils.getConnect();
            String sql = "select * from userinfo where username=? and password=? and state = 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userInfo.getUsername());
            statement.setString(2,userInfo.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                //在这里获取到的id，并设置id
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        }
        Connection connection = DBUtils.getConnect();


        return user;
    }

}
