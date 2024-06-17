package jo.exception;

public class InvalidTypeException extends Exception{

    public InvalidTypeException(String texte){
        super();
        System.out.println(texte);
    }

    public InvalidTypeException(){
        super();
    }
}