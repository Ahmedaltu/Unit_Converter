package fi.ahmedalt.team2_unitconverter.convert;

import java.text.NumberFormat;


public class MassConverter implements Converter {
    final double kilogram = 1.0;
    final double gram = 1000.0;
    final double pound = 2.20462262;
    final double ounce = 35.2739619;

    private double beg_qty;
    private double end_qty;
    private String beg_type;
    private String end_type;

    public MassConverter(){
        beg_qty = 0;
        end_qty = 0;
        beg_type = "";
        end_type = "";
    }

    public double getBeg_qty() { return beg_qty; }
    public void setBeg_qty(double beg_qty) { this.beg_qty = beg_qty; }
    public double getEnd_qty() { return end_qty; }
    public void setEnd_qty(double end_qty) { this.end_qty = end_qty; }
    public String getBeg_type() { return beg_type; }
    public void setBeg_type(String beg_type) { this.beg_type = beg_type; }
    public String getEnd_type() { return end_type; }
    public void setEnd_type(String end_type) { this.end_type = end_type; }

    public double getUnitTypeConstant (String arrayList_mass){
        if(arrayList_mass.equals("Kilogram")){ return kilogram; }
        if(arrayList_mass.equals("Gram")){return gram;}
        if(arrayList_mass.equals("Pound")){return pound;}
        if(arrayList_mass.equals("Ounce")){return ounce;}
        return 0;
    }

    public double calculateEnd_qty(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        end_qty = kilogram / beg_unit_type;
        end_qty = end_qty * end_unit_type;
        end_qty = end_qty * beg_qty;

        return end_qty;
    }

    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if (end_type.equals("Gram") || end_type.equals("Pound") || end_type.equals("Ounce")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getEnd_qty());
    }

    @Override
    public String shortName() {
        return "mass";
    }

    public String usedFormulaMeth(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " Kg "+" = " + toString() + " Kg");
                return s;
            }
            if(end_unit_type == 1000.0){
                final String s = (beg_qty + " Kg "+" = " + toString() + " G");
                return s;
            }
            if(end_unit_type == 2.20462262){
                final String s = (beg_qty + " Kg "+" = " + toString() + " P");
                return s;
            }
            if(end_unit_type == 35.2739619){
                final String s = (beg_qty + " Kg "+" = " + toString() + " O");
                return s;
            }
        }

        if(beg_unit_type == 1000.0){
            if(end_unit_type == 1000.0){
                final String s = (beg_qty + " G "+" = " + toString() + " G");
                return s;
            }
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " G "+" = " + toString() + " Kg");
                return s;
            }
            if(end_unit_type == 2.20462262){
                final String s = (beg_qty + " G "+" = " + toString() + " P");
                return s;
            }
            if(end_unit_type == 35.2739619){
                final String s = (beg_qty + " G "+" = " + toString() + " O");
                return s;
            }
        }

        if(beg_unit_type == 2.20462262){
            if(end_unit_type == 2.20462262){
                final String s = (beg_qty + " P "+" = " + toString() + " P");
                return s;
            }
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " P "+" = " + toString() + " Kg");
                return s;
            }
            if(end_unit_type == 1000.0){
                final String s = (beg_qty + " P "+" = " + toString() + " G");
                return s;
            }
            if(end_unit_type == 35.2739619){
                final String s = (beg_qty + " P "+" = " + toString() + " O");
                return s;
            }
        }

        if(beg_unit_type == 35.2739619){
            if(end_unit_type == 35.2739619){
                final String s = (beg_qty + " O "+" = " + toString() + " O");
                return s;
            }
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " O "+" = " + toString() + " Kg");
                return s;
            }
            if(end_unit_type == 1000.0){
                final String s = (beg_qty + " O "+" = " + toString() + " G");
                return s;
            }
            if(end_unit_type == 2.20462262){
                final String s = (beg_qty + " O "+" = " + toString() + " P");
                return s;
            }
        }

        return null;
    }

}
