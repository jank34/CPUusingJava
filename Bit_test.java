 package ComputerArchitecture;
/*
Jan Karl Galia
Comp. Architecture
HW 1: The Bit 
*/
public class Bit_test{
    public static void main(String args[]){
        runTests();
    }
    public static void runTests(){
        testSet();
        testToggle();
        testSet2();
        testClear();
        testGetValue();
        testAnd();
        testOr();
        testXor();
        testNot();
        testToString();
    }
    public static void testSet(){//#1
       new Bit().set(true);
        new Bit().set(false);
    }
    public static void testToggle(){//#2
        new Bit().toggle();
    }
    public static void testSet2(){//#3
        new Bit().set();
    }
    public static void testClear(){//#4
        new Bit().clear();
    }
    public static void testGetValue(){//#5
        System.out.println("GetValue:"+ new Bit(0).getValue());
    }
    public static void testAnd(){//#6
            System.out.println("0 AND 0:"+ new Bit(0).and(new Bit(0)).getValue());
            System.out.println("0 AND 1:"+ new Bit(0).and(new Bit(1)).getValue());
            System.out.println("1 AND 1:"+ new Bit(1).and(new Bit(1)).getValue());
            System.out.println("1 AND 0:"+ new Bit(1).and(new Bit(0)).getValue());
    }
    public static void testOr(){//#7
            System.out.println("0 OR 0:"+ new Bit(0).or(new Bit(0)).getValue());
            System.out.println("0 OR 1:"+ new Bit(0).or(new Bit(1)).getValue());
            System.out.println("1 OR 1:"+ new Bit(1).or(new Bit(1)).getValue());
            System.out.println("1 OR 0:"+ new Bit(1).or(new Bit(0)).getValue());
    }
    public static void testXor(){//#8
            System.out.println("0 XOR 0:"+ new Bit(0).xor(new Bit(0)).getValue());
            System.out.println("0 XOR 1:"+ new Bit(0).xor(new Bit(1)).getValue());
            System.out.println("1 XOR 1:"+ new Bit(1).xor(new Bit(1)).getValue());
            System.out.println("1 XOR 0:"+ new Bit(1).xor(new Bit(0)).getValue());
    }
    public static void testNot(){//#9
            System.out.println("NOT 0:" + new Bit(0).not().getValue());
            System.out.println("NOT 1:" + new Bit(1).not().getValue());
    }
    public static void testToString(){//#10
            System.out.println("ToStringOfFalse:"+new Bit(0).toString());
            System.out.println("ToSTringOfTrue:"+ new Bit(1).toString());
        }
    
}
 