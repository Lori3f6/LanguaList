package moe.langua.lab;

public class MainTest {
    public static void main(String[] args) {
        Langualist<Integer> ll = new Langualist<Integer>();
        ll.add(0);
        for(int i = 0;i<100;i++){
            ll.add(0,i);
        }
        for(int ii=0;ii<100;ii++){
            System.out.print(ll.get(ii)+",");
        }

    }
}
