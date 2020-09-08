import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        jsonSerializer js = new jsonSerializer();
        PrintStream writer = new PrintStream("D:\\4sem\\untitled\\src\\main\\resources\\JSONSerialized.json");
        Worker qwe = new Worker("qwe",3);
        Worker qwe2 = new Worker("qwe2",4);
        Worker qwe3 = new Worker("qwe3",5);
        ArrayList<Worker> lst = new ArrayList<Worker>();
        lst.add(qwe);
        lst.add(qwe2);
        lst.add(qwe3);
        js.serialize(writer, lst);
        ArrayList<Worker> qq = (ArrayList<Worker>) js.deserialize();
    }
}