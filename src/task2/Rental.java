package task2;

public class Rental
{
    private Movie movie;
    private int daysRented;

    public Rental (Movie movie, int daysRented) {
        this.movie      = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented () {
        return daysRented;
    }

    public Movie getMovie () {
        return movie;
    }

    public Boolean needAdditionalRenterPoints() {
        return getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1;
    }

    public double calculateAmount() {
        double      thisAmount = 0;

        // determines the amount for each line
        switch (getMovie().getPriceCode ()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (getDaysRented () > 2)
                    thisAmount += (getDaysRented () - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += getDaysRented () * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (getDaysRented () > 3)
                    thisAmount += (getDaysRented () - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
