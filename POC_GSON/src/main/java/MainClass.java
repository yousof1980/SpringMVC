import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: htalsadi
 * Date: 10/6/13
 * Time: 7:59 PM
 * To change this template use File | Settings | File Templates.
 */

public class MainClass {

    public static void main(String []args){
        Gson gson = new GsonBuilder()
                //.registerTypeAdapter(Id.class, new IdTypeAdapter())
                .registerTypeAdapter(Base.class, new HierarchyAdapter())
                .enableComplexMapKeySerialization()
                .serializeNulls()
                //.setDateFormat(SimpleDateFormat.LONG)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();;

        //Example 1
        MatlabFunctionData mfdBefore1  = new MatlabFunctionData();
        Sub1 b1 = new Sub1();
        b1.setX(3);
        mfdBefore1.setBase(b1);
        String s1 = gson.toJson(mfdBefore1);
        System.out.println(s1);

        MatlabFunctionData mfdAfter1  = gson.fromJson(s1, MatlabFunctionData.class);
        System.out.println(mfdAfter1.getBase().getClass().getCanonicalName());

        //Example 2
        MatlabFunctionData mfdBefore2 = new MatlabFunctionData();
        String s2 = gson.toJson(mfdBefore2);
        System.out.println("----------------------------------");
        System.out.println(s2);
        MatlabFunctionData mfdAfter2= gson.fromJson(s2, MatlabFunctionData.class);
        System.out.println(mfdAfter2.getBase());

    }
}
