package com.lzwing.testcode.jodamoney;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/7/27
 * Time: 21:42
 */
public class Tester {
    public static void main(String[] args) {
        // create a monetary value
        Money money = Money.parse("CNY 23.87");

        // add another amount with safe double conversion
        CurrencyUnit usd = CurrencyUnit.of("CNY");
        money = money.plus(Money.of(usd, 12.43d));

        System.out.println(money);

        // subtracts an amount in dollars
        money = money.minusMajor(2);

        // multiplies by 3.5 with rounding
        money = money.multipliedBy(3.5d, RoundingMode.DOWN);

        // compare two amounts
        boolean bigAmount = money.isGreaterThan(money);

        // convert to GBP using a supplied rate
        // obtained from code outside Joda-Money
        BigDecimal conversionRate = new BigDecimal(10.0);
        Money moneyGBP = money.convertedTo(CurrencyUnit.GBP, conversionRate, RoundingMode.HALF_UP);

        // use a BigMoney for more complex calculations where scale matters
        BigMoney moneyCalc = money.toBigMoney();

    }
}
