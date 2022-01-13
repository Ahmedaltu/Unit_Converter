package fi.ahmedalt.team2_unitconverter.convert;

public interface Converter {
    public double getBeg_qty() ;

    public void setBeg_qty(double beg_qty) ;

    public double getEnd_qty() ;

    public void setEnd_qty(double end_qty) ;

    public String getBeg_type() ;

    public void setBeg_type(String beg_type) ;

    public String getEnd_type() ;

    public void setEnd_type(String end_type) ;

    public double calculateEnd_qty();

    public String usedFormulaMeth();

    @Override
    public String toString();

    public String shortName();


}

