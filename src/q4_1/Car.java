package q4_1;

public class Car {

    //private fields
    private String _model;
    private String _make;
    private int _year;

    //constructor
    public Car(String make, String model, int year){
    _model = model;
    _make = make;
    _year = year;
    }
    //getters
    public String getModel(){
        return _model;
    }
    public String getMake(){
        return _make;
    }
    public int getYear(){
        return _year;
    }

    //setters
    public void setModel(String model) {
        _model = model;
    }
    public void setMake(String make) {
        _make = make;
    }
    public void setYear(int year) {
        _year = year;
    }
}
