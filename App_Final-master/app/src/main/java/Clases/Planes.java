package Clases;

public class Planes {
    //atributos
    private int Norte;
    private int Sur;
    private int Cordillera;
    private int Costa;
    //constructor
    public Planes(){
        Norte=35000;
        Sur=45000;
        Cordillera=20000;
        Costa=20000;
    }
    //accesadores
    public int getNorte(){
        return Norte;
    }
    public int getSur(){
        return Sur;
    }
    public int getCordillera(){
        return Cordillera;
    }
    public int getCosta(){
        return Costa;
    }


}
