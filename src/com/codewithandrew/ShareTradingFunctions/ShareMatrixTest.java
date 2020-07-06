package com.codewithandrew.ShareTradingFunctions;

import org.junit.Assert;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ShareMatrixTest {

    @org.junit.jupiter.api.Test
    void testGetMaxProfit() throws ParseException {
        int[] stockPrices = {10, 7, 5, 8, 11, 9};

        Assert.assertEquals ("6 (buy at $5 sell at $11)", ShareMatrix.getMaxProfit(stockPrices)); // returns 6 (buy at $5 sell at $11)

        int[] stockPrices2 = {5, 7, 5, 8, 11, 16};

        Assert.assertEquals ("11 (buy at $5 sell at $16)", ShareMatrix.getMaxProfit(stockPrices2)); // returns 6 (buy at $5 sell at $11)

        int[] stockPrices3 = {5, 7, 12, 8, 11, 1};

        Assert.assertEquals ("7 (buy at $5 sell at $12)", ShareMatrix.getMaxProfit(stockPrices3)); // returns 6 (buy at $5 sell at $11)


    }


}