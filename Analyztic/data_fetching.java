
//import library
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class data_fetching {
    //deklarasi
    ResultSet result;
    Map<String, Map<String,Double>> dataList = new HashMap<String, Map<String,Double>>();
    List<String> dataset_list = new ArrayList<String>();
    get_data get_z = new get_data();

    //constructor
    public data_fetching(){}

    //method

    //get_result method untuk mengambil sebuah result_set dari return method class quer_sql, penting diperlukan untuk memulai proses query
    public ResultSet get_result(ResultSet set){
        result = set;
        return result;
    }

    //fetch_nama_set method yang digunakan untuk mengambil data nama_set dari tebl sql dan memasukanya kedalam list dengan tanpa pengulangan value
    public void fetch_nama_set(){
        List<String> ArraySet_temp = new ArrayList<String>();
        try{
            int i = 0;
            while(result.next()){
                String set_temp = result.getString("nama_set");
                ArraySet_temp.add(set_temp);
            }
            for(int z=0; z<ArraySet_temp.size(); z++){
                String Temp_set = ArraySet_temp.get(z);
                if (!dataset_list.contains(Temp_set)) {
      
                    dataset_list.add(Temp_set);
                }

            }

        }catch(SQLException e){
            System.out.println("terjadi kesalahan" + e);
        }
        System.out.println(dataset_list);
    }
    //method pecahan dari method fetch_dataval, abaikan saja
    public Map<String, Double> fetch_result_sets(ResultSet sets){
        Map<String, Double> temp_dict = new HashMap<String, Double>();
        try{
            while(sets.next()){
                temp_dict.put(sets.getString("data_key"), sets.getDouble("data_value"));
            }
        }catch(SQLException e){
            System.out.println("ada yang salah, pesan error : " + e);
        }
        return temp_dict;
    }
    //fetch_dataval, method pertama untuk mendapatkan data dari suatu tabel, dimana method ini akan mengambil result set berdasarkan query sql yang dijalankan
    public void fetch_dataval(Connection conn){
        Connection connect2=conn;
        ResultSet raw_sets2;
        //ambil result

        try{
            Statement st_sel = connect2.createStatement();
            String j_d = get_z.get_judul_data();
            for(int y = 0; y<dataset_list.size();y++){
                String set_name = dataset_list.get(y);
                raw_sets2 = st_sel.executeQuery("select data_key, data_value from "+j_d+" where nama_set = '"+set_name+"';");
                dataList.put(set_name, fetch_result_sets(raw_sets2));

            }
        }catch(SQLException e){
            System.out.println("terjadi masalah saat fetching. error code : " + e.toString());
        }
    }
    //tampil_data, method pecahan dari method tampil_set, abaikan saja
    public void tampil_data(Map<String, Double> dict){
        for (String child_key : dict.keySet()){
            System.out.println("Data: " + child_key + " | Value: " + dict.get(child_key));
        }
    }
    //tampil_set, panggil method ini untuk menampilkan semua data yang terdapat dalam sebuah judul data (tabel data)
    public void tampil_set(){
        for (String parent_key : dataList.keySet()){
            System.out.println("Dataset: " + parent_key);
            Map<String, Double> temp_dic= dataList.get(parent_key);
            tampil_data(temp_dic);

        }
    }

    //get_value, method pecahan dari method get_all_value, abaikan saja
    public Double get_value(Map<String, Double> dictv){
        Double val = 0.0;
        for (String child_key : dictv.keySet()){
            val = val + dictv.get(child_key);
        }
        return val;
    }
    //get_all_value, panggil method ini untuk mendapatkan total value dari semua data yang disimpan dalam sebuah judul data
    public Double get_all_value(){
        Double data_v=0.0;
        for (String parent_key : dataList.keySet()){
            System.out.println("Dataset: " + parent_key);
            Map<String, Double> temp_dic= dataList.get(parent_key);
            data_v=get_value(temp_dic)+data_v;

        }
        return data_v;
    }

    public int getDataSum(){
        int jumlah_data=0;
        for (String parent_key : dataList.keySet()){
            Map<String, Double> temp_dic = dataList.get(parent_key);
            jumlah_data = temp_dic.size() + jumlah_data;
        }
        return jumlah_data;
    }
    
    public Map<String, Map<String,Double>> getDict(){
     return dataList;   
    }
    
    public Map<String,Double> get_dataSetValue(){
        Map<String,Double> value_pair = new HashMap<String,Double>();
        Double data_v = 0.0;
        for (String parent_key : dataList.keySet()){
            Map<String, Double> temp_dic= dataList.get(parent_key);
             data_v=get_value(temp_dic)+data_v;
             value_pair.put(parent_key, data_v);
             data_v = 0.0;
        }
        return value_pair;
    }

}
