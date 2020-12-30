package application;

import Model.DAO.Fabrica_dao;
import Model.DAO.impl.Vendedor_dao_JDBC;
import db.DB;
import java.sql.Connection;

public class DB_Projeto {
    public static void main(String[] args) {
        
        Connection con = DB.getConnection();
        
        Vendedor_dao_JDBC vendedor = Fabrica_dao.createVendedorDao(con);
        System.out.println(vendedor.findById(3));
    }

}
