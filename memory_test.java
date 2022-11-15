package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture  ******************NOTE TO USERS: TESTS ARE AUTOMATED, VALUES(BINARY BIT ARRAYS AND INTEGERS) ARE RANDOMLY GENERATED************
                                                 *************TO CONVERT TO T,F RATHER THAN 1,0, REPLACE toStringConvert() to toString()**********
HW 5: Memory
*/
public class memory_test {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testReadAndWrite();
    }
    public static void testReadAndWrite() {
        Longword value = new Longword();
        //Random BitArray Generator for Automatic testing---------------------------------------
        Longword address = new Longword();
        Bit randomBit = new Bit();
        Bit bitTrue = new Bit();
        bitTrue.set(true);
        boolean randomBool = false;
        for (int i = 0; i < 8; i++) {//Creates Random binary string and sets it to address bitArray
            randomBool = randomBit.randomBool();
            if (randomBool) {
                address.setBit(i, bitTrue);
            }
        }
        for (int i = 0; i < 32; i++) {//Creates Random binary string and sets it to address bitArray
            randomBool = randomBit.randomBool();
            if (randomBool) {
                value.setBit(i, bitTrue);
            }
        }
        memory testMemory = new memory();
        testMemory.write(address, value); //Writes to random address and random value is also generated
        //--------------------------------------------------------------------------------------------
        System.out.println("-------------------------------------------");

        System.out.println("AddressInInt(MAX 255):" + address.getSigned());
        System.out.println("Testing Writing Method: ValueIntoAddress(Binary)(MAX 255):" + value.toStringConvert());
        System.out.println("Testing Writing Method: ValueIntoAddress(int)(MAX 255):" + value.getSigned());
        System.out.println("Testing Reading Method: Address(" + address.getSigned() + ")):" + testMemory.read(address).toStringConvert());
    }
}
