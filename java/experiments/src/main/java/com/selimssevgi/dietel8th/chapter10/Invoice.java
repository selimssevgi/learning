package com.selimssevgi.dietel8th.chapter10;

// Invoice class implements Payable.
public class Invoice implements Payable
{
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    // four-argument constructor
    public Invoice( String part, String description, int count,
                    double price )
    {
        partNumber = part;
        partDescription = description;
        setQuantity( count ); // validate and store quantity
        setPricePerItem( price ); // validate and store price per item
    } // end four-argument Invoice constructor

    // set part number
    public void setPartNumber( String part )
    {
        partNumber = part; // should validate
    } // end method setPartNumber

    // get part number
    public String getPartNumber()
    {
        return partNumber;
    } // end method getPartNumber

    // set description
    public void setPartDescription( String description )
    {
        partDescription = description; // should validate
    } // end method setPartDescription

    // get description
    public String getPartDescription()
    {
        return partDescription;
    } // end method getPartDescription

    // set quantity
    public void setQuantity( int count )
    {
        quantity = ( count < 0 ) ? 0 : count; // quantity cannot be negative
    } // end method setQuantity

    // get quantity
    public int getQuantity()
    {
        return quantity;
    } // end method getQuantity

    // set price per item
    public void setPricePerItem( double price )
    {
        pricePerItem = ( price < 0.0 ) ? 0.0 : price; // validate price
    } // end method setPricePerItem

    // get price per item
    public double getPricePerItem()
    {
        return pricePerItem;
    } // end method getPricePerItem

    // return String representation of Invoice object
    @Override
    public String toString()
    {
        return String.format( "%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
                "invoice", "part number", getPartNumber(), getPartDescription(),
                "quantity", getQuantity(), "price per item", getPricePerItem() );
    } // end method toString

    // method required to carry out contract with interface Payable
    @Override
    public double getPaymentAmount()
    {
        return getQuantity() * getPricePerItem(); // calculate total cost
    } // end method getPaymentAmount
} // end class Invoice
