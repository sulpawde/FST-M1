public class Car {
    private String color;
    private String transmission;
    private int make;
    private int tyres;
    private int doors;

    public Car(){
    this.tyres = 4;
    this.doors = 4;
    }

    // Constructor to initialize tyres and doors
    public Car(String sColor, String sTransmission, int iMake) {
        this.color = sColor;
        this.transmission = sTransmission;
        this.make = iMake;
        this.tyres = 4;
        this.doors = 4;
    }

    public void setColor(String sColor) {
        this.color = sColor;
    }

    public void setTransmission(String sTransmission) {
        this.transmission = sTransmission;
    }

    public void setMake(int iMake) {
        this.make = iMake;
    }

    // Method - display car characteristics
    public void displayCharacteristics() {
        System.out.println("Car Color : " + color);
        System.out.println("Car Transmission: " + transmission);
        System.out.println("Car Make : " + make);
        System.out.println("Car Tyres : " + tyres);
        System.out.println("Car Doors : " + doors);
    }

    // Method accelarate
    public void accelarate() {
        System.out.println("Car is moving forward.");
    }

    // Method brake
    public void brake() {
        System.out.println("Car has stopped.");
    }

}
