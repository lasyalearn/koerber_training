package q4;

public class NotSufficientBookException extends RuntimeException
{
    //this a type of error u shouldn't be able to recover from
    // but if ur able to handle it then u can inherit from Exception class
    //else u can inherit from RuntimeException
    public NotSufficientBookException(String message)
    {
        super(message);
    }
}
