package fi.ahmedalt.team2_unitconverter.convert;

import java.text.NumberFormat;

public class AngleConverter implements Converter {
    final double degree = 1;
    final double radian = 0.0174533;

    private double beg_qty;
    private double end_qty;
    private String beg_type;
    private String end_type;

    public AngleConverter() {
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

    public double getUnitTypeConstant (String arrayList_angle){

        if(arrayList_angle.equals("Degree")) {return degree;}
        if(arrayList_angle.equals("Radian")) {return radian;}
        return 0;
    }

    public double calculateEnd_qty(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        end_qty = degree / beg_unit_type;

        end_qty = end_qty * end_unit_type;
        end_qty = end_qty * beg_qty ;

        return end_qty;

    }
    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if (end_type.equals("Degree") ) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getEnd_qty());
    }

    @Override
    public String shortName() {
        return "angle";
    }

    public String usedFormulaMeth(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());


        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " ° "+ " = " + toString() + " °");
                return s;
            }
            if (end_unit_type ==  0.0174533){
                final String s = (beg_qty + "°" + " * " + "π/180" +  " = " + toString() + " rad");
                return s;

            }
        }
        if(beg_unit_type == 0.0174533){
            if(end_unit_type ==  0.0174533){
                final String s = (beg_qty + " rad "+ " = " + toString() + " rad");
                return s;
            }
            if(end_unit_type ==  1.0) {
                final String s = (beg_qty + " rad "+" * " + " 180/π "+ " = " + toString() + " °");
                return s;
            }

        }

        return null;
    }
}
