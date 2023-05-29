package Task1;

public class Express extends  Train{
    {
        ParamB = PurpInd.Passenger;
        transportPurpose = "passenger transportation";
    }
    public int maxSpeed;
    public int passengerCapacity;
    public String nameOfRoute;

    public void Show(){
        super.Show();
        System.out.println("Max speed: " + maxSpeed + "   " + "passenger capacity: " + passengerCapacity + "   " + "Маршрут: " +nameOfRoute);

    }

    public Express(){
        maxSpeed = 500;
        passengerCapacity = 200;
        nameOfRoute = "Tokio - Nagasaki";

    }
}
