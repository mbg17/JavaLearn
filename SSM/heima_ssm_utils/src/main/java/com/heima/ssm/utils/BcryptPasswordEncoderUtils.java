package com.heima.ssm.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 陆远
 */
public class BcryptPasswordEncoderUtils {
    public static String returnBCryptPasswordEncoder(String password){
        return new BCryptPasswordEncoder().encode(password);
    }

    public static void main(String[] args) {
        String s = returnBCryptPasswordEncoder("123456");
        System.out.println(s);
    }
}
