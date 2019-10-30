package fancyfoods.chocolate;

import fancyfoods.food.Food;
import fancyfoods.offers.SpecialOffer;

import java.util.Calendar;

public class RomanticChocolateOffer implements SpecialOffer {
    @Override
    public Food getOfferFood() {
        if (isNearValentineDay()) {
            return new HeartShapedChocolates();
        } else {
            return new SquareChocolates();
        }
    }

    @Override
    public String getDescription() {
        return "A wonderful surprise for someone you want to impress.";
    }

    private boolean isNearValentineDay() {
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.MONTH) == Calendar.FEBRUARY
                && today.get(Calendar.DAY_OF_MONTH) <= 14;
    }
}
