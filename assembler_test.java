package ComputerArchitecture;
/*
Jan Karl Galia
Comp. Architecture
HW 8: Assembler
*/
public class assembler_test {
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testAssemble();
    }

    public static void testAssemble() {
        Assembler testAssemble = new Assembler();
        String [] testStrings = new String[36];
        testStrings[0] = "move R2 10";
        testStrings[1] = "move R1 -4";
        testStrings[2] = "add R2 R1 R12";
        testStrings[3] = "leftshift R1 R2 R4";
        testStrings[4] = "multiply R4 R3 R11";
        testStrings[5] = "rightshift R1 R2 R4";
        testStrings[6] = "subtract R2 R1 R12";
        testStrings[7] = "not R2 R3";
        testStrings[8] = "interrupt 0";
        testStrings[9] = "interrupt 1";
        testStrings[10] = "halt";
        testStrings[11] = "or R2 R11 R12 ";
        testStrings[12] = "xor R0 R5 R6 ";
        testStrings[13] = "add R2 R1 R12";
        testStrings[14] = "leftshift R3 R1 R0";
        testStrings[15] = "multiply R5 R6 R11";
        testStrings[16] = "rightshift R2 R9 R8";
        testStrings[17] = "subtract R7 R4 R1";
        testStrings[18] = "not R0 R11";
        testStrings[19] = "interrupt 0";
        testStrings[20] = "interrupt 1";
        testStrings[21] = "halt";
        testStrings[22] = "or R1 R11 R12 ";
        testStrings[23] = "xor R7 R4 R6 ";
        testStrings[24] = "jump 1276";
        testStrings[25] = "compare R1 R2";
        testStrings[26] = "BranchifNotEqual 100";
        testStrings[27] = "BranchifEqual -100";
        testStrings[28] = "BranchifGreaterThan 200";
        testStrings[29] = "BranchifLessThan -2";
        testStrings[30] = "interrupt 0";
        testStrings[31] = "interrupt 1";
        testStrings[32] = "call 25  ";
        testStrings[33] = "push R5";
        testStrings[34] = "pop R2";
        testStrings[35] = "return";
        testAssemble.assemble(testStrings);

    }

}
