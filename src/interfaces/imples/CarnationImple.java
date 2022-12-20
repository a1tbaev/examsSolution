package interfaces.imples;

import classes.Carnation;
import classes.MyException;
import classes.Tulip;
import enums.Color;
import interfaces.FlowerService;

import java.util.*;

public class CarnationImple implements FlowerService<Carnation> {
    List<Carnation> carnations = new LinkedList<>();
    @Override
    public String addFlowers(List<Carnation> t) {
        carnations.addAll(t);
        return "successfully created!!";
    }

    @Override
    public List<Carnation> getAllFlowers() {
        return this.carnations;
    }

    @Override
    public List<Carnation> getFlowersFinByColor(String color) throws MyException {
        List<Carnation> carnations1 = new LinkedList<>();
        try{
            for (Carnation carnation : this.carnations) {
                if (carnation.getColor().name().equals(color)){
                    carnations1.add(carnation);
                }
            }
        }catch (Exception e){
            throw new MyException("wrong input or wrong color");
        }
        return carnations1;
    }

    @Override
    public Map<Color, List<Carnation>> groupingFlowersByColor() {
        Map<Color, List<Carnation>> colorListMap = new LinkedHashMap<>();
        List<Carnation> group = new LinkedList<>();
        List<Carnation> group1 = new LinkedList<>();
        List<Carnation> group2 = new LinkedList<>();
        List<Carnation> group3 = new LinkedList<>();

        for (Carnation tulip : this.carnations) {
            if (tulip.getColor().equals(Color.YELLOW)) {
                group.add(tulip);
            } else if (tulip.getColor().equals(Color.WHITE)) {
                group1.add(tulip);
            } else if (tulip.getColor().equals(Color.RED)) {
                group2.add(tulip);
            }else {
                group3.add(tulip);
            }
        }
        colorListMap.put(Color.YELLOW, group);
        colorListMap.put(Color.WHITE, group1);
        colorListMap.put(Color.RED, group2);
        colorListMap.put(Color.PINK, group3);
        return colorListMap;
    }

    @Override
    public int getSumAllFlowers() {
        int sum = 0;
        for (Carnation carnation : this.carnations) {
            sum = sum + carnation.getPrice();
        }
        return 0;
    }

    @Override
    public List<Carnation> getAllFlowersSortByPrice(String ascendingOrDescending) throws MyException {
        if (ascendingOrDescending.equals("ascending")){
            return (List<Carnation>) carnationComparator;
        }
        return (List<Carnation>) carnationComparator1;
    }

    Comparator<Carnation> carnationComparator = new Comparator<Carnation>() {
        @Override
        public int compare(Carnation o1, Carnation o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };

    Comparator<Carnation> carnationComparator1 = new Comparator<Carnation>() {
        @Override
        public int compare(Carnation o1, Carnation o2) {
            return o2.getPrice() - o1.getPrice();
        }
    };
}
