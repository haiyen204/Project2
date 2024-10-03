package accout;

import java.util.regex.Pattern;

public class Validator {

    // Kiểm tra định dạng email hợp lệ
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Kiểm tra định dạng số điện thoại hợp lệ (10-11 chữ số)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\d{10,11}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }
}
