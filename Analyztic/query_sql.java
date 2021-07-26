import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class query_sql {
    //deklarasi
    int jumlah_set_data; int jumlah_data_perset;
    String judul_data = " "; String nama_set_data = " "; String data_key = " ";
    Double data_value = 0.;
    get_data get_m = new get_data();
    String query_sql;
    Connection connect1;

    //konstruktor
    query_sql(Connection con){
        connect1 = con;
    }

    //method
    public void insert_data(int j, String set){
        int x = 0;
        while(x < j){
            data_key = get_m.get_value_key();
            data_value = get_m.get_value_data();
            try{
                Statement stmt_ins = connect1.createStatement();
                String query_sql_ins = "INSERT INTO "+ judul_data + "(nama_set, data_key, data_value)"+"VALUES ('"+nama_set_data+"','"+data_key+"','"+data_value+"')";
                stmt_ins.executeUpdate(query_sql_ins);
                System.out.println("insert succes");
            }catch(SQLException e){
                System.out.println("tejadi kesalahan" + e.toString());
            }

            x++;
        }
    }
    public void upload_data(){
        //method untuk memasukan data dan mengirim nya ke database
        if(connect1 != null){
            judul_data = get_m.get_judul_data();
            jumlah_set_data = get_m.get_dataset_count();
            jumlah_data_perset = get_m.get_dataset_length();
            try{
                Statement stmt = connect1.createStatement();
                query_sql = "CREATE TABLE " + judul_data + 
                            "(id int not null auto_increment, " + 
                            " nama_set VARCHAR(255), " + 
                            " data_key VARCHAR(255), " + 
                            " data_value float(25), " + 
                            " primary key ( id ))";
                stmt.execute(query_sql);
                System.out.println("create table succes");
                int i = 0;
                while(i < jumlah_set_data){
                    nama_set_data = get_m.get_nama_set();
                        insert_data(jumlah_data_perset, nama_set_data);
                    i++;
                }
            }catch(SQLException e){
                System.out.println("terjadi kesalahan" + e.toString());
            }
        }
        else if(connect1 == null){
            System.out.println("koneksi belum terjadi");
        }
    }

    public ResultSet get_sets(){
        //method untuk mengambil sets dari tabel yang dipilih
        ResultSet raw_sets = null;
        try{
            Statement st_sel = connect1.createStatement();
            String j_d = get_m.get_judul_data();
            raw_sets = st_sel.executeQuery("SELECT * FROM "+ j_d);
        }catch(SQLException e){
            System.out.println("terjadi masalah saat fetching. error code : " + e.toString());
        }
        return raw_sets;
    }

    public void alter_set(){
        try{
            String j_da = get_m.get_judul_data_alt();
            String c_nama_set = get_m.get_nama_set_alt();
            String c_data_key = get_m.get_value_key_alt();

            String n_nama_set = get_m.get_nama_set_new();
            String n_data_key = get_m.get_value_key_new();
            Double n_data_val = get_m.get_value_data_new();

            String query_alt = "UPDATE "+ j_da +  " SET nama_set = '"+ n_nama_set +"',data_key = '"+n_data_key+"', data_value = "+ n_data_val + " WHERE nama_set = '"+ c_nama_set +"' AND data_key = '"+ c_data_key +"';";

            Statement st_alt = connect1.createStatement();
            st_alt.executeUpdate(query_alt);

        }catch(SQLException e){
            System.out.println("ada kendala pada saat alter table. error code : " + e.toString());
        }
    }
    public ArrayList<String> get_table_name(){
        String[] types = {"TABLE"};
        ArrayList<String> table_list = new ArrayList<String>();
        try {
            DatabaseMetaData metaData = connect1.getMetaData();
            //Retrieving the columns in the database
            ResultSet tables = metaData.getTables(null, null, "%", types);
            while (tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
                table_list.add(tables.getString("TABLE_NAME"));
            }
        } catch (Exception e) {
            System.out.println("terjadi kesalahan" + e);
        }
        
        return table_list;
    }
}
