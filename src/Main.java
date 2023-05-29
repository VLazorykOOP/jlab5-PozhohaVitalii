import  java.io.*;
import Task1.*;
import java.util.*;
import java.util.Collections;

public
class Main {


    private static void deserializeObjectsFromFile(ArrayList<Transport> transportList) {
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\verto\\IdeaProjects\\jlab5-PozhohaVitalii\\transport.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Deserialize objects until the end of the file
            while (true) {
                try {
                    Transport deserializedTransport = (Transport) in.readObject();
                    transportList.add(deserializedTransport);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }

            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void serializeObjectsToFile(ArrayList<Transport> transportList) {


        // Serialization - saving the object to a file
        try {
            FileOutputStream fileOut = new FileOutputStream("transport.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            int i = 0;
            for (Transport transport : transportList) {
                out.writeObject(transport);

                System.out.println("Serialized data is saved in transport.ser" + i);
                i++;
            }
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void serialize1ObjectsToFile(ArrayList<TransportAbstract> transportList) {

        // Serialization - saving the object to a file
        try {
            FileOutputStream fileOut = new FileOutputStream("transportAbstract.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            int i = 0;
            for (TransportAbstract transport : transportList) {
                out.writeObject(transport);

                System.out.println("Serialized data is saved in transport.ser" + i);
                i++;
            }
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void Task1() {
        ArrayList<Transport> transportList = new ArrayList<>();
        ArrayList<TransportAbstract> transportAbstractList = new ArrayList<TransportAbstract>();
        ArrayList<Transport> transportListres = new ArrayList<>();

        for (int A = 0; A < 20; A++) {
            Transport trans = new Transport(200 + A, Transport.typeOfSpace.Water, "do somthing Like " + A);
            transportList.add(trans);
            // Deserialize objects from file into the ArrayList
        }
        serializeObjectsToFile(transportList);
        deserializeObjectsFromFile(transportListres);


        // Print the deserialized objects
        for (Transport transport : transportListres) {
            transport.Show();
        }
        // write your code here
        Collections.sort(transportListres);
        for (Transport transport : transportListres) {
            transport.Show();
        }
        int A = 0;
        for (Transport transport : transportListres) {
            transportAbstractList.add(new TransportAbstract() {
                @Override
                public void Show() {
                    System.out.println(this.numbOfHorsePower);
                }
            });
            transportAbstractList.get(A).transportPurpose = transport.transportPurpose;
            transportAbstractList.get(A).numbOfHorsePower = transport.numbOfHorsePower;
            transportAbstractList.get(A).paramA = transport.paramA;
            A++;

        }
        for (TransportAbstract transport : transportAbstractList) {
            transport.Show();
        }

        Comppareiro a = new Comppareiro();
        Collections.sort(transportAbstractList, a);
        for (TransportAbstract transport : transportAbstractList) {
            transport.Show();
        }
        serialize1ObjectsToFile(transportAbstractList);

    }

    public  static void  Task2() {

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(lines);

        for (String line : lines) {
            System.out.println(line);
        }

    }
    public static void main(String[] args) {
        System.out.println(" Java lab 7 ");
      //  ThreadStarter.main(args);

        Task2();

    }

    //public
    /*
    class ThreadStarter {
        public static void main(String[] args) {
            NamedRunnable nr = new NamedRunnable();
            Thread one = new Thread(nr);
            Thread two = new Thread(nr);
            Thread three = new Thread(nr);

            one.setName("Перший");
            two.setName("Другий");
            three.setName("Третій");

            one.start();
            two.start();
            three.start();
        }
    }
*/
    class NamedRunnable implements Runnable {
        public void run() {
            System.out.println("Завантажений " + Thread.currentThread().getName());
            System.out.println("Закінченний  " + Thread.currentThread().getName());
        }
    }
}


