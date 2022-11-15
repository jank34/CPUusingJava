package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture
HW 4: The Multiplier
*/
public class multiplier_test {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testMultiplier();
    }

    public static void testMultiplier() {
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
        System.out.println("Generating Random Inputs Each Run");
        System.out.println("TestFirstInput:" + randomInput.toStringConvert());
        System.out.println("TestOtherInput:" + otherInput.toStringConvert());
        System.out.println("TestLower32Half-BitsMultiplier:(1,0):" + multiplier.multiply(randomInput, otherInput).toStringConvert());
        System.out.println("TestLower32Half-BitsMultiplier:(t,f):" + multiplier.multiply(randomInput, otherInput).toString());
    }

}
