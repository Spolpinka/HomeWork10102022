public class WrongPasswordException extends Exception {
    String pass;

    public WrongPasswordException() {
    }

    public WrongPasswordException(String pass) {
        super(pass);
        this.pass = pass;
    }
}
