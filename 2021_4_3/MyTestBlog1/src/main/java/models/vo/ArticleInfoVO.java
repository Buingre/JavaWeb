package models.vo;

import models.ArticleInfo;

/**
 * 因为联合查询  基础类没有哪个属性
 */
public class ArticleInfoVO extends ArticleInfo {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
