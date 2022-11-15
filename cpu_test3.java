package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture  ******************NOTE TO USERS: TESTS ARE AUTOMATED, VALUES(BINARY BIT ARRAYS AND INTEGERS) ARE RANDOMLY GENERATED************
                                                 *************TO CONVERT TO T,F RATHER THAN 1,0, REPLACE toStringConvert() to toString()**********
HW 10: Stack
*/
public class cpu_test3{
    public static void main(String[] args) {
        runTests();
    }

    public static void runTests() {
        testRun();
    }

    public static void testRun() {
        //---PROGRAM TESTING JUMP-----------------------------------------------------
        computer testComp = new computer();
        System.out.println("-----------------TESTING PROGRAM JUMP----------------------");
        //Testing PROGRAM
        String[] code = new String[]{"move R1 3" , "move R2 4", "push R1","push R2","call 500","pop R15","pop R1","pop R2","add R1 R2 R3","push R3","push R15","return","return","interrupt 0"};
        String[] assembledCode = Assembler.assemble(code);
        testComp.preload(assembledCode);
        testComp.run();

        System.out.println("-----------------TESTING PROGRAM JUMP----------------------");
        // ---------------------------------PROGRAM TESTING JUMP-----------------------------------------------------

    }
}