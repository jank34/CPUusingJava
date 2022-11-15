package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture  ******************NOTE TO USERS: TESTS ARE AUTOMATED, VALUES(BINARY BIT ARRAYS AND INTEGERS) ARE RANDOMLY GENERATED************
                                                 *************TO CONVERT TO T,F RATHER THAN 1,0, REPLACE toStringConvert() to toString()**********
HW 9: JUMP, JUMP!
*/
public class cpu_test2 {
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
            //Testing Jump Instruction
        String[] test1 = new String[]{"jump 6", "move R1 5", "interrupt 0", "halt"}; //Instructions will not run
        String[] assembledCode = Assembler.assemble(test1);
        testComp.preload(assembledCode);
        testComp.run();
        System.out.println("-----------------TESTING PROGRAM JUMP----------------------");
        // ---------------------------------PROGRAM TESTING JUMP-----------------------------------------------------

        System.out.println("");

        //---PROGRAM TESTING BranchifEqual-----------------------------------------------------
        computer testComp2 = new computer();
        System.out.println("-----------------TESTING PROGRAM BranchifEqual----------------------");
        String[] test2 = new String[]{"move R1 5","move R2 5", "compare R1 R2", "BranchifEqual -2",  "interrupt 0", "halt"}; //Instructions will run
        String[] assembledCode2 = Assembler.assemble(test2);
        testComp2.preload(assembledCode2);
        testComp2.run();
        System.out.println("-----------------TESTING PROGRAM BranchifEqual----------------------");

        System.out.println("");

        // ---------------------------------PROGRAM TESTING BranchifEqual-----------------------------------------------------
        computer testComp3 = new computer();
        //---PROGRAM TESTING BranchifGreaterThan-----------------------------------------------------
        System.out.println("-----------------TESTING PROGRAM BranchifGreaterThan----------------------");
        String[] test3 = new String[]{"move R1 100","move R2 5", "compare R1 R2", "BranchifGreaterThan 50",  "interrupt 0", "halt"}; //Instructions will run
        String[] assembledCode3 = Assembler.assemble(test3);
        testComp3.preload(assembledCode3);
        testComp3.run();
        System.out.println("-----------------TESTING PROGRAM BranchifGreaterThan----------------------");
        // ---------------------------------PROGRAM TESTING BranchifGreaterThan-----------------------------------------------------

        System.out.println("");

        // ---------------------------------PROGRAM TESTING BranchifLessThan-----------------------------------------------------
        computer testComp4 = new computer();
        //---PROGRAM TESTING-----------------------------------------------------
        System.out.println("-----------------TESTING PROGRAM BranchifLessThan----------------------");
        String[] test4 = new String[]{"move R1 11","move R2 79", "compare R1 R2", "BranchifLessThan 25",  "interrupt 0", "halt"}; //Instructions will run
        String[] assembledCode4 = Assembler.assemble(test4);
        testComp4.preload(assembledCode4);
        testComp4.run();
        System.out.println("-----------------TESTING PROGRAM BranchifLessThan----------------------");
        // ---------------------------------PROGRAM TESTING BranchifLessThan-----------------------------------------------------

        System.out.println("");

        // ---------------------------------PROGRAM TESTING BranchifNotEqual-----------------------------------------------------
        computer testComp5 = new computer();
        //---PROGRAM TESTING-----------------------------------------------------
        System.out.println("-----------------TESTING PROGRAM BranchifNotEqual----------------------");
        String[] test5 = new String[]{"move R1 11","move R2 79", "compare R1 R2", "BranchifNotEqual 60",  "interrupt 0", "halt"}; //Instructions will run
        String[] assembledCode5 = Assembler.assemble(test5);
        testComp5.preload(assembledCode5);
        testComp5.run();
        System.out.println("-----------------TESTING PROGRAM BranchifNotEqual----------------------");
        // ---------------------------------PROGRAM TESTING BranchifNotEqual-----------------------------------------------------
    }
}