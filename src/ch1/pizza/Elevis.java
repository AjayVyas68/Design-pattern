package ch1.pizza;

public class Elevis {
    public static final Elevis INSTANCE= new Elevis();
    private Elevis(){

    }

    public void leaveTheBuilding(){
        System.out.println("get lost");
    }

    public static void main(String[] args) {
        new Elevis().leaveTheBuilding();
        Elevis.INSTANCE.leaveTheBuilding();
    }
}
