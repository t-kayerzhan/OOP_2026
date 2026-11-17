package problem4;

public class Series extends Circuit {
    private Circuit c1, c2;

    public Series(Circuit a, Circuit b) {
        c1 = a;
        c2 = b;
    }

    @Override
    public double getResistance() {
        return c1.getResistance() + c2.getResistance();
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.v = V;
        double R = getResistance();
        double I = V / R; //общ ток
        double v1 = I * c1.getResistance();
        double v2 = I * c2.getResistance();
        c1.applyPotentialDiff(v1);
        c2.applyPotentialDiff(v2);
    }
}
