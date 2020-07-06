import com.codewithandrew.ShareTradingFunctions.ShareMatrix;
import com.codewithandrew.ShareTradingFunctions.SharePrice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        ShareMatrix.getMaxProfit(stockPrices);

    }
}