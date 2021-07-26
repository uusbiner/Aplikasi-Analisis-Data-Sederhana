import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sql_conn{
//deklarasi
    String user="root";
    String pswd ="";
    String host="localhost";
    String db="Analyztic";
    String url="";
    Connection conn;

//konstruktor
    sql_conn(){}

//method check koneksi
    public void check_connection(){
        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            url="jdbc:mysql://"+ host +"/"+ db +"?user=" + user + "&password="+ pswd; 
            Connection conn=DriverManager.getConnection(url); 
            System.out.println("koneksi sukses"); 
            conn.close(); 
        } catch (SQLException e){ 
            System.out.println("koneksi gagal " + e.toString()); 
        } catch(ClassNotFoundException e) { 
            System.out.println("jdbc.Driver tidak ditemukan"); 
        }
    }

//OPEN KONEKSI
    public Connection open_connection(){
        Connection conn1 = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            url="jdbc:mysql://"+ host +"/"+ db +"?user=" + user + "&password="+ pswd; 
            conn1=DriverManager.getConnection(url);
            System.out.println("koneksi sukses");
        } catch (SQLException e){ 
            System.out.println("koneksi gagal " + e.toString()); 
        } catch(ClassNotFoundException e) { 
            System.out.println("jdbc.Driver tidak ditemukan"); 
        }
        conn = conn1;
        return conn;
    }

//CLOSE KONEKSI
    public void close_connection(){
        if(conn != null){
            try{
                conn.close();
                System.out.println("penutupan koneksi sukses!");
            } catch (SQLException e){ 
                System.out.println("penutupan gagal " + e.toString()); 
            }
        }else if(conn == null){
            System.out.println("tidak ada koneksi yang bisa ditutup");
        }
        
    }

//GET CONN
    public Connection get_conn(){
        return conn;
    }    

}