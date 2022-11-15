package ComputerArchitecture;
/*
Jan Karl Galia
Comp. Architecture
HW 3: Ripple Adder
*/
public class rippleAdder {
    //#1 Adds two words, (Inputs:  a, b), (Outputs: output)
    public static Longword add(Longword a, Longword b) {
        Longword word = new Longword();
        //t or f, initialized to false, (carryIn, carryOut, sum, keeps track of every bit in for loop)
        Bit carry = new Bit(0);
        //Full Adder( 2 Xors, 2 Ors, 2 Ands)
        for (int i = 0; i < 32; i++) {//Full adder 32 times, add Each bit from each long word
            word.setBit(i,a.getBit(i).xor(b.getBit(i)).xor(carry));
            carry = a.getBit(i).and(b.getBit(i)).or(a.getBit(i).xor(b.getBit(i)).and(carry));
        }
        return word;
    }

    //#2 Subtracts two words, (Inputs:  a, b), (Outputs: output)
    public static Longword sub(Longword a, Longword b) {
        Longword output = new Longword();
        Longword addOne = new Longword(); //Adds one for the 2s complement
        Bit bitTrue = new Bit(1);
        addOne.setBit(0,bitTrue);
        output = add(a,add(b.not(),addOne));
        return output;
    }
}
