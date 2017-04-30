
public class Egg implements Boilable{

    private String state;

    public Egg(){
        this.state = "raw";
    }

    @Override
    public void boil(){
        this.state = "hard boiled";
    }

    @Override
    public String toString(){
        return "this egg is " + this.state;
    }
}

