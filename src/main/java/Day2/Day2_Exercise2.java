package Day2;

public class Day2_Exercise2 {
    public static void main(String args[]){
        String str1="osama";
        String str2="os*2";
        String longer=StringUtils.betterString(str1,str2,(s1,s2)->s1.length() > s2.length());
        System.out.println(longer);
        String first=StringUtils.betterString(str2,str1,(s1,s2)->true);
        System.out.println(first);

        boolean alphabet=StringUtils.checkString(str2,
                (str)->{
                    boolean letter=true;
                    for(int i=0;i<str.length();i++)
                    {
                        letter= Character.isLetter(str.charAt(i));
                        if(!letter)break;

                    }
                    return letter;
                });
        System.out.println(alphabet);
    }
}

