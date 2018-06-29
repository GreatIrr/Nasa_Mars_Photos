package commons;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
    public String value();
}

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class TestSomeFeatures {

    // public static void main(String[] args) {
    // double sol = 24 * 60 * 60 + 35.244;
    // System.out.println("sol = " + sol);
    // int sol1000 = (int) (sol * 1000);
    // String dateString = "2012-8-6";
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
    // Date date = sdf.parse(dateString);
    // System.out.println("1000 sol seconds = " + sol1000);
    // date = DateUtils.addSeconds(date, sol1000);
    // System.out.println("date = " + sdf.format(date));

    // String a = null;
    // System.out.println("a = " + a.toString());

    // System.out.println(format("sol=%s&", "1000"));
    //
    // Random random = new Random(-6732303926L);
    // for (int i = 0; i < 5; i++) {
    // int randNumber = random.nextInt(5);
    // System.out.println(randNumber);
    // }
    // System.out.println("---------");
    // System.out.println(random.nextInt(10));
    // System.out.println(random.nextInt(10));
    // System.out.println(random.nextInt(10));

    public static void main(String[] args) {
        Method[] methods = SampleClass.class.getMethods();
        Annotation[][] annotations = methods[1].getParameterAnnotations();
        for (Annotation[] annotation1 : annotations) {
            for (Annotation annotation : annotation1) {
                if (annotation instanceof CustomAnnotation) {
                    CustomAnnotation customAnnotation = (CustomAnnotation) annotation;
                    System.out.println("value: " + customAnnotation.value());
                }
            }
        }
    }
}

@CustomAnnotation(value = "Sample Class Annotation")
class SampleClass {
    private String sampleField;

    public String getSampleField() {
        return sampleField;
    }

    public void setSampleField(@CustomAnnotation("Test") String sampleField) {
        this.sampleField = sampleField;
    }

    public void test(String key) {
        setSampleField(key);
    }
}

class Order {
    public static String order(String words) {
        if (words == "") {
            return words;
        }

        StringBuilder result = new StringBuilder();
        String[] wordsSpl = words.split(" ");

        String[] listWords = new String[wordsSpl.length];

        for (int i = 0; i < wordsSpl.length; i++) {
            String strNumber = wordsSpl[i].replaceAll("\\D+", "");
            String strWord = wordsSpl[i].replaceAll("[0-9]", "");
            int key = Integer.parseInt(strNumber);
            listWords[key - 1] = strWord;
        }

        return String.join(" ", listWords);

    }

    public static int duplicateCount(String text) {

        String[] words = text.split(" ");

        int result = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < words[result].length()) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(23L%13);
        Sharik sharik = new Sharik();
        sharik.setLitr(5);
    }
}

class Sharik {

    private int litr;

    public void setLitr(int litr) {
        sayHurray();
        this.litr = litr;
    }

    private void sayHurray() {
        System.out.println("hurrrrrrrrrrray");
    }

}
