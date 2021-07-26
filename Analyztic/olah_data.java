import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList; 
import java.util.Collections;
public class olah_data {
   data_fetching ambilData;
   
   public Double Rata2(Double sum_value, int sum_data){
       Double totalNilai = sum_value;
       int totalData = sum_data;
       Double Ratarata = totalNilai/totalData;
       return Ratarata;
   }
   
   public ArrayList<Double> getArray(Map<String,Double> data){
       ArrayList<Double> value = new ArrayList<Double>();
      for (String child_key : data.keySet()){
            Double val = data.get(child_key);
            value.add(val);
        }
      return value;
   }
   public Double Modus(Map<String, Map<String,Double>> data1){
       ArrayList<Double> totalValue = new ArrayList<Double>(); 
       for (String child_key : data1.keySet()){
             totalValue.addAll(getArray(data1.get(child_key)));
        }
       Double max = Collections.max(totalValue);
       return max;
   }
   
   public Map<String,Double> Trends( Map<String,Double> value_pair){
       int x = 0; 
       Map<String,Double> trends_set = new HashMap<String,Double>();
       ArrayList<String> setName = new ArrayList<String>();
        for (String child_key : value_pair.keySet()){
            setName.add(child_key);
        }
       for (String child_key : value_pair.keySet()){
             if(x == 0){
                 trends_set.put(child_key, 100.0);
             }
             else{
             Double val = value_pair.get(child_key);
             Double val2 = value_pair.get(setName.get(x+1));
             Double trends_val = (val2/val)*100;
             trends_set.put(child_key, trends_val);
             }
        }
       return trends_set;
   }
}
