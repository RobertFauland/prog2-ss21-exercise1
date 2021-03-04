package fh.ac.at;
//https://github.com/RobertFauland/prog2-ss21-exercise1.git

import java.util.regex.Pattern;

public class TestPassword {
    private String str;
    public Pattern patternLowerUpperCase = Pattern.compile("[A-Z][a-z]");
    public Pattern patternHasNumber = Pattern.compile("[0-9]");
    //Check Password
    public TestPassword(String str) {
        this.str = str;
    }
    //Check if size is correct
    public boolean checkSize() {
        int minLength = 8;
        int maxLength = 25;
        return str.matches(".{8,25}");
        //return str.length() > minLength && str.length() < maxLength;
    }
    //Check if there is min 1 uppercase and 1 lowercase
    public boolean checkCaseSensitive() {
        return patternLowerUpperCase.matcher(str).find();
        //return !str.matches("[A-Z]") && !str.matches("[a-z]");
    }
    //Check if there is min 1 number
    public boolean checkNumber() {
        //return !str.matches("[0-9]");
        return patternHasNumber.matcher(str).find();
    }
    //Check if there is a special character
    public boolean checkSpecial() {
        return str.matches("(?=(.*[()#$?!%/@]))");
    }
    //Check if there are other symbols
    public boolean checkAllowedSymbols() {
        return str.matches("[a-zA-Z0-9()#$?!%/@]*");
    }
    //Check if numbers are counting
    public boolean checkNumberCounting() {
        return !str.matches(".*(012|123|234|345|456|567|678|789|890)+.*");
    }
    //Check if numbers are same
    public boolean checkSameNumber() {
        return !str.matches(".*(1111|2222|3333|4444|5555|6666|7777|8888|9999|0000)+.*");
    }
}