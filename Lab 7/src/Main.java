package main.kzp.lab7;

import main.kzp.lab7.stuff.Pen;
import main.kzp.lab7.stuff.Scissor;

public class Main {
    public static void main(String[] args) {
        PencilBox pencilBox = new PencilBox();
        pencilBox.putThing(new Pen());
        pencilBox.putThing(new Pen());
        pencilBox.putThing(new Pen());
        pencilBox.putThing(new Scissor(2));
        pencilBox.putThing(new Scissor(5));

        pencilBox.getPens().forEach(Pen::doWork);
        pencilBox.getScissors().forEach(Scissor::doWork);

        System.out.println(pencilBox.getMinimumScissor().getSize());
    }
}
        package main.kzp.lab7;

        import main.kzp.lab7.stuff.Pen;
        import main.kzp.lab7.stuff.Scissor;
        import main.kzp.lab7.stuff.Stuff;

        import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.List;
        import java.util.NoSuchElementException;
        import java.util.stream.Collectors;

public class PencilBox {
    private List<Stuff> stuffList = new ArrayList<>();

    public <T extends Stuff> void putThing(T thing){
        stuffList.add(thing);
    }

    public Scissor getMinimumScissor(){
        return stuffList.stream().filter(x -> x instanceof Scissor).map(x -> (Scis-sor)x).min(Comparator.comparing(Scissor::getSize)).orElseThrow(NoSuchElementException::new);
    }

    public List<Scissor> getScissors(){
        return stuffList.stream().filter(x -> x instanceof Scissor).map(x -> (Scissor)x).collect(Collectors.toList());
    }

    public List<Pen> getPens(){
        return stuffList.stream().filter(x -> x instanceof Pen).map(x -> (Pen)x).collect(Collectors.toList());
    }
}
        package main.kzp.lab7.stuff;

public interface Stuff {
    void doWork();
}
        package main.kzp.lab7.stuff;

public class Pen implements Stuff{
    @Override
    public void doWork() {
        System.out.println("The pen write some text.");
    }
}
        package main.kzp.lab7.stuff;

public class Scissor implements Stuff{

    private int size;

    public Scissor(int size) {
        this.size = size;
    }

    @Override
    public void doWork() {
        System.out.println("The scissor cut off smth.");
    }

    public int getSize() {
        return size;
    }
}
