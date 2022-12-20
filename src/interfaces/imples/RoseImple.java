package interfaces.imples;

import classes.Flower;
import classes.MyException;
import classes.Rose;
import enums.Color;
import interfaces.FlowerService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RoseImple implements FlowerService <Rose> {
    List<Rose> roses = new LinkedList<>();
    @Override
    public String addFlowers(List<Rose> t) {
        this.roses.addAll(t);
        return "successfully added";
    }

    @Override
    public List<Rose> getAllFlowers() {
        return this.roses;
    }

    @Override
    public List<Rose> getFlowersFinByColor(String color) throws MyException {
        List<Rose> roses1 = new LinkedList<>();
        try{
            for (Rose rose : this.roses) {
                if (rose.getColor().name().equals(color.toUpperCase())){
                    roses1.add(rose);
                }
            }
        }catch (Exception e){
            throw new MyException("wrong color!!");
        }
        return roses1;
    }

    @Override
    public Map<Color, List<Rose>> groupingFlowersByColor() {
        return null;
    }

    @Override
    public int getSumAllFlowers() {
        int sum = 0;
        for (Rose rose : this.roses) {
            sum = sum + rose.getPrice();
        }

        return sum;
    }

    @Override
    public List<Rose> getAllFlowersSortByPrice(String ascendingOrDescending) throws MyException {
        try{
            if (ascendingOrDescending.equals("ascending")){
                return (List<Rose>) comparator;
            }else {
                return (List<Rose>) comparator1;
            }
        }catch (Exception e){
            throw new MyException("wrong input");
        }
    }
    Comparator<Rose> comparator = new Comparator<Rose>() {
        @Override
        public int compare(Rose o1, Rose o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };
    Comparator<Rose> comparator1 = new Comparator<Rose>() {
        @Override
        public int compare(Rose o1, Rose o2) {
            return o2.getPrice() - o1.getPrice();
        }
    };
}
