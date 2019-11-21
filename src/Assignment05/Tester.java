package Assignment05;

public class Tester {
    public static void main(String[] args) {
        MyString s1 = new MyString("ABCACAVCDE");
        System.out.println(s1.length());
        System.out.println(s1.charAt(2));
        System.out.println(s1.charAt(10));
        System.out.println(s1.startsWith(new MyString("ABC")));
        System.out.println(s1.startsWith(new MyString("ACC")));
        System.out.println(s1.endsWith(new MyString("CDE")));
        System.out.println(s1.endsWith(new MyString("CEE")));
        System.out.println(s1.replaceAll('A', 'X'));
        System.out.println(s1);
        System.out.println(s1.toLowerCase());
        MyString s2 = new MyString("Abcdefghij");
        System.out.println(s2.toUpperCase());
        MyString s3 = new MyString("ABCACAVCDE");
        //System.out.println(s1.equals(s2));
        //System.out.println(s1.equals(s3));

        MyString s4 = new MyString("Ballappleball");
        MyString s5 = new MyString("appleballball");
        MyString s6 = new MyString("Bappleball");
        MyString s7 = new MyString("Ballapplel");
        MyString s8 = new MyString("apple");
        MyString s9 = new MyString("Aapple");
//		 System.out.println(s4.contains("aple".toCharArray()));
//		 System.out.println(s5.contains("apple".toCharArray()));
//		 System.out.println(s8.contains("apple".toCharArray()));
//		 System.out.println(s9.contains("apple".toCharArray()));

        MyString s10 = new MyString("    This is  fascinating!       ");
        System.out.println(s10.trim());
        System.out.println(s10);

        MyString s11 = new MyString("ApPle");
        MyString s12 = new MyString("appLe");
        System.out.println(s11.equalsIgnoreCase(s12));

        MyString s13 = new MyString("abc");
        MyString s14 = new MyString("bcd");
        MyString s15 = new MyString("Abc");

        System.out.println(s13.compareTo(s15));
        System.out.println(s13.compareToIgnoreCase(s15));
        System.out.println(s14.compareTo(s13));

        System.out.println(s9.substring(2));

        MyString s16 = new MyString("abdcefghijk");
        System.out.println(s16.substring(2, 5));

        System.out.println(s8.indexOf('p'));
        System.out.println(s8.lastIndexOf('p'));

        MyString s17 = new MyString("Thisisjustarandomtext");
        System.out.println(s17.indexOf('i', 3));
        System.out.println(s17.lastIndexOf('t', 5));

        System.out.println(s16.concat(s17));

        MyString s18 = new MyString();
        System.out.println(s18.isEmpty());
        MyString s19 = new MyString("");
        System.out.println(s19.isEmpty());

        MyString s20 = new MyString("aPPle");
        MyString s21 = new MyString("apple");
        System.out.println(s20.equals(s21));
        System.out.println(s20.equalsIgnoreCase(s21));
    }
}