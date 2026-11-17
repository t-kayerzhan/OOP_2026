package problem3;

public class Temperature {
    private double value;
    private char unit;

    public Temperature() {
        this(0, 'C');
    }

    public Temperature(char unit) {
        this(0, unit);
    }

    public Temperature(double value) {
        this(value, 'C');
    }

    public Temperature(double value, char unit) {
        this.value = value;
        if (unit == 'C' || unit == 'F') {
            this.unit = unit;
        } else {
            this.unit = 'C'; 
        }
    }

    // methods
    public double inCelsius() {
        if (unit == 'C') {
            return value;
        } else {
            return 5 * (value - 32) / 9;
        }
    }

    public double inFahrenheit() {
        if (unit == 'F') {
            return value;
        } else {
            return 9 * value / 5 + 32;
        }
    }


    
    public void setValue(double value) {
        this.value = value;
    }

    public void setUnit(char unit) {
        if (unit == 'C' || unit == 'F') {
            this.unit = unit;
        }
    }

    public void setBoth(double value, char unit) {
        this.value = value;
        if (unit == 'C' || unit == 'F') {
            this.unit = unit;
        } else {
            this.unit = 'C';
        }
    }

    public char getUnit() {
        return unit;
    }
}