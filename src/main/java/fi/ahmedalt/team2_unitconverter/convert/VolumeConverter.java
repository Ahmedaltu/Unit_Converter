package fi.ahmedalt.team2_unitconverter.convert;

import java.text.NumberFormat;


public class VolumeConverter implements Converter {
    final double liter = 1.0;
    final double cubicFoot = 0.0353146667;
    final double cubicInch = 61.0237441;
    final double cubicMeter = 0.001;

    private double beg_qty;
    private double end_qty;
    private String beg_type;
    private String end_type;

    public VolumeConverter(){
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

    public double getUnitTypeConstant(String arrayList_volume){
        if(arrayList_volume.equals("Liter")){return liter;}
        if(arrayList_volume.equals("Cubic foot")){return cubicFoot;}
        if(arrayList_volume.equals("Cubic inch")){return cubicInch;}
        if(arrayList_volume.equals("Cubic meter")){return cubicMeter;}
        return 0;
    }

    public double calculateEnd_qty(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        end_qty = liter / beg_unit_type;
        end_qty = end_qty * end_unit_type;
        end_qty = end_qty * beg_qty;

        return end_qty;
    }

    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        if (end_type.equals("Cubic foot") || end_type.equals("Cubic inch") || end_type.equals("Cubic meter")) {
            nf.setMaximumFractionDigits(2);
        }else {
            nf.setMaximumFractionDigits(4);
        }
        return nf.format(getEnd_qty());
    }

    @Override
    public String shortName() {
        return "volume";
    }

    public String usedFormulaMeth(){
        double beg_qty = getBeg_qty();
        double beg_unit_type = getUnitTypeConstant(getBeg_type());
        double end_unit_type = getUnitTypeConstant(getEnd_type());

        if(beg_unit_type == 1.0){
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " L "+" = " + toString() + " L");
                return s;
            }
            if(end_unit_type == 0.0353146667){
                final String s = (beg_qty + " L "+" = " + toString() + " ft??");
                return s;
            }
            if(end_unit_type == 61.0237441){
                final String s = (beg_qty + " L "+" = " + toString() + " in??");
                return s;
            }
            if(end_unit_type == 0.001){
                final String s = (beg_qty + " L "+" = " + toString() + " m??");
                return s;
            }
        }

        if(beg_unit_type == 0.0353146667){
            if(end_unit_type == 0.0353146667){
                final String s = (beg_qty + " ft?? "+" = " + toString() + " ft??");
                return s;
            }
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " ft?? "+" = " + toString() + " L");
                return s;
            }
            if(end_unit_type == 61.0237441){
                final String s = (beg_qty + " ft?? "+" = " + toString() + " in??");
                return s;
            }
            if(end_unit_type == 0.001){
                final String s = (beg_qty + " ft?? "+" = " + toString() + " m??");
                return s;
            }
        }

        if(beg_unit_type == 61.0237441){
            if(end_unit_type == 61.0237441){
                final String s = (beg_qty + " in?? "+" = " + toString() + " in??");
                return s;
            }
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " in?? "+" = " + toString() + " L");
                return s;
            }
            if(end_unit_type == 0.0353146667){
                final String s = (beg_qty + " in?? "+" = " + toString() + " ft??");
                return s;
            }
            if(end_unit_type == 0.001){
                final String s = (beg_qty + " in?? "+" = " + toString() + " m??");
                return s;
            }
        }

        if(beg_unit_type == 0.001){
            if(end_unit_type == 0.001){
                final String s = (beg_qty + " m?? "+" = " + toString() + " m??");
                return s;
            }
            if(end_unit_type == 1.0){
                final String s = (beg_qty + " m?? "+" = " + toString() + " L");
                return s;
            }
            if(end_unit_type == 0.0353146667){
                final String s = (beg_qty + " m?? "+" = " + toString() + " ft??");
                return s;
            }
            if(end_unit_type == 61.0237441){
                final String s = (beg_qty + " m?? "+" = " + toString() + " in??");
                return s;
            }
        }
        
        return null;

    }

}
