public class WrongLoginEception extends Exception {

    private String login;

    public WrongLoginEception(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
