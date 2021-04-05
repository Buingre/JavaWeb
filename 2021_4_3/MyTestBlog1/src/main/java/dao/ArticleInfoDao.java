package dao;

import models.ArticleInfo;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对 articleinfo 表的数据操作（增删改查用户表）
 */
public class ArticleInfoDao {
    /**
     * 用来查询个人的文章列表
     * @param uid
     * @return
     * @throws SQLException
     */
    public List<ArticleInfo> getMyArtList(int uid) throws SQLException {
        List<ArticleInfo> list = new ArrayList<>();
        Connection connection = DBUtils.getConnect();
        String sql = "select * from articleinfo where uid=?";
        PreparedStatement statement =connection.prepareStatement(sql);
        statement.setInt(1,uid);
        ResultSet resultSet = statement.executeQuery();
        //可能会返回多条记录，因此while
        while (resultSet.next()){
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setId(resultSet.getInt("id"));
            articleInfo.setTitle(resultSet.getString("title"));
            articleInfo.setContent(resultSet.getString("content"));
            articleInfo.setCreatetime(resultSet.getDate("createtime"));
            articleInfo.setUpdatetime(resultSet.getDate("updatetime"));
            articleInfo.setRcount(resultSet.getInt("rcount"));
            list.add(articleInfo);
        }
        //todo:关闭连接
        DBUtils.close(connection,statement,resultSet);
        return list;
    }

    /**
     * 删除文章的数据库操作
     * @param id
     * @return
     */
    public int delArtileById(int id) throws SQLException {
        int result = 0;
        //数据库经典操作
        Connection connection = DBUtils.getConnect();
        String sql = "delete from articleinfo where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        //真正的操作现在开始
        result = statement.executeUpdate();//会返回影响的行数
        //关闭数据库连接
        DBUtils.close(connection,statement,null);

        return result;
    }

    public  int addArt(String title,String content,int uid) throws SQLException {
        int result = 0;
        //数据库经典操作
        Connection connection = DBUtils.getConnect();
        String sql = "insert into articleinfo(title,content,uid) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, title);
        statement.setString(2, content);
        statement.setInt(3, uid);
        //真正的操作现在开始
        result  = statement.executeUpdate();
        //关闭连接
        DBUtils.close(connection,statement,null);

        return result;
    }
}
