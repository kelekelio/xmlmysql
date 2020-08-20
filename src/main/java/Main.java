import java.util.*;

public class Main {
    public static void main(String[] args) {


        LinkedHashMap<String, String> numbers = new LinkedHashMap<String, String>();



        TreeMap<String,String> map=new TreeMap<String,String>();
        numbers.put("id", "\"133345\"");
        numbers.put("id2", "133345");
        numbers.put("name", "dev_name");
        numbers.put("desc", "description");
        numbers.put("desc1", "description1");
        numbers.put("desc2", "description2");

        Set keys = numbers.keySet();
        System.out.println(keys);

        Collection<String> valuess = numbers.values();


        Collection<String> values = numbers.values();
        System.out.println(values);

    }
}
