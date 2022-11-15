package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture  ******************NOTE TO USERS: TESTS ARE AUTOMATED, VALUES(BINARY BIT ARRAYS AND INTEGERS) ARE RANDOMLY GENERATED************
                                                 *************TO CONVERT TO T,F RATHER THAN 1,0, REPLACE toStringConvert() to toString()**********
HW 6: computer
*/
public class cpu_test1 {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testRun();
    }

    public static void testRun() {
        String testString[] = new String[4];//1 String = 1 Instruction
        computer test = new computer();
        //3 Instructions
        testString[0] = new String();
        testString[1] = new String();
        testString[2] = new String();
        testString[3] = new String();
        // ---------------------------------PROGRAM TESTING-----------------------------------------------------
        System.out.println("-----------------TESTING PROGRAM 1----------------------");
        testString[0] = "0001 0010 0000 1010"; //move R2 10
        testString[1] = "0001 0001 0111 1111"; //move R1 127
        testString[2] = "1110 0001 0010 0011";//Add R1 to R2 and put the result in R3
        testString[3] = "0010 0000 0000 0000";//Print All Registers
        // ---------------------------------PROGRAM TESTING-----------------------------------------------------
        test.preload(testString);
        test.run();
//--------------------------------------PROGRAM 2--------------------------------------------------------

        String test2String[] = new String[5];//1 String = 1 Instruction
        computer test2 = new computer();
        //3 Instructions
        test2String[0] = new String();
        test2String[1] = new String();
        test2String[2] = new String();
        test2String[3] = new String();
        test2String[4] = new String();
        // ---------------------------------PROGRAM TESTING-----------------------------------------------------
        System.out.println("-----------------TESTING PROGRAM 2----------------------");
        test2String[0] = "0001 0010 0101 0111"; //move R2 87
        test2String[1] = "0001 0101 0111 1100"; //move R5 124
        test2String[2] = "1001 0101 0010 1010";//OR R2 to R5 and put the result in R10
        test2String[3] = "0010 0000 0000 0000";//Print All Registers
        test2String[4] = "0010 0000 0000 0001";//Print All Bytes
        // ---------------------------------PROGRAM TESTING-----------------------------------------------------
        test2.preload(test2String);
        test2.run();
//--------------------------------------PROGRAM 2--------------------------------------------------------

        //--------------------------------------PROGRAM 3--------------------------------------------------------

        String test3String[] = new String[4];//1 String = 1 Instruction
        computer test3 = new computer();
        //3 Instructions
        test3String[0] = new String();
        test3String[1] = new String();
        test3String[2] = new String();
        test3String[3] = new String();
        // ---------------------------------PROGRAM TESTING-----------------------------------------------------
        System.out.println("-----------------TESTING PROGRAM 3----------------------");
        test3String[0] = "0001 0000 1111 1100"; //move R0 -4
        test3String[1] = "0001 0101 0000 0011"; //move R5 3
        test3String[2] = "1100 0000 0101 1111";//Shift R0 by R5 and put the result in R15
        test3String[3] = "0010 0000 0000 0000";//Print All Registers
        // ---------------------------------PROGRAM TESTING-----------------------------------------------------
        test3.preload(test3String);
        test3.run();
//--------------------------------------PROGRAM 3--------------------------------------------------------
    }
}