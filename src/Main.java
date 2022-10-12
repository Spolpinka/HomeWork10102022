public class Main {

    private static String error = "";
    public static void main(String[] args) {
        String login1 = "jksd_adf";
        String pass1 = login1;
        String confirmPass1 = login1;

        String login2 = "23sgыf";
        String pass2 = "ldkj__2334";
        String confirmPass2 = pass2;

        String login3 = "QEE523";
        String pass3 = "adlajk23479238j";
        String confirmPass3 = "skdhfkajshldkjhas";

        try {
            checkAuthority(login1, pass1, confirmPass1);

        } catch (WrongLoginEception | WrongPassException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("неизвестная ошибка");
        }

        try {
            checkAuthority(login2, pass2, confirmPass2);
        } catch (WrongLoginEception | WrongPassException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("неизвестная ошибка");
        }

        try {
            checkAuthority(login3, pass3, confirmPass3);
        } catch (WrongLoginEception | WrongPassException e) {
            System.out.println(e);
            e.printStackTrace();
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
            throw new WrongLoginEception(error, login);
        } else if (!checkSimbols(password)) {
            throw new WrongPassException(error, password);
        } else {
            throw new WrongPassException("несовпадает подтверждение пароля " + password, password);
        }
    }

    public static boolean checkSimbols(String s) {
        boolean check = false;
        //System.out.println("проверка строки " + s);
        if (s.matches("[A-z0-9_]+") && s.length() <= 20) {
            return true;
        } else if (s.length() > 20) {
            error = "Длина логина / пароля не должна превышать 20 символов";
        } else {
            error = "Введены недопустимые символы";
        }
        return check;
    }

    public static boolean checkConfirmPass(String pass, String confirmPass) { // отдельный метод, потому что потом здесь может быть более сложная логика (совпадение части символом напр.)
        return pass.equals(confirmPass);
    }
}