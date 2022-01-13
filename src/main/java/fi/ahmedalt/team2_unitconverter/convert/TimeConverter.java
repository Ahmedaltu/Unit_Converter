package fi.ahmedalt.team2_unitconverter.convert;

import java.text.NumberFormat;

public class TimeConverter implements Converter {
    final double day = 1.0;
    final double hour = 24.0;
    final double minute = 1440.0;
    final double second = 86400.0;

    private double beg_qty;
    private double end_qty;
    private String beg_type;
    private String end_type;

    public TimeConverter() {
        beg_qty = 0;
        end_qty = 0;
        beg_type = "";
        end_type = "";
    }

    public double getBeg_qty() {
        return beg_qty;
    }

    public void setBeg_qty(double beg_qty) {
        this.beg_qty = beg_qty;
    }

    public double getEnd_qty() {
        return end_qty;
    }

    public void setEnd_qty(double end_qty) {
        this.end_qty = end_qty;
    }

    public String getBeg_type() {
        return beg_type;
    }

    public void setBeg_type(String beg_type) {
        this.beg_type = beg_type;
    }

    public String getEnd_type() {
        return end_type;
    }

    public void setEnd_type(String end_type) {
        this.end_type = end_type;
    }

    public double getUnitTypeConstant (String arrayList_time){
        if(arrayList_time.equals("Day")) {return day;}
        if(arrayList_time.equals("Hour")) {return hour;}
        if(arrayList_time.equals("Minute")) {return minute;}
        if(arrayList_time.equals("Second")) {return second;}



        return 0;
    }
    public double calculateEnd_qty(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        end_qty = day / beg_unit_type;

        end_qty = end_qty * end_unit_type;
        end_qty = end_qty * beg_qty ;

        return end_qty;

    }
    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if (end_type.equals("Minute") || end_type.equals("Second")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getEnd_qty());
    }

    @Override
    public String shortName() {
        return "time";
    }


    public String usedFormulaMeth(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());


        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " Day "+" = " + toString() + " Day");
                return s;
            }
            if (end_unit_type ==  24.0){
                final String s = (beg_qty + "Day" + " * " + "24" +  " = " + toString() + " Hr");
                return s;

            }
            if (end_unit_type ==  1440.0){
                final String s = (beg_qty + "Day" + " * " + "1440" +  " = " + toString() + " Min");
                return s;

            }
            if (end_unit_type ==  86400.0){
                final String s = (beg_qty + "Day" + " * " + "86400" +  " = " + toString() + " Sec");
                return s;

            }
        }

        if(beg_unit_type == 24.0){
            if(end_unit_type == 24.0){
                final String s = (beg_qty + " Hr "+" = " + toString() + " Hr");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Hr" + " / " + "24" +  " = " + toString() + " Day");
                return s;
            }
            if (end_unit_type ==  1440.0){
                final String s = (beg_qty + "Hr" + " * " + "60" +  " = " + toString() + " Min");
                return s;

            }
            if (end_unit_type ==  86400.0){
                final String s = (beg_qty + "Hr" + " * " + "3600" +  " = " + toString() + " Sec");
                return s;

            }
        }
        if(beg_unit_type == 1440.0){
            if(end_unit_type == 1440.0){
                final String s = (beg_qty + " Min "+" = " + toString() + " Min");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Min" + " / " + "1440" +  " = " + toString() + " Day");
                return s;

            }
            if (end_unit_type ==  24.0){
                final String s = (beg_qty + "Min" + " / " + "60" +  " = " + toString() + " Hr");
                return s;

            }
            if (end_unit_type ==  86400.0){
                final String s = (beg_qty + "Min" + " * " + "60" +  " = " + toString() + " Sec");
                return s;

            }
        }
        if(beg_unit_type == 86400.0){
            if(end_unit_type == 86400.0){
                final String s = (beg_qty + " Sec "+" = " + toString() + " Sec");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Sec" + " / " + "86400" +  " = " + toString() + " Day");
                return s;

            }
            if (end_unit_type ==  0.016667){
                final String s = (beg_qty + "Sec" + " / " + "3600" +  " = " + toString() + " Hr");
                return s;

            }
            if (end_unit_type ==  0.000278){
                final String s = (beg_qty + "Sec" + " / " + "60" +  " = " + toString() + " Min");
                return s;

            }
        }

        return null;
    }
}