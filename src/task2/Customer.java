package task2;

import java.util.ArrayList;

public class Customer
{
    public Customer (String name) {
        this.name = name;
    }

    public void addRental (Rental rental) {
        rentals.add(rental);
    }

    public String getName () {
        return name;
    }

    public String statement () {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName () + "\n");

        for (Rental each : rentals) {
            double thisAmount = calculateAmount(each);

            frequentRenterPoints++;

            if (each.getMovie ().getPriceCode () == Movie.NEW_RELEASE
                    && each.getDaysRented () > 1) {
                frequentRenterPoints++;
            }

            result.append("\t")
                    .append(each.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount)
                    .append("\n");
            totalAmount += thisAmount;
        }

        result.append("You owed ")
                .append(totalAmount)
                .append("\n");

        result.append("You earned ")
                .append(frequentRenterPoints)
                .append(" frequent renter points\n");

        return result.toString();
    }

    private double calculateAmount(Rental rental) {
        double      thisAmount = 0;

        // determines the amount for each line
        switch (rental.getMovie().getPriceCode ()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented () > 2)
                    thisAmount += (rental.getDaysRented () - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented () * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented () > 3)
                    thisAmount += (rental.getDaysRented () - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();
}
