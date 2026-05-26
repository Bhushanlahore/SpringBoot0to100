package com.homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    // without qualifier in will use primary, output will be Cake baked with chocolate frosting and Chocolate Syrup
//    public CakeBaker(Frosting frosting, Syrup syrup){
//        this.frosting = frosting;
//        this.syrup = syrup;
 //   }

    public CakeBaker(@Qualifier("strawberryFrosting") Frosting frosting, @Qualifier("strawberrySyrup") Syrup syrup){
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
