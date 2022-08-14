package com.hiper2d.challenge;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("anna"));
        System.out.println(p.isPalindrome("anna1"));
    }

    public boolean isPalindrome(String originalString) {
        String reversedString = (new StringBuilder(originalString)).reverse().toString();
        return originalString.equals(reversedString);
    }
}
