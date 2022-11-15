package ComputerArchitecture;

import java.lang.Math;
/*
NAME: JAN KARL GALIA
CLASS: COMPUTER ARCHITECTURE          ******************NOTE TO USERS: TESTS ARE AUTOMATED, VALUES(BINARY BIT ARRAYS AND INTEGERS) ARE RANDOMLY GENERATED************
                                                 *************TO CONVERT TO T,F RATHER THAN 1,0, REPLACE toStringConvert() to toString()**********
*/


public class Longword_test {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {

        testSetAndGet();
        testLongwordAnd();
        testLongwordOr();
        testLongwordXor();
        testLongwordNot();
        testRightShift();
        testLeftShift();
        testGetUnsigned();
        testGetSigned();
        testCopy();
        testSet();
    }

    public static void testSetAndGet() { //Tests getBit and setBit
        Longword otherInput = new Longword();
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        bitTrue.set(true);
        System.out.println("-----------------------------------------------------");
        System.out.println("TestSetAndGet:");//Tests setBit and getBit
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            if (randomBit.randomBool()) {
                randomInput.setBit(i, bitTrue);//Testing setBit(int,Bit)
            }
            System.out.print(randomInput.getBit(i));//Testing getBit(int)
        }
        System.out.println();
    }

    public static void testLongwordAnd() {
        Longword otherInput = new Longword();
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        bitTrue.set(true);
        boolean randomBool = false;
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            randomBool = randomBit.randomBool();
            if (randomBool) {
                randomInput.setBit(i, bitTrue);
            }
        }
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            randomBool = randomBit.randomBool();
            if (randomBool) {
                otherInput.setBit(i, bitTrue);
            }
        }
        //--------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------");
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestLongwordAnd(1,0):" + randomInput.and(otherInput).toStringConvert());
        System.out.println("TestLongwordAnd(t,f):" + randomInput.and(otherInput).toString());
    }

    public static void testLongwordOr() {
        Longword otherInput = new Longword();
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        bitTrue.set(true);
        boolean randomBool = false;
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            randomBool = randomBit.randomBool();
            if (randomBool) {
                randomInput.setBit(i, bitTrue);
            }
        }
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            randomBool = randomBit.randomBool();
            if (randomBool) {
                otherInput.setBit(i, bitTrue);
            }
        }
        //--------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------");
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestLongwordOr(1,0):" + randomInput.or(otherInput).toStringConvert());
        System.out.println("TestLongwordOr(t,f):" + randomInput.or(otherInput).toString());

    }

    public static void testLongwordXor() {
        Longword otherInput = new Longword();
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        bitTrue.set(true);
        boolean randomBool = false;
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            randomBool = randomBit.randomBool();
            if (randomBool) {
                randomInput.setBit(i, bitTrue);
            }
        }
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            randomBool = randomBit.randomBool();
            if (randomBool) {
                otherInput.setBit(i, bitTrue);
            }

        }
        //--------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------");
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestLongwordXor(1,0):" + randomInput.xor(otherInput).toStringConvert());
        System.out.println("TestLongwordXor(t,f):" + randomInput.xor(otherInput).toString());
    }

    public static void testLongwordNot() {
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit(1);
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            if (randomBit.randomBool()) {
                randomInput.setBit(i, bitTrue);
            }
        }
        //--------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------");
        System.out.println("TestBeforeLongwordNot:" + randomInput.toStringConvert());
        System.out.println("TestLongwordNot(1,0):" + randomInput.not().toStringConvert());
        System.out.println("TestLongwordNot(t,f):" + randomInput.not().toString());
    }

    public static void testRightShift() {
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        Bit bitFalse = new Bit();
        bitTrue.set(true);
        bitFalse.set(false);
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            if (randomBit.randomBool()) {
                randomInput.setBit(i, bitTrue);
            }
            if (!randomBit.randomBool()) {
                randomInput.setBit(i, bitFalse);
            }
        }
        //--------------------------------------------------------------------------------------------
        int max = 31;//Max Shift
        int min = 0; //Min Shift
        int amount = (int) (Math.random() * (max - min + 1) + min);//Amount of right shift
        System.out.println("-------------------------------------------");
        System.out.println("Amount of Right Shift:" + amount);
        System.out.println("TestLongwordBeforeRightShift:" + randomInput.toStringConvert());
        System.out.println("TestLongwordRightShift:" + randomInput.rightShift(amount).toStringConvert());
    }

    public static void testLeftShift() {
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        Bit bitFalse = new Bit();
        bitTrue.set(true);
        bitFalse.set(false);
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            if (randomBit.randomBool()) {
                randomInput.setBit(i, bitTrue);
            }
            if (!randomBit.randomBool()) {
                randomInput.setBit(i, bitFalse);
            }
        }
        //--------------------------------------------------------------------------------------------
        int max = 31;//Max Shift
        int min = 0; //Min Shift
        int amount = (int) (Math.random() * (max - min + 1) + min);//Amount of right shift
        System.out.println("-------------------------------------------");
        System.out.println("Amount of Left Shift:" + amount);
        System.out.println("TestLongwordBeforeLeftShift:" + randomInput.toStringConvert());
        System.out.println("TestLongwordLeftShift:" + randomInput.leftShift(amount).toStringConvert());
    }

    public static void testGetUnsigned() {
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        Bit bitFalse = new Bit();
        bitTrue.set(true);
        bitFalse.set(false);
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            if (randomBit.randomBool()) {
                randomInput.setBit(i, bitTrue);
            }
            if (!randomBit.randomBool()) {
                randomInput.setBit(i, bitFalse);
            }
        }
        //--------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------");
        System.out.println("TestUnsignedBits:" + randomInput.toStringConvert());
        System.out.println("TestgetUnsigned:" + randomInput.getUnsigned());
    }

    public static void testGetSigned() {
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        Bit bitFalse = new Bit();
        bitTrue.set(true);
        bitFalse.set(false);
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            if (randomBit.randomBool()) {
                randomInput.setBit(i, bitTrue);
            }
            if (!randomBit.randomBool()) {
                randomInput.setBit(i, bitFalse);
            }
        }
        //--------------------------------------------------------------------------------------------
        randomInput.setBit(31, bitTrue);//Testing negative 2s complement, REMOVE TO TEST POSITIVE 2s COMPLEMENT
        System.out.println("-------------------------------------------");
        System.out.println("TestSignedBits:" + randomInput.toStringConvert());
        System.out.println("TestgetSigned:" + randomInput.getSigned());
    }

    public static void testCopy() {
        Longword result = new Longword();
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        Bit bitFalse = new Bit();
        bitTrue.set(true);
        bitFalse.set(false);
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to randomInput bitArray
            if (randomBit.randomBool()) {
                randomInput.setBit(i, bitTrue);
            }
            if (!randomBit.randomBool()) {
                randomInput.setBit(i, bitFalse);
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("TestCopyOtherInput:" + randomInput.toStringConvert());
        //--------------------------------------------------------------------------------------------
        result.copy(randomInput);
        System.out.println("TestCopyResult(1,0):" + result.toStringConvert());
        System.out.println("TestCopyResult(t,f):" + result);
    }

    public static void testSet() {
        Longword test = new Longword();
        int max = 2147483641;
        int min = 0;
        int value = (int) (Math.random() * (max - min + 1) + min);//Amount of right shift
        test.set(value);
        System.out.println("-------------------------------------------");
        System.out.println("TestSetValue(RandomValue):" + value);
        System.out.println("TestSet(1,0):" + test.toStringConvert());
        System.out.println("TestSet(t,f):" + test);
    }
}
