package fi.ahmedalt.team2_unitconverter;

public class Counter {
    private int valueOfCounter;

    public Counter(int initialValue){
        this.valueOfCounter = initialValue;

    }
    public void increment(){
        this.valueOfCounter++;
    }
    public void reset(){
        this.valueOfCounter = 0;
    }
    public int getValueOfCounter(){
        return this.valueOfCounter;
    }
}