package com.Menu;
interface Pizza{
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza{

    @Override
    public String getDescription() {
        return " Hand made ";
    }

    @Override
    public double getCost() {
        return 4.26;
    }
}

abstract class ToppingDecorator implements Pizza{
    protected Pizza domino;

    public ToppingDecorator(Pizza creola){
        this.domino = creola;
    }

    @Override
    public String getDescription() {
        return domino.getDescription();
    }

    @Override
    public double getCost() {
        return domino.getCost();
    }
}

class Mexican extends ToppingDecorator{

    public Mexican(Pizza creola) {
        super(creola);
        System.out.println("Adding dough");
        System.out.println("Adding Guinea Fowl");
    }
    @Override
    public String getDescription() {
        return domino.getDescription() + " , Guinea Fowl";
    }

    @Override
    public double getCost() {
        return domino.getCost() + 3.00;
    }
}

class Quebecois extends ToppingDecorator{

    public Quebecois(Pizza creola) {
        super(creola);

        System.out.println("Adding Pineapple");
    }
    @Override
    public String getDescription() {
        return domino.getDescription() + " , Bacon, Pineapple";
    }

    @Override
    public double getCost() {
        return domino.getCost() + 3.00;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pizza dominos = new Quebecois(new PlainPizza());
        System.out.println("Ingredients: " + dominos.getDescription());
        System.out.println("Price: " + dominos.getCost());
        System.out.println("------------------------------------------");
        dominos = new PlainPizza();
        System.out.println("Ingredients: " + dominos.getDescription());
        System.out.println("Price: " + dominos.getCost());
        System.out.println("------------------------------------------");
        dominos = new Quebecois(new Mexican(new PlainPizza()));
        System.out.println("Ingredients: " + dominos.getDescription());
        System.out.println("Price: " + dominos.getCost());
        System.out.println("------------------------------------------");

    }
}
