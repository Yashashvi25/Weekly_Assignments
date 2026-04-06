public class ParkingLot {
    static String[] slots=new String[10];

    static int hash(String plate){
        return Math.abs(plate.hashCode())%slots.length;
    }

    static void park(String p){
        int i=hash(p);
        while(slots[i]!=null){
            i=(i+1)%slots.length;
        }
        slots[i]=p;
        System.out.println("Parked at "+i);
    }

    public static void main(String[] args){
        park("ABC");
        park("XYZ");
    }
}