package cn.minishop.shop.dao.impl;

import cn.minishop.shop.dao.IAdminDAO;
import cn.minishop.shop.vo.Admin;
import cn.minishop.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class AdminDAOImpl extends AbstractDAOImpl implements IAdminDAO {

    public AdminDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Admin vo) throws Exception {
        return false;
    }

    @Override
    public boolean doUpdate(Admin vo) throws Exception {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<String> ids) throws Exception {
        return false;
    }

    @Override
    public Admin findById(String id) throws Exception {
        return null;
    }

    @Override
    public List<Admin> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Admin> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        return null;
    }

    @Override
    public boolean findLogin(Admin vo) throws Exception {
        String sql = "SELECT lastDate FROM admin WHERE aid=? AND password=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getAid());
        super.pstmt.setString(2, vo.getPassword());
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo.setLastDate(rs.getTimestamp(1));
            return true;
        }
        return false;
    }

    @Override
    public boolean doUpdateLastdate(String aid) throws Exception {
        String sql = "UPDATE admin SET lastDate=? WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
        super.pstmt.setString(2, aid);
        return super.pstmt.executeUpdate() > 0;
    }
}
