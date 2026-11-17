package problem4;

public abstract class Circuit {
    protected double v; 

    public abstract double getResistance();

    public double getPotentialDiff() {
        return v;
    }

    public abstract void applyPotentialDiff(double V);

    public double getCurrent() {
        return v / getResistance();
    }

    public double getPower() {
        return v * getCurrent();
    }
}