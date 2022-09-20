package ch1;

public class FlyingWithBird implements Fly {

    @Override
    public void print(String msg) {
        System.out.println("data saved "+msg);
    }

    public static void main(String[] args) {
        FlyingWithBird f=new FlyingWithBird();
        f.print("hello");
    }
}
