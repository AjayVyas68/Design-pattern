package ch1;

public class NoFlyingWithBird implements Fly{

    @Override
    public void print(String msg) {
        System.out.println("No Flying With Bird "+msg);
    }

    /**
     * @param msg
     */
    @Override
    public void show(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        NoFlyingWithBird n=new NoFlyingWithBird();
        n.print("Name peacock");
    }
}
