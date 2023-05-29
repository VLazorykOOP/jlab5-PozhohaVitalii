package Task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;

public abstract class TransportAbstract implements Serializable {
    public enum typeOfSpace{
        Air,
        Water,
        Ground,
        underGround
    };
    public int numbOfHorsePower;
    public Transport.typeOfSpace paramA;
    public String transportPurpose;
    public abstract void Show();
    public TransportAbstract(){
        transportPurpose  = "passenger transportation";
        paramA = Transport.typeOfSpace.Ground;
        numbOfHorsePower = 250;
    }

    public TransportAbstract(int numOfHorsePower, Transport.typeOfSpace paramA, String transportPurpose) {
        this.numbOfHorsePower = numOfHorsePower;
        this.paramA = paramA;
        this.transportPurpose = transportPurpose;
    }


}
