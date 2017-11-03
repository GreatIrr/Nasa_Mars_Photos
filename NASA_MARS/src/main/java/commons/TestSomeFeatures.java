package commons;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class TestSomeFeatures {

    public static void main(String[] args) throws ParseException {
//        double sol = 24 * 60 * 60 +  35.244;
//        System.out.println("sol = " + sol);
//        int sol1000 = (int) (sol * 1000);
//        String dateString = "2012-8-6";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
//        Date date = sdf.parse(dateString);
//        System.out.println("1000 sol seconds = " + sol1000);
//        date = DateUtils.addSeconds(date, sol1000);
//        System.out.println("date = " + sdf.format(date));


//        String a = null;
//        System.out.println("a = " + a.toString());

        System.out.println(format("sol=%s&", "1000"));

    }
}
