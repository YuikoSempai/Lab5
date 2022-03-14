import java.util.TreeSet;

public class Test {
    public static void main(String[] args){
        TreeSet<String> set = new TreeSet<>();
        set.add("bbb");
        set.add("aaaaa");
        set.add("ab");
        System.out.println("aaaa".hashCode());
        System.out.println("bbbb".hashCode());
        for(String s: set){
            System.out.println(s);
        }
    }
}
