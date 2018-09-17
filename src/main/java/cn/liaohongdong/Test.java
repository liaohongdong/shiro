package cn.liaohongdong;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import java.util.Base64;

public class Test {
    public static void main(String[] args) {
        String s = Base64.getEncoder().encodeToString("liaohongdong".getBytes());
        System.out.println(s);
        byte[] decode = Base64.getDecoder().decode(s);
        System.out.println(new String(decode));

        String s1 = Base64.getMimeEncoder().encodeToString("liaohongdong".getBytes());
        System.out.println(s1);
        byte[] decode1 = Base64.getMimeDecoder().decode(s1);
        System.out.println(new String(decode1));

        SecureRandomNumberGenerator sr = new SecureRandomNumberGenerator();
        sr.setSeed("123".getBytes());
        String s2 = sr.nextBytes().toHex();
        System.out.println(s2);

    }

}
