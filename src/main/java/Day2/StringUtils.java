package Day2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class StringUtils {
    public static String betterString(String s1, String s2, BiPredicate<String,String> func)
    {
        if(func.test(s1,s2))
            return s1;
        else
            return s2;
    }
    public static boolean checkString(String str, Predicate<String> func)
    {

        return func.test(str);
    }
}

