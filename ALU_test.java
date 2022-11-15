package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture ******************NOTE TO USERS: TESTS ARE AUTOMATED, VALUES(BINARY BIT ARRAYS AND INTEGERS) ARE RANDOMLY GENERATED************
                                                 *************TO CONVERT TO T,F RATHER THAN 1,0, REPLACE toStringConvert() to toString()**********
HW 4: The ALU
*/

public class ALU_test {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testALU();
    }

    public static void testALU() {
        final Bit[] test = new Bit[4];
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
        System.out.println("AND");
        test[0] = new Bit(1);
        test[1] = new Bit(0);
        test[2] = new Bit(0);
        test[3] = new Bit(0);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestALUand(t,f):" + ALU.doOp(test, randomInput, otherInput));
        System.out.println("TestALUand(1,0):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());
        //--------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------");
        System.out.println("OR");
        test[0] = new Bit(1);
        test[1] = new Bit(0);
        test[2] = new Bit(0);
        test[3] = new Bit(1);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestALUor(t,f):" + ALU.doOp(test, randomInput, otherInput));
        System.out.println("TestALUor(1,0):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());
        //--------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------");
        System.out.println("XOR");
        test[0] = new Bit(1);
        test[1] = new Bit(0);
        test[2] = new Bit(1);
        test[3] = new Bit(0);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestALUxor(t,f):" + ALU.doOp(test, randomInput, otherInput));
        System.out.println("TestALUxor(1,0):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());
        System.out.println("-------------------------------------------");
        System.out.println("NOT");
        test[0] = new Bit(1);
        test[1] = new Bit(0);
        test[2] = new Bit(1);
        test[3] = new Bit(1);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestALUnot(1,0):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());
        System.out.println("-------------------------------------------");
        System.out.println("LEFT SHIFT");
        test[0] = new Bit(1);
        test[1] = new Bit(1);
        test[2] = new Bit(0);
        test[3] = new Bit(0);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestALULeftShift(1,0):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());
        System.out.println("-------------------------------------------");
        System.out.println("RIGHT SHIFT");
        test[0] = new Bit(1);
        test[1] = new Bit(1);
        test[2] = new Bit(0);
        test[3] = new Bit(1);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestALURightShift(1,0):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());
        System.out.println("-------------------------------------------");
        System.out.println("ADDING 2s Complement Inputs, OUTPUT SIGNS ARE BIT[33]");
        test[0] = new Bit(1);
        test[1] = new Bit(1);
        test[2] = new Bit(1);
        test[3] = new Bit(0);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestALUAdd(1,0)(2sComplement-Sign Bit NOT INCLUDED):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());
        System.out.println("-------------------------------------------");
        System.out.println("SUBTRACTING 2s Complement Inputs, OUTPUT SIGNS ARE BIT[33]");
        test[0] = new Bit(1);
        test[1] = new Bit(1);
        test[2] = new Bit(1);
        test[3] = new Bit(1);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestALUSub(1,0)(2sComplement-Sign Bit NOT INCLUDED):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());
        System.out.println("-------------------------------------------");
        System.out.println("MULTIPLYING 2s COMPLEMENT, OUTPUTTING LOWER 32 BITS ONLY");
        test[0] = new Bit(0);
        test[1] = new Bit(1);
        test[2] = new Bit(1);
        test[3] = new Bit(1);
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestALUMultiply(t,f):" + ALU.doOp(test, randomInput, otherInput));
        System.out.println("TestALUMultiply(1,0):" + ALU.doOp(test, randomInput, otherInput).toStringConvert());


    }

}
