package interfaces.imples;

import classes.MyException;
import classes.Tulip;
import enums.Color;
import interfaces.FlowerService;

import java.util.*;

public class TulipImple implements FlowerService<Tulip> {
    List<Tulip> tulips = new LinkedList<>();
    @Override
    public String addFlowers(List<Tulip> t) {
        this.tulips.addAll(t);
        return "Successfully added!!";
    }

    @Override
    public List<Tulip> getAllFlowers() {
        return this.tulips;
    }

    @Override
    public List<Tulip> getFlowersFinByColor(String color) throws MyException {
        List<Tulip> tulips1 = new LinkedList<>();
        try{
            for (Tulip tulip : this.tulips) {
                if (tulip.getColor().name().equals(color.toUpperCase())){
                    tulips1.add(tulip);
                }
            }
        }catch (Exception e){
            throw new MyException("wrong color or input");
        }
        return tulips1;
    }

    @Override
    public Map<Color, List<Tulip>> groupingFlowersByColor() {
        Map<Color, List<Tulip>> colorListMap = new LinkedHashMap<>();
        List<Tulip> group = new LinkedList<>();
        List<Tulip> group1 = new LinkedList<>();
        List<Tulip> group2 = new LinkedList<>();
        List<Tulip> group3 = new LinkedList<>();

        for (Tulip tulip : this.tulips) {
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
        for (Tulip tulip : this.tulips) {
            sum = sum + tulip.getPrice();
        }
        return sum;
    }

    @Override
    public List<Tulip> getAllFlowersSortByPrice(String ascendingOrDescending) throws MyException {
        try{
            if(ascendingOrDescending.equals("ascending")){
                return (List<Tulip>) tulipComparator;
            }else {
                return (List<Tulip>) tulipComparator1;
            }
        }catch (Exception e){
            throw new MyException("wrong input");
        }
    }
    Comparator<Tulip> tulipComparator = new Comparator<Tulip>() {
        @Override
        public int compare(Tulip o1, Tulip o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };
    Comparator<Tulip> tulipComparator1 = new Comparator<Tulip>() {
        @Override
        public int compare(Tulip o1, Tulip o2) {
            return o2.getPrice() - o1.getPrice();
        }
    };
}
