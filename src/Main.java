public class Main {
    public static void main(String[] args) {
        String login1 = "ADJflkadj";
        String login2 = "kADJFjdhfkjas_287459823";
        String loginWrong = "флволрaldlaj---ЙУКЙЦ";

        String pass1 = login1;
        String confirmPass1 = login1;

        String pass2 = login2;
        String confirmPass2 = "jskadhfkAJSAJDF193879182_";

        String pass3 = "ФЫВОАЫФАдфылвоадakjdhfkas";
        String confirmPass3 = pass3;

        task1(login1, pass1, confirmPass1);
        System.out.println("первый пошел");
        task1(login2, pass2, confirmPass2);
        System.out.println("второй пошел");
        task1(loginWrong, pass3, confirmPass3);
        System.out.println("третий пошел");
    }

    public static void task1(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPass(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkLogin(String login) throws WrongLoginException {
        if (login.matches("[a-z]") ||
                login.matches("[A-Z]") ||
                login.matches("[0-9]") ||
                login.matches("_")){
            System.out.println("Логин корректный");
        } else {
            throw new WrongLoginException(login);
        }
    }

    public static void checkPass(String pass, String confirmPass) throws WrongPasswordException {
        if (pass.matches("[a-z]") ||
                pass.matches("[A-Z]") ||
                pass.matches("[0-9]") ||
                pass.matches("_")){
            System.out.println("Логин корректный");
        } else {
            throw new WrongPasswordException(pass);
        }
    }
}