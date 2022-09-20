package ch1;

public class FlyingWithBird implements Fly {
     static String ms="hello workd are you in this";

    @Override
    public void print(String msg) {
        System.out.println("data saved "+msg);
    }

    /**
     * @param msg
     * return show as s msg in dialouge
     */
    @Override
    public void show(String msg) {
        System.out.println("print +"+msg);

    }

    public static void main(String[] args) {
        FlyingWithBird f=new FlyingWithBird();
        f.print("hello");
        f.show(ms);
    }
}
