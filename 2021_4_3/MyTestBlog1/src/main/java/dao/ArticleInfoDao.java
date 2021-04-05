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
        return list;
    }
}
