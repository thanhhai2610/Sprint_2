package vn.thanhhai;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));
    }
}
