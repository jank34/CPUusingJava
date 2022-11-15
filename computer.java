package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture
HW 6: Computer
*/
public class computer {
    private Bit halt = new Bit(0);
    private final memory Memory = new memory();
    private Longword PC = new Longword(); //Address
    private Longword currentInstruction = new Longword();//Stores the value from fetch()
    private final Longword addTwo = new Longword(); //Adding 2 Bytes to PC
    private final Longword addFour = new Longword(); //Adding 4 Bytes to PC
    private final Bit bitTrue = new Bit(1); //To set longword Bits to true
    private final Bit bitFalse = new Bit(0); //To set longword Bits to false
    private Longword[] register = new Longword[16];//Registers, Register[i] is 32 Bits
    private Longword op1 = new Longword();
    private Longword op2 = new Longword();
    private final Longword mask = new Longword(); //1111
    private Longword result = new Longword();//Stores Result
    private Longword preloadAddressTrack = new Longword();//For preload method
    private Bit[] compareResult = new Bit[2];//Compare Result Bits for Branching(Used in store)
    private Longword mask1s = new Longword(); // Mask of 1s
    private Longword signedAddress = new Longword();
    private Longword SP = new Longword();
    private Longword returnAddress = new Longword();

    public void run() {
        //Initializing Stack Pointer to Byte 1020 (Bit 8160)
        for (int i = 5; i <= 12; i++) SP.setBit(i, bitTrue);

        mask1s = mask1s.not();//For Branching
        //Compare Result Bits for Branching (Used in Store)
        compareResult[0] = new Bit();
        compareResult[1] = new Bit();
        for (int i = 0; i < 4; i++) mask.setBit(i, bitTrue); //For Decode
        while (!halt.getValue()) {//Loop Runs when halt == false
            fetch();
            decode();
            execute();
            store();
        }
        if (halt.getValue()) {
            System.out.println("-----------COMPUTER HALTED----------------");
        }

    }

    public void fetch() {//Fetching Op Code
        if (PC.getSigned() >= 8160) halt.set(true); //Stops when PC is about reach 8192
        System.out.println("PC:"+ PC.getSigned()+" Instructions In PC: "+ Memory.read(PC).leftShift(16).rightShift(16).toStringConvert());

        if (PC.getSigned() < 0) {
            System.out.println("Memory is negative -- Halting Computer");
            halt.set(true);
        }
        if (PC.getSigned() >= 0) {
            currentInstruction = Memory.read(PC); //Reads the memory of the address given by PC---> PC > 0, PC > 16, PC >32
            PC = rippleAdder.add(addTwo, PC); //Incrementing PC by 2 Bytes
        }
//        System.out.println("PC: " + PC.getSigned());
//        System.out.println("Test SP: " + SP.getSigned());


    }

    public void decode() {
        //Compare (0100)
        if (!currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()) {
            if (register[currentInstruction.leftShift(24).rightShift(28).and(mask).getSigned()] != null)
                op1.copy(register[currentInstruction.leftShift(24).rightShift(28).and(mask).getSigned()]); //Rx
            if (register[currentInstruction.leftShift(28).rightShift(28).and(mask).getSigned()] != null)
                op2.copy(register[currentInstruction.leftShift(28).rightShift(28).and(mask).getSigned()]);//Ry
        }

        //If other instruction
        else if (!(!currentInstruction.getBit(12).getValue() && currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()))  //!Interrupt 0 & 1
            if (!(!currentInstruction.getBit(12).getValue() && currentInstruction.getBit(13).getValue() && currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()))//!Push, Pop, Call, Return
                if (!(currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()))//!Branch
                    if (!(currentInstruction.getBit(12).getValue() && currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue())) //!Jump
                        if (!(!currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue())) //!Halt
                            if (!(currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()))//!Move
                            {
                                if (register[currentInstruction.leftShift(20).rightShift(28).and(mask).getSigned()] != null)
                                    op1.copy(register[currentInstruction.leftShift(20).rightShift(28).and(mask).getSigned()]); //Left Shift by 20, Right shift by 28 bits, then and with mask to get first register

                                if (register[currentInstruction.leftShift(24).rightShift(28).and(mask).getSigned()] != null)
                                    op2.copy(register[currentInstruction.leftShift(24).rightShift(28).and(mask).getSigned()]);//Left Shift by 24, Right shift by 28 bits, then and with mask to get second register
                            }
    }


