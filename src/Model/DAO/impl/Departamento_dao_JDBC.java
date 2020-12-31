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
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("UPDATE department "
                    + "SET Name = ? "
                    + "WHERE Id = ?", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setInt(2, obj.getId());

            int rows = st.executeUpdate();
            if (rows > 0) {
                System.out.println("Atualizado " + rows + " com sucesso!");
            }else {
                throw new db.dbException("Nenhuma Linha Atualizada!");
            }

        } catch (SQLException sql) {
            throw new db.dbException(sql.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("DELETE FROM department "
                    + "WHERE Id = ?");
            
            st.setInt(1, id);            
            st.executeUpdate();
            
        } catch (SQLException sql) {
            throw new db.dbException(sql.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Departamento findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement("SELECT * FROM department "
                    + "WHERE id = ?");
            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                Departamento dp = instaciarDepartamento(rs);

                return dp;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new db.dbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Departamento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Departamento instaciarDepartamento(ResultSet rs) throws SQLException {
        Departamento dp = new Departamento();
        dp.setId(rs.getInt("Id"));
        dp.setNome(rs.getString("Name"));

        return dp;
    }

}
