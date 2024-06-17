package jo.exception;

public class NothingInException extends Exception{

    public NothingInException(String texte){
        super();
        System.out.println(texte);
    }

    public NothingInException(){
        super();
    }
    
}
