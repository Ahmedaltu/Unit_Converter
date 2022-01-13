package fi.ahmedalt.team2_unitconverter.convert;
import java.text.NumberFormat;

public class TemperatureConverter implements Converter {
    double f;
    double k;

    private double beg_qty;
    private double end_qty;
    private String beg_type;
    private String end_type;

    public TemperatureConverter() {
        beg_qty = 0;
        end_qty = 0;
        beg_type = "";
        end_type = "";
    }

    public double getBeg_qty() {
        return beg_qty;
    }

    public double getEnd_qty() {
        return end_qty;
    }

    public String getBeg_type() {
        return beg_type;
    }

    public String getEnd_type() {
        return end_type;
    }

    public void setBeg_qty(double beg_qty) {
        this.beg_qty = beg_qty;
    }

    public void setEnd_qty(double end_qty) {
        this.end_qty = end_qty;
    }

    public void setBeg_type(String beg_type) {
        this.beg_type = beg_type;
    }

    public void setEnd_type(String end_type) {
        this.end_type = end_type;
    }

    public double getUnitTypeConstant (String arrayList_temperature ){

        if(arrayList_temperature.equals("Celsius")) {
            return  1.0;
        }
        if(arrayList_temperature.equals("Fahrenheit")) {
            return  (f-32)* 5/9 ;
        }
        if(arrayList_temperature.equals("Kelvin")) {
            return k - 273.15;
        }
        return 0.0;
    }
    public double calculateEnd_qty(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                end_qty = beg_qty * beg_unit_type;
            }
            if (end_unit_type ==  (f-32)* 5/9){
                end_qty = (beg_qty * 9/5 ) + 32;
            }
            if(end_unit_type ==  k - 273.15){
                end_qty = beg_qty + 273.15;
            }
            return end_qty;

        }
        if(beg_unit_type == (f-32)* 5/9) {
            if(end_unit_type ==  1.0 ){
                end_qty = (beg_qty - 32) * 5 / 9;
            }
            if(end_unit_type ==  (f-32)* 5/9 ) {
                end_qty = beg_qty ;
            }
            if(end_unit_type ==  k - 273.15){
                end_qty = (beg_qty - 32) * 5 / 9 + 273.15;
            }
            return end_qty;
        }

 
        if(beg_unit_type == k - 273.15 ){
            if(end_unit_type ==  k - 273.15){
                end_qty = beg_qty ;
            }
            if(end_unit_type ==  1.0 ){
                end_qty = beg_qty - 273.15 ;
            }
            if(end_unit_type ==  (f-32)* 5/9) {
                end_qty = (beg_qty - 273.15) *  9/5 + 32 ;
            }
            return end_qty;           
        }
        return beg_qty;
    }
    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if (end_type.equals("Celsius") || end_type.equals("Fahrenheit") || end_type.equals("Kelvin")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(2);
        }
        return nf.format(getEnd_qty());
    }

    @Override
    public String shortName() {
        return "temperature";
    }

    public String usedFormulaMeth(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());


        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " C "+ " = " + toString() + " C");
                return s;
            }
            if (end_unit_type ==  (f-32)* 5/9){
                final String s = ("("+beg_qty + "C" + " * " + "9/5"+ ") " + "+ " + 32 + " = " + toString() + " F");
                return s;

            }
            if(end_unit_type ==  k - 273.15){
                final String s = (beg_qty  + " + " + 273.15 + " = " + toString() + " K");
                return s;
            }


        }
        if(beg_unit_type == (f-32)* 5/9) {
            if(end_unit_type ==  1.0 ){
                final String s = ("("+beg_qty + "F" + " - " + "32"+ ") " + "* " + "5/9" + " = " + toString() + " C");
                return s;
            }
            if(end_unit_type ==  (f-32)* 5/9 ) {
                final String s = (beg_qty + " F "+ " = " + toString() + " F");
                return s;
            }
            if(end_unit_type ==  k - 273.15){
                final String s = ("("+beg_qty + "F" + " - " + "32"+ ") " + "* " + "5/9" + "+" + "273.15" + " = " + toString() + " K");
                return s;
            }

        }


        if(beg_unit_type == k - 273.15 ){
            if(end_unit_type ==  k - 273.15){
                final String s = (beg_qty + " K "+ " = " + toString() + " K");
                return s;
            }
            if(end_unit_type ==  1.0 ){
                final String s = (beg_qty  + " - " + 273.15 + " = " + toString() + " C");
                return s;
            }
            if(end_unit_type ==  (f-32)* 5/9) {
                final String s = ("("+beg_qty + "K" + " - " + "273.15"+ ") " + "* " + "9/5" + " + " + 32 +" = " + toString() + " F");
                return s;
            }

        }


        return null;
    }
}
