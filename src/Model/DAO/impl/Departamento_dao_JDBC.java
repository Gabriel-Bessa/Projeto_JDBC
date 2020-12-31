package Model.DAO.impl;

import Model.entities.Departamento;
import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Model.DAO.Departamento_dao;

public class Departamento_dao_JDBC implements Departamento_dao {

    private Connection con;

    public Departamento_dao_JDBC(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Departamento obj) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("INSERT INTO department "
                    + "( Name) "
                    + "VALUES "
                    + "(?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            
            int rows = st.executeUpdate();

            if (rows > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new db.dbException("Erro inesperado nenhuma linha afetada!");
            }

        } catch (SQLException sql) {
            throw new db.dbException(sql.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Departamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Departamento findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departamento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
