package ComputerArchitecture;

/*
Jan Karl Galia
Comp. Architecture
HW 5: Memory
*/
public class memory {
    private final Bit[] Memory = new Bit[8192];// 256 Address = 256 Longword = 8192 Bits
    //Address is 4 Bytes = 32 Bits = 1 Longword
    // Address 0 -> bits 0-31
    //Address 1 -> bits 8-39
    //....
    //Address 255 ->bits 8,184-8191
    public Longword read(Longword address) {
        Longword output = new Longword();
        for (int i = 0; i < 32; i++) {//Finds the address and iterates from then on 32-Bits
            if(Memory[address.getSigned() + i] == null)Memory[address.getSigned()+i] = new Bit();
            output.setBit(i, Memory[address.getSigned() + i]); //Address.getSigned() converts to signed int and access address[value]
        }
        return output;
    }

    public void write(Longword address, Longword value) {
        for(int i =0;i<32;i++){
            Memory[address.getSigned()+i] = new Bit();  //Sets new Bits targeted bits
            Memory[address.getSigned()+i].set(value.getBit(i).getValue()); //Sets the value for those target bits
        }
    }
}
