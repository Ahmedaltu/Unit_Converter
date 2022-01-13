package fi.ahmedalt.team2_unitconverter.convert;

import java.text.NumberFormat;

public class SpeedConverter implements Converter {

    final double meterpersecond = 1.0;
    final double mileperhour = 2.237136;
    final double footpersecond = 3.28084;
    final double kilometerperhour = 3.6;

    private double beg_qty;
    private double end_qty;
    private String beg_type;
    private String end_type;

    public SpeedConverter(){
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

    public double getUnitTypeConstant (String arrayList_speed){
        if(arrayList_speed.equals("Meter per second")) {return meterpersecond;}
        if(arrayList_speed.equals("Mile per hour")) {return mileperhour;}
        if(arrayList_speed.equals("Foot per second")) {return footpersecond;}
        if(arrayList_speed.equals("Kilometer per hour")) {return kilometerperhour;}

        return 0;
    }
    public double calculateEnd_qty(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        end_qty = meterpersecond / beg_unit_type;

        end_qty = end_qty * end_unit_type;
        end_qty = end_qty * beg_qty ;

        return end_qty;

    }
    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if (end_type.equals("Mile per hour") || end_type.equals("Foot per second") || end_type.equals("Kilometer per hour")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getEnd_qty());
    }

    @Override
    public String shortName() {
        return "speed";
    }

    public String usedFormulaMeth(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());


        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " M/S "+" = " + toString() + " M/S");
                return s;
            }
            if (end_unit_type ==  2.237136){
                final String s = (beg_qty + "M/S" + " * " + "2.237136" +  " = " + toString() + " Mi/H");
                return s;

            }
            if (end_unit_type ==  3.28084){
                final String s = (beg_qty + "M/S" + " * " + "3.28084" +  " = " + toString() + " Ft/S");
                return s;

            }
            if (end_unit_type ==  3.6){
                final String s = (beg_qty + "M/S" + " * " + "3.6" +  " = " + toString() + " KM/H");
                return s;

            }
        }

        if(beg_unit_type == 2.237136){
            if(end_unit_type == 2.237136){
                final String s = (beg_qty + " Mi/H "+" = " + toString() + " Mi/H");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Mi/H" + " * " + "0.447" +  " = " + toString() + " M/S");
                return s;
            }
            if (end_unit_type ==  3.28084){
                final String s = (beg_qty + "Mi/H" + " * " + "1.46653" +  " = " + toString() + " Ft/S");
                return s;
            }
            if (end_unit_type ==  3.6){
                final String s = (beg_qty + "Mi/H" + " * " + "1.6092" +  " = " + toString() + " KM/H");
                return s;

            }
        }
        if(beg_unit_type == 3.28084){
            if(end_unit_type == 3.28084){
                final String s = (beg_qty + " Ft/S "+" = " + toString() + " Ft/S");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "Ft/S" + " * " + "0.3048" +  " = " + toString() + " M/S");
                return s;

            }
            if (end_unit_type ==  2.237136){
                final String s = (beg_qty + "Ft/S" + " * " + "0.681879" +  " = " + toString() + " Mi/H");
                return s;

            }
            if (end_unit_type ==  3.6){
                final String s = (beg_qty + "Ft/S" + " * " + "1.09728" +  " = " + toString() + " KM/H");
                return s;

            }
        }
        if(beg_unit_type == 3.6){
            if(end_unit_type == 3.6){
                final String s = (beg_qty + " KM/H "+" = " + toString() + " KM/H");
                return s;
            }
            if (end_unit_type ==  1.0){
                final String s = (beg_qty + "KM/H" + " * " + "0.277778" +  " = " + toString() + " M/S");
                return s;

            }
            if (end_unit_type ==  2.237136){
                final String s = (beg_qty + "KM/H" + " * " + "0.621427" +  " = " + toString() + " Mi/H");
                return s;

            }
            if (end_unit_type ==  3.28084){
                final String s = (beg_qty + "KM/H" + " * " + "0.911344" +  " = " + toString() + " Ft/S");
                return s;

            }
        }

        return null;
    }
}


