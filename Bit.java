package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture
HW 1: The Bit
*/
public class Bit {
    private boolean boolVal;
    private int value;//Value for Constructor 2

    public Bit() {//Default Constructor, added so it doesn't get overriden by other constructors
    }

    public Bit(int bitInput) {//Constructor 2
        value = bitInput;
        if (bitInput == 1) {
            set(true);
        }
        if (bitInput == 0) {
            set(false);
        }
    }

    public void set(boolean value) {//#1 Sets Value of the bit
        boolVal = value;
        //System.out.println("Set:"+boolVal); Uncomment to test whether set method works
    }

    public void toggle() {//#2 Changes the value from true to false or false to true
        boolVal = !boolVal;
        System.out.println("Toggle:" + boolVal);
    }

    public void set() {//#3
        boolVal = true;
        System.out.println("SetToTrue:" + boolVal);
    }

    public void clear() {//#4
        boolVal = false;
        System.out.println("Clear:" + boolVal);
    }

    public boolean getValue() {//#5
        return boolVal;
    }

    public Bit and(Bit otherInput) {//#6
        Bit inputOutput = new Bit();//Also, the input and also the output
        inputOutput.set(boolVal);
        //If any are false, then set output to false
        if (!inputOutput.getValue()) {

            inputOutput.set(false);
            return inputOutput;
        }
        if (!otherInput.getValue()) {

            inputOutput.set(false);
            return inputOutput;
        }
        //If both are true then set output to true
        if (inputOutput.getValue()) {
            if (otherInput.getValue()) {

                inputOutput.set(true);
                return inputOutput;
            }
        }
        inputOutput.set(false);//If nothing else then set output to false and return
        return inputOutput;
    }

    public Bit or(Bit otherInput) {//#7-Or-- If any are true then set inputOutput to True
        Bit inputOutput = new Bit();
        inputOutput.set(boolVal);
        if (inputOutput.getValue()) {
            inputOutput.set(true);
            return inputOutput;
        }
        if (otherInput.getValue()) {
            inputOutput.set(true);
            return inputOutput;
        }
        inputOutput.set(false);
        return inputOutput;
    }

    public Bit xor(Bit otherInput) {//#8-Xor
        Bit inputOutput = new Bit();
        inputOutput.set(boolVal);
        if (inputOutput.getValue()) {
            if (!otherInput.getValue()) {// 1 xor 0 = 1
                inputOutput.set(true);
                return inputOutput;
            }
        }
        if (otherInput.getValue()) { //0 xor 1 = 1
            if (!inputOutput.getValue()) {
                inputOutput.set(true);
                return inputOutput;
            }
        }
        inputOutput.set(false);//others = 0
        return inputOutput;

    }

    public Bit not() {//#9-not
        Bit inputOutput = new Bit(value);
        inputOutput.set(boolVal);
        if (inputOutput.getValue()) {// 1 -> 0
            inputOutput.set(false);
            boolVal= false;
            return inputOutput;
        }
        boolVal = true;
        inputOutput.set(true); // 0 -> 1

        return inputOutput;
    }

    public boolean randomBool() {//Either false or true
        int max = 1;
        int min = 0;
        boolean randomBool = false;
        int randomInt = ((int) (Math.random() * (max - min + 1) + min));
        //Test Values for otherInput
        if (randomInt == 1) {
            randomBool = true;
        }
        if (randomInt == 0) {
            randomBool = false;
        }
        return randomBool;
    }

    @Override
    public String toString() {//#10
        if (boolVal)
            return "t";
        return "f";
    }

}

