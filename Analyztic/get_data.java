import java.util.Scanner;

public class get_data {
    //konstruktor
    get_data(){}

    /*method get_ digunakan untuk mengambil inputan dan mengembalikan inputan tersebut
    ketika akan diintegrasikan dengan GUI silahkan ubah setiap scanner dalam method sesuai dengan kebutuhan nya
    */
    public String get_judul_data(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan judul data : ");
        String j_d = scan.nextLine();
        return j_d;
    }
    public String get_nama_set(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan nama set : ");
        String n_s = scan.nextLine();
        return n_s;
    }
    public String get_value_key(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan nama data : ");
        String v_k = scan.nextLine();
        return v_k;
    }
    public int get_jumlah_set(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan jumlah data set data : ");
        int j_s = scan.nextInt();
        return j_s;
    }
    public int get_jumlah_data(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan jumlah data per set : ");
        int j_d = scan.nextInt();
        return j_d;
    }
    public Double get_value_data(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan value data nya : ");
        Double v_d = scan.nextDouble();
        return v_d;
    }
    //untuk alter
    public String get_nama_set_alt(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan nama set yang mau diganti : ");
        String n_s = scan.nextLine();
        return n_s;
    }
    public String get_value_key_alt(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan nama data yang mau diganti : ");
        String v_k = scan.nextLine();
        return v_k;
    }
    public String get_judul_data_alt(){
        Scanner scan = new Scanner(System.in);
        System.out.print("masukan judul data yang ingin diganti : ");
        String j_d = scan.nextLine();
        return j_d;
    }
        //alter untuk new
        public String get_nama_set_new(){
            Scanner scan = new Scanner(System.in);
            System.out.print("masukan nama set yang baru : ");
            String n_s = scan.nextLine();
            return n_s;
        }
        public String get_value_key_new(){
            Scanner scan = new Scanner(System.in);
            System.out.print("masukan nama data yang baru : ");
            String v_k = scan.nextLine();
            return v_k;
        }
        public Double get_value_data_new(){
            Scanner scan = new Scanner(System.in);
            System.out.print("masukan value data yang baru : ");
            Double v_d = scan.nextDouble();
            return v_d;
        }
        
        public int get_dataset_length(){
            Scanner scan = new Scanner(System.in);
            System.out.print("masukan panjang data : ");
            int d_l = scan.nextInt();
            return d_l;
        }
        public int get_dataset_count(){
            Scanner scan = new Scanner(System.in);
            System.out.print("masukan jumlah data set : ");
            int d_c = scan.nextInt();
            return d_c;
        }

}
