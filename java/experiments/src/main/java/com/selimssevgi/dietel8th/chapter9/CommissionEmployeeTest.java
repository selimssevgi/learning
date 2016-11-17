package com.selimssevgi.dietel8th.chapter9;

/**
 * Created by ssselim on 8/4/16.
 */
public class CommissionEmployeeTest {

    public static void main( String[] args )
    {
        ComissionEmployee ce = new ComissionEmployee( "Selim", "Sevgi", "123456", 10000, .06);

        BasePlusCommissionEmployee bce = new BasePlusCommissionEmployee(
                "baselemm",
                "basesevgi",
                "654321",
                50000,
                .07,
                100
        );

        System.out.println(ce);
        System.out.println(bce);

    }

}
