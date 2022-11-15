package ComputerArchitecture;
/*
Jan Karl Galia
Comp. Architecture  ******************NOTE TO USERS: TESTS ARE AUTOMATED, VALUES(BINARY BIT ARRAYS AND INTEGERS) ARE RANDOMLY GENERATED************
                                                 *************TO CONVERT TO T,F RATHER THAN 1,0, REPLACE toStringConvert() to toString()**********
HW 3: Ripple Adder
*/
public class rippleAdder_test {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testLongwordAdd();
        testLongwordSub();
    }

    public static void testLongwordAdd() {
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
        System.out.println("ADDING 2s Complement(Inputs and Outputs)");
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestAdder(32-Bits):" + rippleAdder.add(randomInput, otherInput).toStringConvert());
    }

    public static void testLongwordSub() {
        Longword otherInput = new Longword();
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword randomInput = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit(1);
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
        System.out.println("SUBTRACTING 2s Complement(Inputs and Outputs)");
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestSubtract(32-Bits):" + rippleAdder.sub(randomInput, otherInput).toStringConvert());
    }
}
