package fi.ahmedalt.team2_unitconverter.convert;

import java.text.NumberFormat;

import fi.ahmedalt.team2_unitconverter.convert.Converter;

public class LengthConverter implements Converter {
    final double meters = 1.0;
    final double inches = 39.3701;
    final double feet = 3.28084;
    final double miles = 0.000621371;
    final double yards = 1.09361;

    private double beg_qty;
    private double end_qty;
    private String beg_type;
    private String end_type;

    public LengthConverter(){
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
        if(arrayList_length.equals("Meter")) {return meters;}
        if(arrayList_length.equals("Inch")) {return inches;}
        if(arrayList_length.equals("Foot")) {return feet;}
        if(arrayList_length.equals("Mile")) {return miles;}
        if(arrayList_length.equals("Yard")) {return yards;}
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
        return "length";
    }

    public String usedFormulaMeth(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());


        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " M "+" = " + toString() + " M");
                return s;
            }
            if (end_unit_type ==  39.3701){
                final String s = (beg_qty + "M" + " * " + "39.37" +  " = " + toString() + " In");
                return s;

            }
            if (end_unit_type ==  3.28084){
                final String s = (beg_qty + "M" + " * " + "3.28" +  " = " + toString() + " Ft");
                return s;

            }
            if (end_unit_type ==  0.000621371){
                final String s = (beg_qty + "M" + " / " + "1609" +  " = " + toString() + " Mi");
                return s;

            }
            if (end_unit_type ==  1.09361){
                final String s = (beg_qty + "M" + " * " + "1.093" +  " = " + toString() + " Yard");
                return s;

            }
        }

        if(beg_unit_type == 39.3701){
            if(end_unit_type == 39.3701){
                final String s = (beg_qty + " In "+" = " + toString() + " In");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "In" + " / " + "39.37" +  " = " + toString() + " M");
                return s;

            }
            if (end_unit_type ==  3.28084){
                final String s = (beg_qty + "In" + " / " + "12" +  " = " + toString() + " Ft");
                return s;

            }
            if (end_unit_type ==  0.000621371){
                final String s = (beg_qty + "In" + " / " + "63360" +  " = " + toString() + " Mi");
                return s;

            }
            if (end_unit_type ==  1.09361){
                final String s = (beg_qty + "In" + " / " + "0.0277" +  " = " + toString() + " Yard");
                return s;

            }
        }
        if(beg_unit_type == 3.28084){
            if(end_unit_type == 3.28084){
                final String s = (beg_qty + " Ft "+" = " + toString() + " Ft");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Ft" + " / " + "3.281" +  " = " + toString() + " M");
                return s;

            }
            if (end_unit_type ==  39.3701){
                final String s = (beg_qty + "Ft" + " * " + "12" +  " = " + toString() + " In");
                return s;

            }
            if (end_unit_type ==  0.000621371){
                final String s = (beg_qty + "Ft" + " / " + "5280" +  " = " + toString() + " Mi");
                return s;

            }
            if (end_unit_type ==  1.09361){
                final String s = (beg_qty + "Ft" + " / " + "3" +  " = " + toString() + " Yard");
                return s;

            }
        }
        if(beg_unit_type == 0.000621371){
            if(end_unit_type == 0.000621371){
                final String s = (beg_qty + " Mi "+" = " + toString() + " Mi");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Mi" + " * " + "1609" +  " = " + toString() + " M");
                return s;

            }
            if (end_unit_type ==  39.3701){
                final String s = (beg_qty + "Mi" + " * " + "63360" +  " = " + toString() + " In");
                return s;

            }
            if (end_unit_type ==  3.28084){
                final String s = (beg_qty + "Mi" + " * " + "5280" +  " = " + toString() + " Ft");
                return s;

            }
            if (end_unit_type ==  1.09361){
                final String s = (beg_qty + "Mi" + " * " + "1760" +  " = " + toString() + " Yard");
                return s;

            }
        }
        if(beg_unit_type == 1.09361){
            if(end_unit_type == 1.09361){
                final String s = (beg_qty + " Yard "+" = " + toString() + " Yard");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Yard" + " / " + "1.094" +  " = " + toString() + " M");
                return s;

            }
            if (end_unit_type ==  39.3701){
                final String s = (beg_qty + "Yard" + " * " + "36" +  " = " + toString() + " In");
                return s;

            }
            if (end_unit_type ==  3.28084){
                final String s = (beg_qty + "Yard" + " * " + "3" +  " = " + toString() + " FT");
                return s;

            }
            if (end_unit_type ==  0.000621371){
                final String s = (beg_qty + "Yard" + " / " + "1760" +  " = " + toString() + " Mi");
                return s;

            }
        }

        return null;
    }
}
