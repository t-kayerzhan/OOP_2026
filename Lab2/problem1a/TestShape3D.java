package problem1a;

public class TestShape3D {
    public static void main(String[] args) {
        Shape3D cylinder = new Cylinder(2.0, 5.0);
        Shape3D sphere = new Sphere(3.0);
        Shape3D cube = new Cube(4.0);

        System.out.println("Cylinder: volume = " + cylinder.volume() + ", surface area = " + cylinder.surfaceArea());
        System.out.println("Sphere: volume = " + sphere.volume() + ", surface area = " + sphere.surfaceArea());
        System.out.println("Cube: volume = " + cube.volume() + ", surface area = " + cube.surfaceArea());
    }
}
