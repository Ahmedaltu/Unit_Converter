package fi.ahmedalt.team2_unitconverter.convert;

import java.text.NumberFormat;

import fi.ahmedalt.team2_unitconverter.convert.Converter;


public class AreaConverter implements Converter {
    final double meters = 1.0;
    final double inches = 1550;
    final double feet = 10.7639;
    final double yards = 1.19599;

    private double beg_qty;
    private double end_qty;
    private String beg_type;
    private String end_type;

    public AreaConverter(){
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

    public double getUnitTypeConstant (String arrayList_length){
        if(arrayList_length.equals("Square meter")) {return meters;}
        if(arrayList_length.equals("Square inch")) {return inches;}
        if(arrayList_length.equals("Square foot")) {return feet;}
        if(arrayList_length.equals("Square yard")) {return yards;}
        return 0;
    }
    public double calculateEnd_qty(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        end_qty = meters / beg_unit_type;

        end_qty = end_qty * end_unit_type;
        end_qty = end_qty * beg_qty ;

        return end_qty;

    }
    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if (end_type.equals("Inches") || end_type.equals("Feet") || end_type.equals("Yards")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getEnd_qty());
    }

    @Override
    public String shortName() {
        return "area";
    }

    public String usedFormulaMeth(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());


        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " M²  "+" = " + toString() + " M²");
                return s;
            }
            if (end_unit_type ==  1550){
                final String s = (beg_qty + "M²" + " * " + "1550" +  " = " + toString() + " In²");
                return s;

            }
            if (end_unit_type ==  10.7639){
                final String s = (beg_qty + "M²" + " * " + "10.7639" +  " = " + toString() + " Ft²");
                return s;

            }

            if (end_unit_type ==  1.19599){
                final String s = (beg_qty + "M²" + " * " + "1.19599" +  " = " + toString() + " Yard²");
                return s;

            }
        }

        if(beg_unit_type == 1550){
            if(end_unit_type == 1550){
                final String s = (beg_qty + " In² "+" = " + toString() + " In²");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "In²" + " / " + "1550" +  " = " + toString() + " M²");
                return s;

            }
            if (end_unit_type ==  10.7639){
                final String s = (beg_qty + "In²" + " / " + "144" +  " = " + toString() + " Ft²");
                return s;

            }

            if (end_unit_type ==  1.19599){
                final String s = (beg_qty + "In²" + " / " + "1296" +  " = " + toString() + " Yard²");
                return s;

            }
        }
        if(beg_unit_type == 10.7639){
            if(end_unit_type == 10.7639){
                final String s = (beg_qty + " Ft² "+" = " + toString() + " Ft²");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Ft²" + " / " + "10.764" +  " = " + toString() + " M²");
                return s;

            }
            if (end_unit_type ==  1550){
                final String s = (beg_qty + "Ft²" + " * " + "144" +  " = " + toString() + " In²");
                return s;

            }

            if (end_unit_type ==  1.19599){
                final String s = (beg_qty + "Ft²" + " / " + "9" +  " = " + toString() + " Yard²");
                return s;

            }
        }
        if(beg_unit_type == 1.19599){
            if(end_unit_type == 1.19599){
                final String s = (beg_qty + " Yard² "+" = " + toString() + " Yard²");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Yard²" + " / " + "1.196" +  " = " + toString() + " M²");
                return s;

            }
            if (end_unit_type ==  1550){
                final String s = (beg_qty + "Yard²" + " * " + "1296" +  " = " + toString() + " In²");
                return s;

            }
            if (end_unit_type ==  10.7639){
                final String s = (beg_qty + "Yard²" + " * " + "9" +  " = " + toString() + " FT²");
                return s;

            }

        }

        return null;
    }
}