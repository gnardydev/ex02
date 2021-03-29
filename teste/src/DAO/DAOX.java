package DAO;

import model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOX {
	private Connection conexao;

    public DAOX(){
        conexao = null;
    }

    public boolean conectar(){
        try{
            Class.forName(CredenciasDB.driverName);
            conexao = DriverManager.getConnection(CredenciasDB.url, CredenciasDB.username, CredenciasDB.password);
            status = (conexao == null);
        }catch(ClassNotFoundException e){
            System.out.println("Deu ruim!");
        }catch(SQLException e){
            System.out.println("Deu ruim!");
        }

        return status;
    }

    public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}

    public X[] Listar(){
        X[] Xqnt = null;

        try{
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM X;");
            if(rs.next()){
                rs.last();
                Xqnt = new X[rs.getRow()];
                rs.beforeFirst();

                for(int i = 0; rs.next(); i++) {
                    Xqnt[i] = new Aluno(rs.getString("nome"), rs.getInt("id"));
                }
             }
             st.close();
        } catch (Exception e) {
			System.err.println(e.getMessage());
		}
        return Xqnt;
    }

    public boolean inserir(X x){
        boolean status = false;
        try{
            Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO X (nome, id) "
					       + "VALUES ("+x.getNome()+", '"+fb.getId()+");");
			st.close();
			status = true;
        }catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
    }

    public boolean excluir(int id){
        boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM X WHERE id = "+id+";");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
    }

    public boolean atualizar(int id, String nome){
        boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("ALTER TABLE X WHERE id = "+id+" RENAME nome TO "+nome+";");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
    }
}
