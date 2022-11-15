package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture
HW 4: The ALU
*/
public class ALU {

    public static Longword doOp(Bit[] operation, Longword a, Longword b) {
        Longword result = new Longword();
        Longword mask = new Longword();//1111, masking with b to get 5 bit int value for shifting
        Bit bitTrue = new Bit(1); //True Bit
        for (int i = 0; i < 4; i++) {
            mask.setBit(i, bitTrue);
        }
        if (operation[0].getValue() && !operation[1].getValue() && !operation[2].getValue() && !operation[3].getValue()
        ) {//and
            result = a.and(b);
        } else if (operation[0].getValue() && !operation[1].getValue() && !operation[2].getValue() && operation[3].getValue()) {//or
            result = a.or(b);
        } else if (operation[0].getValue() && !operation[1].getValue() && operation[2].getValue() && !operation[3].getValue()) {//xor
            result = a.xor(b);
        } else if (operation[0].getValue() && !operation[1].getValue() && operation[2].getValue() && operation[3].getValue()) {//not
            result = a.not();
        } else if (operation[0].getValue() && operation[1].getValue() && !operation[2].getValue() && !operation[3].getValue()) {//left shift
            System.out.println("Left Shift Amount:" + b.and(mask).getSigned());
            result = a.leftShift(b.and(mask).getSigned());// b.and(mask).getSigned() gets the 5 bit value for shifting
        } else if (operation[0].getValue() && operation[1].getValue() && !operation[2].getValue() && operation[3].getValue()) {//right shift
            System.out.println("Right Shift Amount:" + b.and(mask).getSigned());
            result = a.rightShift(b.and(mask).getSigned());
        } else if (operation[0].getValue() && operation[1].getValue() && operation[2].getValue() && !operation[3].getValue()) {//add
            result = rippleAdder.add(a, b);
        } else if (operation[0].getValue() && operation[1].getValue() && operation[2].getValue() && operation[3].getValue()) {//subtract
            result = rippleAdder.sub(a, b);
        } else if (!operation[0].getValue() && operation[1].getValue() && operation[2].getValue() && operation[3].getValue()) {//multiply
            result = multiplier.multiply(a, b);
        }
        return result;
    }
}
