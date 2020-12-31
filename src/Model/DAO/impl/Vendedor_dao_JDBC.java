package Model.DAO.impl;

import Model.DAO.Vendedor_dao;
import Model.entities.Departamento;
import Model.entities.Vendedor;
import db.DB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vendedor_dao_JDBC implements Vendedor_dao {
    
    private Connection con;
    
    public Vendedor_dao_JDBC(Connection con) {
        this.con = con;
    }
    
    @Override
    public void insert(Vendedor obj) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getDataNacimento().getTime()));
            st.setDouble(4, obj.getSalarioBase());
            st.setInt(5, obj.getDepart().getId());
<<<<<<< HEAD

            int rows = st.executeUpdate();

            if (rows > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
=======
            
            int rows  = st.executeUpdate();
            
            if(rows > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
>>>>>>> 167ad38f54f40d06039ccd2644abdd1bac0662be
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
<<<<<<< HEAD
            } else {
                throw new db.dbException("Erro inesperado nenhuma linha afetada!");
            }

        } catch (SQLException sql) {
            throw new db.dbException(sql.getMessage());
        } finally {
=======
            }else {
                throw new db.dbException("Erro inesperado nenhuma linha afetada!");
            }
            
        } catch (SQLException sql) {
            throw new db.dbException(sql.getMessage());
        }finally {
>>>>>>> 167ad38f54f40d06039ccd2644abdd1bac0662be
            DB.closeStatement(st);
        }
    }
    
    @Override
    public void update(Vendedor obj) {
<<<<<<< HEAD
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("UPDATE seller "
                    + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                    + "WHERE Id = ?", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getDataNacimento().getTime()));
            st.setDouble(4, obj.getSalarioBase());
            st.setInt(5, obj.getDepart().getId());
            st.setInt(6, obj.getId());

            st.executeUpdate();

        } catch (SQLException sql) {
            throw new db.dbException(sql.getMessage());
        } finally {
            DB.closeStatement(st);
        }
=======
        
>>>>>>> 167ad38f54f40d06039ccd2644abdd1bac0662be
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
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(""
                    + "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "ORDER BY Name");
            
            rs = st.executeQuery();
            List<Vendedor> list = new ArrayList<>();
            Map<Integer, Departamento> map = new HashMap<>();
            
            while (rs.next()) {
                
                Departamento dep = map.get(rs.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instaciarDepartamento(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                
                Vendedor vend = instanciarVendedor(rs, dep);
                list.add(vend);
            }
            return list;
        } catch (SQLException e) {
            throw new db.dbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
    
    @Override
    public List<Vendedor> findByDepartamento(Departamento departamento) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(""
                    + "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE DepartmentId = ? "
                    + "ORDER BY Name");
            st.setInt(1, departamento.getId());
            
            rs = st.executeQuery();
            List<Vendedor> list = new ArrayList<>();
            Map<Integer, Departamento> map = new HashMap<>();
            
            while (rs.next()) {
                
                Departamento dep = map.get(rs.getInt("DepartmentId"));
                if (dep == null) {
                    dep = instaciarDepartamento(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                
                Vendedor vend = instanciarVendedor(rs, dep);
                list.add(vend);
            }
            return list;
        } catch (SQLException e) {
            throw new db.dbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
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
