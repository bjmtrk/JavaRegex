package peppe.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by peppe on 12/03/15.
 */
public class Main {
    public static void main(String[] args) {
        String str ="ciao:8;bao:k;helloWorld;kk:78:{a:9;b:0;};zz:78:{a:2;b;1};";


        String checkRepeated = "(.*?);(\\w*?:[0-9]*:\\{.*?\\};)";

        String repeated = "\\w*?:[0-9]*?:\\{.*?\\}";


        if(Pattern.matches(checkRepeated,str)) {
            System.out.println("the string contains a repeated section");
            Pattern p = Pattern.compile(repeated);
            Matcher m = p.matcher(str);

            String base = p.split(str)[0];
            List<String> list = new ArrayList<String>();

            while (m.find()) {
                list.add(m.group());
            }

            String r = list.get(0);

            if(Pattern.matches(repeated,r)) {
                System.out.println("the string IS a subgroup " + r) ;

                String r_pattern = "\\{.*?\\}";
                Pattern r_p = Pattern.compile(r_pattern);
                Matcher r_m = r_p.matcher(r);
                System.out.println(r_p.split(r)[0]);
                r_m.find();
                System.out.println(r_m.group().replaceAll("\\{|\\}",""));
            }

        }

    }
}
