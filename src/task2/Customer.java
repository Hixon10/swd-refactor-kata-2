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

        for (Rental rental : rentals) {
            double thisAmount = rental.calculateAmount();

            frequentRenterPoints += rental.needAdditionalRenterPoints() ? 2 : 1;

            result.append("\t")
                    .append(rental.getMovie().getTitle())
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

    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();
}
