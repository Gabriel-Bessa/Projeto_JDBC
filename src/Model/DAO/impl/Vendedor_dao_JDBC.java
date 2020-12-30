package Model.DAO.impl;

import Model.DAO.Vendedor_dao;
import Model.entities.Departamento;
import Model.entities.Vendedor;
import db.DB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Vendedor_dao_JDBC implements Vendedor_dao {

    private Connection con;

    public Vendedor_dao_JDBC(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Vendedor obj) {

    }

    @Override
    public void update(Vendedor obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Vendedor findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(""
                    + "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ?");
            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                Departamento dp = instaciarDepartamento(rs);

                Vendedor vend = instanciarVendedor(rs, dp);

                return vend;
                // Vendedor vend = new Vendedor(id, nome, email, DataNacimento, Double.MAX_VALUE, dp);
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
    public List<Vendedor> findAll() {
        return null;
    }

    private Departamento instaciarDepartamento(ResultSet rs) throws SQLException {
        Departamento dp = new Departamento();
        dp.setId(rs.getInt("DepartmentId"));
        dp.setNome(rs.getString("DepName"));

        return dp;
    }

    private Vendedor instanciarVendedor(ResultSet rs, Departamento dp) throws SQLException {
        Vendedor vend = new Vendedor();

        vend.setDataNacimento(rs.getDate("BirthDate"));
        vend.setDepart(dp);
        vend.setEmail(rs.getString("Email"));
        vend.setId(rs.getInt("Id"));
        vend.setNome(rs.getString("Name"));
        vend.setSalarioBase(rs.getDouble("BaseSalary"));
    
        return vend;
    }

}
