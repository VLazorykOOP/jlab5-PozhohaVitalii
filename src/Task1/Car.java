package Task1;

public class Car extends Transport{
    public String carBrand;

    public int weightLoadCapacityInKg;
    enum PurpInd{
        Passenger,
        Non_passenger
    }
    PurpInd paramB;
    public void Show(){
        super.Show();
        System.out.println("Brand: " +carBrand + "   " + "Load capacity: " + weightLoadCapacityInKg + "   " + "Pass/non_Pass: " + paramB);
    }
    public Car(){
        carBrand = "Volvo";
        numbOfHorsePower = 700;
        weightLoadCapacityInKg = 20000;
        paramB = PurpInd.Non_passenger;
    }
}
