package jo.exception;

public class AlreadyInException extends Exception{

    public AlreadyInException(String texte){
        super();
        System.out.println(texte);
    }

    public AlreadyInException(){
        super();
    }
    
}
