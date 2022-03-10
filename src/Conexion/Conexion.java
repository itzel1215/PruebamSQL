
package Conexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Conexion {
    Connection con;
    public Conexion(){
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela","root","almajesus");
    }catch(Exception e ){
        System.err.println("Error:"+e);
    }
    }
    public static void main(String[]args){
        Conexion cn=new Conexion();
        Statement st;
        ResultSet rs;
        try{
            st=(Statement) cn.con.createStatement();
            rs=st.executeQuery("select*from persona");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("nombre")+" "+rs.getString("domicilio"));
        }
            cn.con.close();
            
        }catch (Exception e){
            
        }
        
        
    }
}
