package ComputerArchitecture;

import java.util.StringTokenizer;

/*
Jan Karl Galia
Comp. Architecture
HW 8: Assembler
*/
public class Assembler {
    public static String[] assemble(String[] strings) {
        int numStrings = strings.length;
        StringBuilder[] result = new StringBuilder[numStrings]; //StringBuilder for easy appending and inserting of strings
        String resultString[] = new String[numStrings];
        String nextToken = new String(); //Keeps track of the nextToken string
        Longword addOne = new Longword();
        Bit bitTrue = new Bit(1);
        String opCode = new String(); //Keeps track of each opcode in each instruction
        addOne.setBit(0, bitTrue);
        for (int i = 0; i < numStrings; i++) {//Decodes every instruction
            StringTokenizer st = new StringTokenizer(strings[i]); //Tokenizes String, 1 token = 1 term before white space
            int trackNumInstruction = 0; //Tracks the iterations of for loop
            result[i] = new StringBuilder();
            resultString[i] = new String();
            opCode = new String();
            while (st.hasMoreTokens()) {// Iterates until no more tokens
                nextToken = st.nextToken(); //Grabs the next string token
                switch (nextToken) {
                    case "halt":
                        result[i].append("0000000000000000");
                        break;
                    case "move":
                        result[i].append("0001");
                        opCode = "0001";
                        break;
                    case "interrupt":
                        result[i].append("0010");
                        opCode = "0010";
                        break;
                    case "and":
                        result[i].append("1000");
                        break;
                    case "or":
                        result[i].append("1001");
                        break;
                    case "xor":
                        result[i].append("1010");
                        break;
                    case "not":
                        result[i].append("1011");
                        opCode = opCode + "1011";
                        break;
                    case "multiply":
                        result[i].append("0111");
                        break;
                    case "leftshift":
                        result[i].append("1100");
                        break;
                    case "rightshift":
                        result[i].append("1101");
                        break;
                    case "add":
                        result[i].append("1110");
                        break;
                    case "subtract":
                        result[i].append("1111");
                        break;
                    case "jump":
                        result[i].append("0011");
                        opCode = "0011";
                        break;
                        //Branch appends "opCode and CC"
                    case "BranchifEqual":
                        result[i].append("010110");
                        opCode = "0101";
                        break;
                    case "BranchifNotEqual":
                        result[i].append("010100");
                        opCode = "0101";
                        break;
                    case "BranchifLessThan":
                        result[i].append("010100");
                        opCode = "0101";
                        break;
                    case "BranchifGreaterThan":
                        result[i].append("010101");
                        opCode = "0101";
                        break;
                        //Assignment 10
                    case "call":
                        result[i].append("011010");
                        opCode = "011010";
                        break;
                    case "push":
                        result[i].append("011000");
                        opCode = "011000";
                        break;
                    case "pop":
                        result[i].append("011001");
                        opCode = "011001";
                        break;
                    case "return":
                        result[i].append("0110110000000000");
                        break;
                        //Assignment 10
                    case "compare":
                        result[i].append("0100");
                        opCode = "0100";
                        break;
                    case "R0":
                        result[i].append("0000");
                        break;
                    case "R1":
                        result[i].append("0001");
                        break;
                    case "R2":
                        result[i].append("0010");
                        break;
                    case "R3":
                        result[i].append("0011");
                        break;
                    case "R4":
                        result[i].append("0100");
                        break;
                    case "R5":
                        result[i].append("0101");
                        break;
                    case "R6":
                        result[i].append("0110");
                        break;
                    case "R7":
                        result[i].append("0111");
                        break;
                    case "R8":
                        result[i].append("1000");
                        break;
                    case "R9":
                        result[i].append("1001");
                        break;
                    case "R10":
                        result[i].append("1010");
                        break;
                    case "R11":
                        result[i].append("1011");
                        break;
                    case "R12":
                        result[i].append("1100");
                        break;
                    case "R13":
                        result[i].append("1101");
                        break;
                    case "R14":
                        result[i].append("1110");
                        break;
                    case "R15":
                        result[i].append("1111");
                        break;
                    default: //Case if integer value, for move instruction
                        int value = Integer.parseInt(nextToken);// String Integer to Integer value
                        Longword valueWord = new Longword();
                        if (value < 0) {
                            valueWord.set(Math.abs(value));//Only gets the number, not the sign
                            valueWord = new rippleAdder().add(valueWord.not(), addOne);//Converting to 2s complement
                        } else valueWord.set(value);//Positive
                        if (opCode.equals("0001")) { //If move
                            for (int j = 7; j >= 0; j--) {//Converting t,f to string of 1,0
                                if (valueWord.getBit(j).getValue())
                                    result[i].append('1');
                                if (!valueWord.getBit(j).getValue())
                                    result[i].append('0');
                            }
                        }
                        if (opCode.equals("0011")) { //If jump
                            for (int j = 11; j >= 0; j--) {//Converting t,f to string of 1,0
                                if (valueWord.getBit(j).getValue())
                                    result[i].append('1');
                                if (!valueWord.getBit(j).getValue())
                                    result[i].append('0');
                            }
                        }
                        if (opCode.equals("0101")) { //If branch
                            for (int j = 9; j >= 0; j--) {//Converting t,f to string of 1,0
                                if (valueWord.getBit(j).getValue())
                                    result[i].append('1');
                                if (!valueWord.getBit(j).getValue())
                                    result[i].append('0');
                            }
                        }
                        if(opCode.equals("0010")){//If interupt
                            if(nextToken.equals("0"))
                            result[i].insert(4,"000000000000");
                            if(nextToken.equals("1"))
                                result[i].insert(4,"000000000001");
                        }
                        if(opCode.equals("011010")){//If Call
                            for (int j = 9; j >= 0; j--) {//Converting t,f to string of 1,0
                                if (valueWord.getBit(j).getValue())
                                    result[i].append('1');
                                if (!valueWord.getBit(j).getValue())
                                    result[i].append('0');
                            }
                        }
                        break;
                }
                trackNumInstruction++;
            }
            //If instruction code has less than 4 parts, fill instruction code with 0s (not)
            if (trackNumInstruction < 4) {
                if (opCode.equals("1011")) { //If not "Opcode, Register, 0000, Register Destination"
                    result[i].insert(8, "0000");
                }
                if(opCode.equals("0100")){//If compare "Opcode, 0000, Register1, Register2"
                    result[i].insert(4,"0000");
                }
                if(opCode.equals("011000")){//If Push
                    result[i].insert(6,"000000");
                }
                if(opCode.equals("011001")){//If Pop
                    result[i].insert(6,"000000");
                }

            }
            resultString[i] = result[i].toString(); //Converting Stringbuilder to String
//            System.out.println(resultString[i]);
        }
        return resultString;
    }
}
