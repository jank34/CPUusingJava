package ComputerArchitecture;

/*
NAME: JAN KARL GALIA
CLASS: COMPUTER ARCHITECTURE
*/
public class Longword {
    private final Bit[] bitArray = new Bit[32]; //Creates collection of Bits of size 32

    public Longword() {
        for (int i = 0; i < 32; i++) {//Initialize all elements of array to false
            bitArray[i] = new Bit();
            bitArray[i].set(false);
        }
    }

    Bit getBit(int i) {//#1
        return bitArray[i]; //Returns the element in index of bitArray
    }

    public void setBit(int i, Bit value) {//#2
        bitArray[i].set(value.getValue()); //Sets value of the index in bitArray
    }

    public Longword and(Longword otherInput) {//#3 and two Longwords, returning a third
        Longword input = new Longword();
        for (int i = 0; i < 32; i++) {
            input.setBit(i, bitArray[i]); //Copies bitArrays contents into input bitArray
        }

        Longword output = new Longword();
        for (int i = 0; i < 32; i++) {
            output.setBit(i, input.getBit(i).and(otherInput.getBit(i)));
        }
        return output;
    }

    public Longword or(Longword otherInput) {//#4
        Longword input = new Longword();
        for (int i = 0; i < 32; i++) {
            input.setBit(i, bitArray[i]); //Copies bitArrays contents into input bitArray
        }
        Longword output = new Longword();
        Bit value = new Bit();//Input for setBit
        for (int i = 0; i < 32; i++) {
            if (input.getBit(i).or(otherInput.getBit(i)).getValue()) {//Bit input and bit otherInput result
                value.set(true);//If result is true
                output.setBit(i, value); //Places true output bitArray
            }
        }
        return output;
    }

    public Longword xor(Longword otherInput) {//#5
        Longword input = new Longword();
        for (int i = 0; i < 32; i++) {
            input.setBit(i, bitArray[i]); //Copies bitArrays contents into input bitArray
        }
        Longword output = new Longword();
        Bit value = new Bit();//Input for setBit
        for (int i = 0; i < 32; i++) {
            if (input.getBit(i).xor(otherInput.getBit(i)).getValue()) {//Bit input and bit otherInput result
                value.set(true);//If result is true
                output.setBit(i, value); //Places true output bitArray
            }
        }
        return output;
    }

    public Longword not() {//#6, negate this Longword, creating another
        Longword input = new Longword();
        for (int i = 0; i < 32; i++) {
            input.setBit(i, bitArray[i]); //Copies bitArrays contents into input bitArray
        }
        Longword output = new Longword();
        Bit value = new Bit();//Input for setBit
        for (int i = 0; i < 32; i++) {
            if (input.getBit(i).not().getValue()) {//Bit input and bit otherInput result
                value.set(true);//If result is true
                output.setBit(i, value); //Places true output bitArray
            }
        }
        return output;
    }

    public Longword rightShift(int amount) {//#7
        Longword input = new Longword();
        for (int i = 0; i < 32; i++) {
            input.setBit(i, bitArray[i]); //Copies bitArrays contents into input bitArray
        }
        Longword output = new Longword();
        Bit value = new Bit();//Input for setBit
        for (int i = 0; i < (32); i++) {//Cuts off right most bits by amount
            if (i < (32 - amount)) {
                output.setBit(i, input.getBit(i + amount)); //Sets output Bit[i] to the end of cut off
            } else {
                value.set(false);
                output.setBit(i, value);
            }
        }

        return output;
    }

    public Longword leftShift(int amount) {//#8
        Longword input = new Longword();
        for (int i = 0; i < 32; i++) {
            input.setBit(i, bitArray[i]); //Copies bitArrays contents into input bitArray
        }
        Longword output = new Longword();
        Bit value = new Bit();//Input for setBit
        for (int i = 0; i < 32; i++) {//Cuts off right most bits by amount
            if (i < (amount)) {
                value.set(false);
                output.setBit(i, value);
            } else {
                output.setBit(i, input.getBit(i - amount)); //Sets output Bit[i] to the end of cut off
            }
//            System.out.print(output.getBit(i).getValue() + ",");
        }
        return output;
    }

    @Override
    public String toString() {//#9 Converts to String of t and f, Uses the right Binary orientation
        String toString = "";
        for (int i = 31; i >= 0; i--) {
            if (bitArray[i].getValue())
                toString = toString + "t";
            else if (!bitArray[i].getValue())
                toString = toString + "f";
        }
        return toString;
    }

    public String toStringConvert() {//#10 Converts to String of 1 and 0, Uses the right Binary orientation
        String toString = "";
        for (int i = 31; i >= 0; i--) {
            if (bitArray[i].getValue()) {
                toString = toString + "1";
            } else
                toString = toString + "0";
        }
        return toString;
    }

    public long getUnsigned() {//#11 returns the value of this longword as a long
        long output = 0;
        long factor = 1;
        if (bitArray[0].getValue()) {//Base Case = true, bitArray[0] because for loop does not include base case
            output = 1;
        }
        for (int i = 1; i < 32; i++) {
            factor = factor * 2; //Keeps track of value in each binary
            if (bitArray[i].getValue())
                output = output + factor;
            if (!bitArray[i].getValue())
                output = output;
        }
        return output;
    }

    public int getSigned() {//#12 returns the value of this longword as an int
        Longword input = new Longword();
        for (int i = 0; i < 32; i++) {
            input.setBit(i, bitArray[i]);
        }
        Bit bitTrue = new Bit();//To set bit value to true
        Bit bitFalse = new Bit();//TO set bit value to false
        bitTrue.set(true);
        bitFalse.set(false);
        //Like Unsigned
        int output = 0;
        int factor = 1;
        //If most significant bit is false, then positive value
        if (!bitArray[31].getValue()) {
            if (bitArray[0].getValue()) {//Base Case = True, bitArray[0] because for loop does not include base case
                output = 1;
            }
            for (int i = 1; i < 31; i++) { //gets value until last bit
                factor = factor * 2; //Keeps track of value in each binary
                if (input.bitArray[i].getValue())
                    output = output + factor;
                if (!input.bitArray[i].getValue())
                    output = output;
            }
        }
        //If most significant bit is true, then negative value
        if (bitArray[31].getValue()) {
            if (!bitArray[0].getValue()) {//Base Case = false, bitArray[0] because for loop does not include base case
                output = 1;
            }
            for (int i = 1; i < 31; i++) { //gets value until last bit
                factor = factor * 2; //Keeps track of value in each binary
                if (!input.bitArray[i].getValue())
                    output = output + factor;
                if (input.bitArray[i].getValue())
                    output = output;
            }
            output = -(output + 1);//Negative 2s is one less than positive 2s
        }
        return output;
    }

    public void copy(Longword otherInput) {// #13 copies the values of the bits from another longword into this one
        for (int i = 0; i < 32; i++) {
            bitArray[i].set(otherInput.getBit(i).getValue());
        }
    }

    public void set(int value) {//#14 set the value of the bits of this longword (used for tests)
        Bit bitTrue = new Bit();
        bitTrue.set(true);
        int trackInt = 0; //Tracks the value of bit

        for (int i = 31; i >= 0; i--) {//Starts from end of Binary array
            trackInt = (int) (Math.pow(2, i));
            if (trackInt <= value) { //Sets output bitArray[i] to true if trackInt <= Value
                value = value - (int) (Math.pow(2, i));
                bitArray[i].set(true);
            }
        }
    }

}