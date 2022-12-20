package interfaces;

import classes.MyException;
import enums.Color;

import java.util.List;
import java.util.Map;

public interface FlowerService <T>{
    String addFlowers(List<T> t);
    List<T> getAllFlowers();
    List<T> getFlowersFinByColor(String color) throws MyException;
    Map<enums.Color, List<T>> groupingFlowersByColor();
    int getSumAllFlowers();
    List<T> getAllFlowersSortByPrice(String ascendingOrDescending) throws MyException;
}
