
public class Potato implements Boilable{

    private boolean soft;

    public Potato(){
        this.soft = false;
    }

    @Override
    public void boil(){
        this.soft = true;
    }

    @Override
    public String toString(){
        return this.soft ? "this potato is soft" : "this potato is hard";
    }
}


