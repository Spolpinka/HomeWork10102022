public class Main {
    public static void main(String[] args) {
        String login1 = "jksdadf";
        String pass1 = login1;
        String confirmPass1 = login1;

        String login2 = "23sgf";
        String pass2 = "ldkj__2334";
        String confirmPass2 = pass2;

        String login3 = "QEElkf2453askjhfkjh234523";
        String pass3 = "adlajk23479238j";
        String confirmPass3 = "skdhfkajshldkjhas";

        try {
            checkAuthority(login1, pass1, confirmPass1);

        } catch (WrongLoginEception | WrongPassException exception) {
            System.out.println(exception);
        } catch (Exception e) {
            System.out.println("неизвестная ошибка");
        }

        try {
            checkAuthority(login2, pass2, confirmPass2);
        } catch (WrongLoginEception | WrongPassException exception) {
            System.out.println(exception);
        } catch (Exception e) {
            System.out.println("неизвестная ошибка");
        }

        try {
            checkAuthority(login3, pass3, confirmPass3);
        } catch (WrongLoginEception | WrongPassException exception) {
            System.out.println(exception);
        } catch (Exception e) {
            System.out.println("неизвестная ошибка");
        }

    }

    public static void checkAuthority (String login, String password, String confirmPassword) throws WrongLoginEception, WrongPassException {
        if (checkSimbols(login) &&
                checkSimbols(password) &&
                checkConfirmPass(password, confirmPassword)) {
            System.out.println("с логином " + login + " и паролем все ок");
        } else if (!checkSimbols(login)){
            throw new WrongLoginEception("неверный логин " + login, login);
        } else if (!checkSimbols(password)) {
            throw new WrongPassException("неверный пароль " + password, password);
        } else {
            throw new WrongPassException("несовпадает подтверждение пароля", password);
        }
    }

    public static boolean checkSimbols(String s) {
        boolean check = false;
        System.out.println("проверка строки " + s);
        if (s.matches("[A-z, 0-9, _]+") && s.length() <= 20) {
            return true;
        } else if (s.length() > 20) {
            System.out.println("Длина логина / пароля не должна превышать 20 символов");
        } else {
            System.out.println("Введены недопустимые символы");
        }
        return check;
    }

    public static boolean checkConfirmPass(String pass, String confirmPass) { // отдельный метод, потому что потом здесь может быть более сложная логика (совпадение части символом напр.)
        return pass.equals(confirmPass);
    }
}