    public void execute() {
        result = new Longword();//Resets result for holding new instruction every loop
        //------------------------------------------------------------------------
        //INTERRUPT 0: Print all the registers to the screen
        if ((!currentInstruction.getBit(12).getValue() && currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue() && !currentInstruction.getBit(0).getValue())) {
            for (int i = 0; i < 16; i++) {
                if (register[i] == null) {//If register is not defined
                    System.out.println("Register[" + i + "] is NULL");
                } else System.out.println("Register[" + i + "] is " + register[i].toStringConvert());
            }
        }//INTERRUPT 1: Print all 1024 Bytes of memory to the screen
        if ((!currentInstruction.getBit(12).getValue() && currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue() && currentInstruction.getBit(0).getValue())) {
            Longword addressTracker = new Longword();//For printing all Bytes
            Longword add32 = new Longword(); //Adds 32 Bits to address tracker
            add32.setBit(5, bitTrue); //Adding to address every iteration
            for (int i = 0; i < 256; i++) { //256 Longwords
                System.out.println(Memory.read(addressTracker).toStringConvert());
                addressTracker = rippleAdder.add(addressTracker, add32);
            }
        }
        //---------------------------------------------------------------------------
        if ((!currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue())) {// HALT!!!!!!
            halt.set(true);//Sets halt bit to true
            return;//Ends Method
        }
        //In execute, pass the control bits (the opcode) into the ALU along with op1 and op2.
        Bit Bits[] = new Bit[4];
        String opCode = "";//Converting Bit[] into string of 1,0 and sets it into opCode
        int track = 3;
        for (int i = 0; i < 4; i++) {//Extracting ALU bits in currentInstruction
            if (currentInstruction.leftShift(16).rightShift(28).getBit(track).getValue()) {
                Bits[i] = new Bit(1);
                opCode = opCode + "1";
            } else if (!currentInstruction.leftShift(16).rightShift(28).getBit(track).getValue()) {
                Bits[i] = new Bit(0);
                opCode = opCode + "0";
            }
            track--;
        }
        if (!currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()) {//If compare then subtract
            Bits[0].set(true);
            Bits[1].set(true);
            Bits[2].set(true);
            Bits[3].set(true);
        }
        if (!halt.getValue()) {
            if (!Bits[0].getValue() && !Bits[1].getValue() && !Bits[2].getValue() && Bits[3].getValue()) { //For Move Instruction
                result.copy(currentInstruction);
                if (currentInstruction.getBit(7).getValue()) {//If negative then set rest of result 32 Bit to 1s
                    for (int i = 8; i < 32; i++)
                        result.setBit(i, bitTrue);
                }
                if (!currentInstruction.getBit(7).getValue()) {//If positive then set rest of result 32 Bit to 1s
                    for (int i = 8; i < 32; i++) result.setBit(i, bitFalse);
                }
            } else {//For any other instruction
                result = new ALU().doOp(Bits, op1, op2);// Create a new longword called result and put the result from the ALU into the result longword.Calls the ALU
            }
        }
        //Branch(0101)
        if (currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()) {
            //Signed Address
            //If positive (sign = 0)
            if (!currentInstruction.getBit(9).getValue()) {
                signedAddress = currentInstruction.leftShift(22).rightShift(22);
            }
            //If negative(sign = 1)
            if (currentInstruction.getBit(9).getValue()) {
                signedAddress = currentInstruction.leftShift(22).rightShift(22).or(mask1s.leftShift(10));
            }
        }
    }

