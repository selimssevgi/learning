package com.selimssevgi.dietel8th.chapter17;

/**
 * Created by ssselim on 8/5/16.
 */
public enum MenuOption {
    ZERO_BALANCE( 1 ),
    CREDIT_BALANCE( 2 ),
    DEBIT_BALANCE( 3 ),
    END( 4 );

    private final int value;

    MenuOption(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
