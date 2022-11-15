package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture
HW 4: The Multiplier
*/
public class multiplier {
    //#3 Multiplies two words, (Inputs:  a, b), (Outputs: output)
    public static Longword multiply(Longword a, Longword b) {
        Longword product = new Longword();
         // i.e : 11(Multiplicand,a) X 13(Multiplier,b) = 143(Product)
        Longword currentAccumulation = new Longword(); //Tracks current product, Initiliazed to false or 0
        Longword prevAccumulation = new Longword();
        //Loop(32 times because 32 Bits)
        for (int i = 0; i < 32; i++) {
            for(int j = 0;j<32;j++){//Current bit of multiplier(i) * 32 bits of the multiplicand(j)
            currentAccumulation.setBit(j,b.getBit(i).and(a.getBit(j)));
            }
            product = rippleAdder.add(prevAccumulation,currentAccumulation.leftShift(i));
            prevAccumulation = product; //PrevAccumulation is now set to current for the next iteration
//            System.out.println(product.toStringConvert());// Tests each result every iteration
        }
        return product;
    }
}