    public void store() {
        //Copies result into destination register
        if (!halt.getValue()) {
            //Push, Pop, Call, Return
            if (!currentInstruction.getBit(12).getValue() && currentInstruction.getBit(13).getValue() && currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()) {
                //Push(00) Bit 11, Bit 10
                if (!currentInstruction.getBit(10).getValue() && !currentInstruction.getBit(11).getValue()) {
                    Memory.write(SP, register[currentInstruction.leftShift(28).rightShift(28).getSigned()]); //Write into Stack
                    System.out.println("Push Stack Value: "+Memory.read(SP).getSigned()+" SP: "+SP.getSigned());
                    SP.copy(rippleAdder.sub(SP, addFour));//Subtract 4 Bytes to SP
                }
                //Pop(01)
                if (currentInstruction.getBit(10).getValue() && !currentInstruction.getBit(11).getValue()) {
                    SP.copy(rippleAdder.add(SP, addFour));//Add 4 Bytes to SP
                    register[currentInstruction.leftShift(28).rightShift(28).getSigned()] = Memory.read(SP); //Reads Stack
                    System.out.println("Popping Stack Value: "+Memory.read(SP).getSigned()+" SP: "+SP.getSigned());
                    Memory.write(SP, new Longword()); //Converts data in current SP to 0s
                }
                //Call(10)
                if (!currentInstruction.getBit(10).getValue() && currentInstruction.getBit(11).getValue()) {

                    Memory.write(SP, PC); //Pushes the address into the stack
                    System.out.println("Calling Stack Value: "+Memory.read(SP).getSigned()+" SP: "+SP.getSigned());
                    SP.copy(rippleAdder.sub(SP, addFour));//Subtract 4 Bytes to SP
                    PC.copy(currentInstruction.leftShift(22).rightShift(22));//Call then Jumps

                }
                //Return(11)
                if (currentInstruction.getBit(10).getValue() && currentInstruction.getBit(11).getValue()) {
                    SP.copy(rippleAdder.add(SP, addFour));//Add 4 Bytes to SP
                    System.out.println("Returning Stack Value: "+Memory.read(SP).getSigned()+" SP: "+SP.getSigned());
                    register[currentInstruction.leftShift(28).rightShift(28).getSigned()] = (Memory.read(SP)); //pops
                    Memory.write(SP, new Longword()); //Converts data in current SP to 0s
                    PC.copy(register[currentInstruction.leftShift(28).rightShift(28).getSigned()]);//Jumping back to address
                }

            }
            //Branch
            else if (currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()) {
                //Branch or Jump to signed address
                //If Equal,  CurrentInstruction[11] == true, and CurrentInstruction[11] == compareResult[1]
                if (currentInstruction.getBit(11).getValue() && compareResult[1].getValue()) {
                    PC = rippleAdder.add(PC, signedAddress);//Branching to Address
                    System.out.println("Branching to: " + PC.toStringConvert());
                }
                //If NotEqual, CurrentInstrution[11] == false, and CurrentInstruction[10] == compareResult[0]
                //If Greater than
                else if (!currentInstruction.getBit(11).getValue() && !compareResult[1].getValue() && currentInstruction.getBit(10).getValue() && compareResult[0].getValue()) {
                    PC = rippleAdder.add(PC, signedAddress);//Branching to Address
                    System.out.println("Branching to: " + PC.toStringConvert());
                }
                //If less than
                else if (!currentInstruction.getBit(11).getValue() && !compareResult[1].getValue() && !currentInstruction.getBit(10).getValue() && !compareResult[0].getValue()) {
                    PC = rippleAdder.add(PC, signedAddress);//Branching to Address
                    System.out.println("Branching to: " + PC.toStringConvert());
                }
                //Else, Don't Branch or Jump
            }
            //Jump Instruction(0011)
            else if (currentInstruction.getBit(12).getValue() && currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()) {
                PC.copy(currentInstruction.leftShift(20).rightShift(20));//Gets the address value to jump to
                System.out.println("Jumping to Address: " + currentInstruction.leftShift(20).rightShift(20).toStringConvert());
            }//If compare instruction
            else if (!currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()) {
                //Bit 0: (Negative)0 ifLessThan, (Positive)1 ifGreaterThan ; either one if equal
                if (result.getSigned() < 0) compareResult[0].set(false);
                else if (result.getSigned() > 0) compareResult[0].set(true);
                //Bit 1: 0 if not equal, 1 if equal
                if (result.getSigned() != 0) compareResult[1].set(false);
                else compareResult[1].set(true);
            }
            //If move instruction
            else if (currentInstruction.getBit(12).getValue() && !currentInstruction.getBit(13).getValue() && !currentInstruction.getBit(14).getValue() && !currentInstruction.getBit(15).getValue()) {
                register[currentInstruction.leftShift(20).rightShift(28).and(mask).getSigned()] = result;
            } else { //If other Instruction
                register[currentInstruction.leftShift(28).rightShift(28).and(mask).getSigned()] = result;//Left Shift by 24, Right shift by 28 bits, then and with mask to get second register
            }
        }
    }

    public void preload(String program[]) {
        Longword hold = new Longword(); //Holds the instructions
        int numInstructions = program.length;//Gives us number of instructions
        addTwo.setBit(4, bitTrue); //Adds 16 Bits, 2 Bytes for PC
        addFour.setBit(5, bitTrue); //Adds 32 Bits, 4 Bytes for SP
        int biti = 0;
        for (int j = 0; j < numInstructions; j++) {
            biti = 0;
            program[j] = program[j].replaceAll("\\s", "");//Gets rid of white spaces from program strings
            for (int i = 15; i >= 0; i--) {//Copies each instruction into hold
                if (program[j].charAt(i) == '0') hold.setBit(biti, bitFalse);
                if (program[j].charAt(i) == '1') hold.setBit(biti, bitTrue);
                biti++;
            }
            Memory.write(preloadAddressTrack, hold);
            preloadAddressTrack = rippleAdder.add(preloadAddressTrack, addTwo);//Increases address by 2 Bytes
            //Preloading address if Call and Return are called
            // If Call(011010)
            if (!hold.getBit(15).getValue() && hold.getBit(14).getValue() && hold.getBit(13).getValue()
                    && !hold.getBit(12).getValue() && hold.getBit(11).getValue() && !hold.getBit(10).getValue()) {//Call
                returnAddress.copy(preloadAddressTrack);
//                System.out.println("Call:"+preloadAddressTrack.getSigned()); //Testing
                preloadAddressTrack.copy(hold.leftShift(22).rightShift(22));//Preload jumps to the address indicated by call
            }

            //If Return(011011)
            if (!hold.getBit(15).getValue() && hold.getBit(14).getValue() && hold.getBit(13).getValue()
                    && !hold.getBit(12).getValue() && hold.getBit(11).getValue() && hold.getBit(10).getValue()) {
//                System.out.println("Return:"+preloadAddressTrack.getSigned()); //Testing
                preloadAddressTrack= returnAddress;
            }


        }

    }
}

