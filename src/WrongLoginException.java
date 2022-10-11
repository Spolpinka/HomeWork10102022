public class WrongLoginException extends Exception {
    String login;

    public WrongLoginException() {
    }

    public WrongLoginException(String login) {
        super(login);
        this.login = login;
    }

    public String getMessage(){
        String s = "";
        if (login == null && login.isBlank() && login.isEmpty()){
            s = "Поле login пустое";
        } else if (login.length() > 20) {
            s = "длина login не может быть более 20 символов";
        }

        return s;
    }
}
