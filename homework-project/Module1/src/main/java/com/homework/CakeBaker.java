package com.homework;

public class CakeBaker {

    private Frosting frosting;
    private Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup){
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){

        System.out.println("Cake baked with "
                + frosting.getFrostingType()
                + " and "
                + syrup.getSyrupType());
    }

}
