public class  ValidationService {
    private static final String  ALLOWED_CHARACTERS = "1234567890_qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";

    public static boolean checkError(String login, String password, String confirmPassword) {
        try {
            checkLong(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    private static void  checkLong(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равно 20");
        } if (password == null || password.length() > 20){
            throw new WrongPasswordException("Длина логина должна быть меньше 20");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Длина логина и пароля должна совпадать");
        }
        checkSymbol(login, true);
        checkSymbol(password, true);
    }
    private static void checkSymbol(String s,boolean login) throws WrongLoginException, WrongPasswordException{
        for (int i = 0; i < s.length(); i++) {
            if (! ALLOWED_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                if (login) {
                    throw new WrongLoginException("В логине содержиться некорректный символ: "+ s.charAt(i));
                } else {
                    throw new WrongPasswordException("В пароле содержиться некорректный символ: "+ s.charAt(i));
                }
            }
        }
    }

}
