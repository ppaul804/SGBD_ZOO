
package model.dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Comanda;
import model.bean.JoinValorTotal;
import model.bean.Visitante;

public class ComandaDAO {
    
    public void abre(Comanda comanda) {
        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO comanda (Cpf_Visitante) VALUES (?) ");
            stmt.setDouble(1, comanda.getCpf_visitante());            
            
            stmt.executeUpdate();                        
            
            JOptionPane.showMessageDialog(null, "Comanda aberta!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir: "+ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }
    
    public void fecha(Comanda comanda) { //PARA FECHAR O VALOR_COMANDA TEM QUE SER DEFINIDO
        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE comanda SET Valor_Comanda = (SELECT SUM(Valor_ItemServico * Quantidade_ItemServico) FROM comanda_itemservico WHERE Codigo_Comanda = ?) WHERE Codigo_Comanda = ?");
            stmt.setDouble(1, comanda.getCodigoComanda());            
            stmt.setDouble(2, comanda.getCodigoComanda());            
            
            stmt.executeUpdate();                        
            
            JOptionPane.showMessageDialog(null, "Comanda fechada!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir: "+ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt);
        }
        
    }
    
    public List<Comanda> ler(){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Comanda> comandas = new ArrayList<>();        
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM comanda WHERE Valor_Comanda is null");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Comanda comanda = new Comanda();
                
                comanda.setCodigoComanda(rs.getInt("Codigo_Comanda"));
                comanda.setCpf_visitante(rs.getDouble("Cpf_Visitante"));
                comanda.setDataEntrada(rs.getString("DataEntrada_Comanda"));
                comanda.setValor(rs.getDouble("Valor_Comanda"));                
                
                comandas.add(comanda);
                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return comandas;
        
    }
    
    public List<JoinValorTotal> lerJoin(){        
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<JoinValorTotal> listaJoin = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM valortotal");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                JoinValorTotal join = new JoinValorTotal();
                
                join.setNome(rs.getString("Nome do Visitante"));
                join.setValor(rs.getDouble("Valor Total"));
                
                listaJoin.add(join);
                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return listaJoin;
    }
    
    public List<Visitante> lerPorNome(String nomeVistante){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Visitante> visitantes = new ArrayList<>();        
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM visitante WHERE Nome_Visitante LIKE ?");
            stmt.setString(1, "%"+nomeVistante+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Visitante item = new Visitante();
                
                item.setCpf(rs.getDouble("Cpf_Visitante"));
                item.setNome(rs.getString("Nome_Visitante"));
                item.setTelefone(rs.getDouble("Telefone_Visitante"));
                
                visitantes.add(item);
                                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " +ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return visitantes;
        
    }
    
    public String verificaCPF(double cpfVistante){
        Connection conexao = ConexaoMySQL.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String nomeVisitante = null;
        
        try {
            stmt = conexao.prepareStatement("SELECT Cpf_Visitante, Nome_Visitante FROM visitante WHERE Cpf_Visitante = ?");
            
            stmt.setDouble(1, cpfVistante);            
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                nomeVisitante = rs.getString("Nome_Visitante");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoMySQL.desconectar(conexao, stmt, rs);
        }
        
        return nomeVisitante;
        
    }
    
    
}
