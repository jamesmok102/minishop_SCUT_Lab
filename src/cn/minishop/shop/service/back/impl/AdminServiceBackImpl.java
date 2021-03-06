package cn.minishop.shop.service.back.impl;

import cn.minishop.shop.dbc.DatabaseConnection;
import cn.minishop.shop.factory.DAOFactory;
import cn.minishop.shop.service.back.IAdminServiceBack;
import cn.minishop.shop.vo.Admin;

public class AdminServiceBackImpl implements IAdminServiceBack {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean login(Admin vo) throws Exception {
        try {
            if (DAOFactory.getIAdminDAOInstance(this.dbc.getConnection()).findLogin(vo)) {
                return DAOFactory.getIAdminDAOInstance(this.dbc.getConnection()).doUpdateLastdate(vo.getAid());
            }
            return false;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
