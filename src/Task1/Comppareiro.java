package Task1;
import java.util.Comparator;
public class Comppareiro implements Comparator<TransportAbstract>{
    @Override
    public int compare(TransportAbstract o1, TransportAbstract o2) {
       int a ;
       a = o1.numbOfHorsePower - o2.numbOfHorsePower;
        return a;
    }
}
