
public class test {
    public static void main(String[] args){
        sql_conn koneksi = new sql_conn(); // object koneksi berisi class sql_conn yang memiliki utilitas koneksi, lihat class sql_conn untuk mengetahui method nya
        koneksi.open_connection();
        query_sql query = new query_sql(koneksi.get_conn());
        data_fetching fetch_data= new data_fetching();
        olah_data olah = new olah_data();
        query.get_table_name();
        /*hilangkan tag komentar untuk menggunakan fitur upload dan alter
        query.upload_data();
        query.alter_set();
        */
        //fetch_data.get_result(query.get_sets());
        //fetch_data.fetch_nama_set();
        //fetch_data.fetch_dataval(koneksi.get_conn());
        //fetch_data.tampil_set();
        //System.out.println(fetch_data.get_all_value());
        //System.out.println("mean : " + olah.Rata2(fetch_data.get_all_value(), fetch_data.getDataSum()));
        //System.out.println("modus : " + olah.Modus(fetch_data.getDict()));
        olah.Trends(fetch_data.get_dataSetValue());

        koneksi.close_connection();

    }
}