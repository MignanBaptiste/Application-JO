package jo.exception;

public class InvalidSexeException extends Exception{
    public InvalidSexeException(String texte){
        super();
        System.out.println(texte);
    }

    public InvalidSexeException(){
        super();
    }
    
}
