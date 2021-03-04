package fh.ac.at;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @DisplayName("Size:")
    @Test
    void checkPassword_Size() {
        TestPassword PasswordSize = new TestPassword("1234567"); //7
        Assertions.assertFalse(PasswordSize.checkSize());
        System.out.println("Size: 7 " + PasswordSize.checkSize());

        PasswordSize = new TestPassword("12345678901234567890123456"); //26
        Assertions.assertFalse(PasswordSize.checkSize());
        System.out.println("Size: 27 " + PasswordSize.checkSize());

        PasswordSize = new TestPassword("1234567890123456"); //26
        Assertions.assertTrue(PasswordSize.checkSize());
        System.out.println("Size: 16 " + PasswordSize.checkSize());
    }

    @DisplayName("LowerUpperCase:")
    @Test
    void checkPassword_LowerUpperCase() {
        TestPassword PasswordLowerUpperCase = new TestPassword("ABCDEFG");
        Assertions.assertFalse(PasswordLowerUpperCase.checkCaseSensitive());
        System.out.println("ABC: " + PasswordLowerUpperCase.checkCaseSensitive());

        PasswordLowerUpperCase = new TestPassword("abcdefg");
        Assertions.assertFalse(PasswordLowerUpperCase.checkCaseSensitive());
        System.out.println("abc: " + PasswordLowerUpperCase.checkCaseSensitive());

        PasswordLowerUpperCase = new TestPassword("aBcDeFg");
        Assertions.assertTrue(PasswordLowerUpperCase.checkCaseSensitive());
        System.out.println("aBc: " + PasswordLowerUpperCase.checkCaseSensitive());
    }

    @DisplayName("Has Number:")
    @Test
    void checkPassword_HasNumber() {
        TestPassword PasswordHasNumber = new TestPassword("abcdefg");
        Assertions.assertFalse(PasswordHasNumber.checkCaseSensitive());
        System.out.println("no Number: " + PasswordHasNumber.checkNumber());

        PasswordHasNumber = new TestPassword("abc4efg");
        Assertions.assertFalse(PasswordHasNumber.checkCaseSensitive());
        System.out.println("yes Number: " + PasswordHasNumber.checkNumber());
    }

    @DisplayName("Spezial Symbol:")
    @Test
    void checkPassword_Spezial() {
        TestPassword passwordHasSpezial = new TestPassword("abcdefg"); //[()#$?!%/@]
        Assertions.assertFalse(passwordHasSpezial.checkSpecial());
        System.out.println("no Spezial: " + passwordHasSpezial.checkSpecial());

        passwordHasSpezial = new TestPassword("abc4[efg");
        Assertions.assertFalse(passwordHasSpezial.checkCaseSensitive());
        System.out.println("yes Spezial: " + passwordHasSpezial.checkSpecial());

        passwordHasSpezial = new TestPassword("abcd*efg"); //[()#$?!%/@]
        Assertions.assertFalse(passwordHasSpezial.checkSpecial());
        System.out.println("not allowed Spezial: " + passwordHasSpezial.checkSpecial());
    }

    @DisplayName("Check Allowed Symbols:")
    @Test
    void checkPassword_Allowed() {
        TestPassword passwordAllowed = new TestPassword("aBcde.9756"); //[()#$?!%/@]
        Assertions.assertFalse(passwordAllowed.checkAllowedSymbols());
        System.out.println("Not Allowed: ." + passwordAllowed.checkAllowedSymbols());

        passwordAllowed = new TestPassword("aBcde(9756");
        Assertions.assertTrue(passwordAllowed.checkAllowedSymbols());
        System.out.println("Allowed: (" + passwordAllowed.checkAllowedSymbols());
    }

    @DisplayName("Check Counting:")
    @Test
    void checkPassword_Counting() {
        TestPassword passwordCounting = new TestPassword("aBcde234rfgh");
        Assertions.assertFalse(passwordCounting.checkNumberCounting());
        System.out.println("Not Allowed: 234" + passwordCounting.checkNumberCounting());

        passwordCounting = new TestPassword("aBcde23rfg45h");
        Assertions.assertTrue(passwordCounting.checkNumberCounting());
        System.out.println("Allowed: " + passwordCounting.checkNumberCounting());
    }

    @DisplayName("Check Same Number:")
    @Test
    void checkPassword_SameNumber() {
        TestPassword passwordSameNumber = new TestPassword("aBcde1111rfgh");
        Assertions.assertFalse(passwordSameNumber.checkSameNumber());
        System.out.println("Not Allowed: 1111" + passwordSameNumber.checkSameNumber());

        passwordSameNumber = new TestPassword("aBcde333rfg33h");
        Assertions.assertTrue(passwordSameNumber.checkSameNumber());
        System.out.println("Allowed: " + passwordSameNumber.checkSameNumber());
    }

}
