package br.com.java.database.interaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pessoa extends AbstractPessoa {
    
    public Pessoa(){}

    public Pessoa(String nome, int idade, String sexo) {
        super(nome, idade, sexo);
    }

    @Override
    public void insert() {
        String sql = "insert into pessoa(nome, idade, sexo) VALUES(?, ?, ?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try {
            pst = ConnectionFactory.con.prepareStatement(sql);
            
            pst.setString(1, this.nome);
            pst.setInt(2, this.idade);
            pst.setString(3, this.sexo);
            pst.executeUpdate();
            
            pst.close();
            con.close();
        } catch (SQLException ex) {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void select(int id) {
        String sql = "select id, nome, idade, sexo from pessoa where id = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try {
            pst = ConnectionFactory.con.prepareStatement(sql);
            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                this.id = rs.getInt("id");
                this.nome = rs.getString("nome");
                this.idade = rs.getInt("idade");
                this.sexo = rs.getString("sexo");
            }
            
            pst.close();
            con.close();
        } catch (SQLException ex) {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void update(int id) {
        String sql = "update pessoa set nome=?, idade=?, sexo=? where id=?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try {
            pst = ConnectionFactory.con.prepareStatement(sql);
            
            pst.setString(1, this.nome);
            pst.setInt(2, this.idade);
            pst.setString(3, this.sexo);
            pst.setInt(4, id);
            pst.executeUpdate();
            
            pst.close();
            con.close();
        } catch (SQLException ex) {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from pessoa where id=?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        
        try {
            pst = ConnectionFactory.con.prepareStatement(sql);
            
            pst.setInt(1, id);
            pst.executeUpdate();
            
            pst.close();
            con.close();
        } catch (SQLException ex) {
            try {
                pst.close();
                con.close();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
    }    
}
