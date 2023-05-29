
package Task1;
import  java.io.Serializable;
import  java.lang.Comparable;
import  java.util.*;
import java.io.*;
public class Transport implements Serializable, Comparable<Transport>  {
    public enum typeOfSpace{
        Air,
        Water,
        Ground,
        underGround
    };
    public int numbOfHorsePower;
    public typeOfSpace paramA;
    public String transportPurpose;
    public void Show(){
        System.out.println("HorsePower: " + numbOfHorsePower +"   "+ "Space: " + paramA + "   " + "Purpose: " + transportPurpose);
    }
    public Transport(){
        transportPurpose  = "passenger transportation";
        paramA = typeOfSpace.Ground;
        numbOfHorsePower = 250;
    }

    public Transport(int numOfHorsePower,  typeOfSpace paramA, String transportPurpose) {
        this.numbOfHorsePower = numOfHorsePower;
        this.paramA = paramA;
        this.transportPurpose = transportPurpose;
    }


    public static void Deserialize(String[] args) {
        // Deserialization - loading the object from a file
        try {
            FileInputStream fileIn = new FileInputStream("transport.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Transport deserializedTransport = (Transport) in.readObject();
            in.close();
            fileIn.close();

            // Access the deserialized object
            deserializedTransport.Show();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int compareTo(Transport other) {
        int A;
        A = this.numbOfHorsePower-other.numbOfHorsePower;

        return -A;
    }

}


