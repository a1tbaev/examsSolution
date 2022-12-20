import classes.Carnation;
import classes.Flower;
import classes.Rose;
import classes.Tulip;
import enums.Color;
import interfaces.imples.CarnationImple;
import interfaces.imples.RoseImple;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception{
        Tulip tulip = new Tulip("Italy", (byte) 3, enums.Color.RED,100);
        Tulip tulip1 = new Tulip("USA", (byte) 3, Color.WHITE,20);
        Tulip tulip2 = new Tulip("China", (byte) 3, Color.YELLOW,200);
        Tulip tulip3 = new Tulip("China", (byte) 3, Color.RED,200);
        List<Tulip> tulips = new LinkedList<>();
        tulips.add(tulip);
        tulips.add(tulip1);
        tulips.add(tulip2);
        tulips.add(tulip3);

        Rose rose = new Rose("Italy", (byte) 4, Color.RED, 100);
        Rose rose1 = new Rose("USA", (byte) 4, Color.WHITE, 100);
        Rose rose2 = new Rose("China", (byte) 4, Color.YELLOW, 100);
        Rose rose3 = new Rose("Taiwan", (byte) 4, Color.RED, 100);
        List<Rose> roses = new LinkedList<>();
        roses.add(rose);
        roses.add(rose1);
        roses.add(rose2);
        roses.add(rose3);

        Carnation carnation = new Carnation("Italy", (byte) 1, Color.PINK, 200);
        Carnation carnation1 = new Carnation("USA", (byte) 1, Color.WHITE, 200);
        Carnation carnation2 = new Carnation("China", (byte) 1, Color.RED, 200);
        Carnation carnation3 = new Carnation("Italy", (byte) 1, Color.YELLOW, 200);
        List<Carnation> carnations = new LinkedList<>();
        carnations.add(carnation);
        carnations.add(carnation1);
        carnations.add(carnation2);
        carnations.add(carnation3);
        CarnationImple carnationImple = new CarnationImple();

        //RoseImple roseImple = new RoseImple();
        //System.out.println(roseImple.addFlowers(roses));
        //roseImple.getAllFlowers().forEach(System.out::println);
        //System.out.println(roseImple.getFlowersFinByColor("red"));
        //System.out.println(roseImple.getAllFlowersSortByPrice("ascending"));
       // System.out.println(roseImple.getSumAllFlowers());
        carnationImple.addFlowers(carnations);
        //System.out.println(carnationImple.groupingFlowersByColor());
    }
}
