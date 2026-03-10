package week2_questions;

public class ParkingLot {

    String[] table;
    int size;

    public ParkingLot(int size){
        this.size=size;
        table=new String[size];
    }

    int hash(String plate){
        return Math.abs(plate.hashCode())%size;
    }

    public int park(String plate){

        int index = hash(plate);

        while(table[index]!=null){
            index=(index+1)%size;
        }

        table[index]=plate;

        return index;
    }
}