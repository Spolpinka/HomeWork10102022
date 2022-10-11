public class WrongPassException extends Exception {
    private String pass;

    public WrongPassException(String message, String pass) {
        super(message);
        this.pass = pass;
    }
}
