package com.codewithandrew.ShareTradingFunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class ShareMatrix {

    public static String getMaxProfit(int[] stockPrices) throws ParseException {
        String sDate1 = "2020/07/07 10:00:00";
        Date date1 = new SimpleDateFormat("yyyy/MM/dd H:m:s").parse(sDate1);
        var sp1 = new SharePrice(date1, stockPrices[0]);
        String sDate2 = "2020/07/05 11:00:00";
        Date date2 = new SimpleDateFormat("yyyy/MM/dd H:m:s").parse(sDate2);
        var sp2 = new SharePrice(date2, stockPrices[1]);

        String sDate3 = "2020/07/05 12:00:00";
        Date date3 = new SimpleDateFormat("yyyy/MM/dd H:m:s").parse(sDate3);
        var sp3 = new SharePrice(date3, stockPrices[2]);

        String sDate4 = "2020/07/05 13:00:00";
        Date date4 = new SimpleDateFormat("yyyy/MM/dd H:m:s").parse(sDate4);
        var sp4 = new SharePrice(date4, stockPrices[3]);

        String sDate5 = "2020/07/05 14:00:00";
        Date date5 = new SimpleDateFormat("yyyy/MM/dd H:m:s").parse(sDate5);
        var sp5 = new SharePrice(date5, stockPrices[4]);

        String sDate6 = "2020/07/05 15:00:00";
        Date date6 = new SimpleDateFormat("yyyy/MM/dd H:m:s").parse(sDate6);
        var sp6 = new SharePrice(date6, stockPrices[5]);

        Map<Date, Integer> map = new HashMap<>();
        map.put(sp1.getSellTime(), sp1.getPrice());
        map.put(sp2.getSellTime(), sp2.getPrice());
        map.put(sp3.getSellTime(), sp3.getPrice());
        map.put(sp4.getSellTime(), sp4.getPrice());
        map.put(sp5.getSellTime(), sp5.getPrice());
        map.put(sp6.getSellTime(), sp6.getPrice());

        TreeMap<Date, Integer> sorted = new TreeMap<>();
        // Sorting the hashmap
        sorted.putAll(map);

        int share_price;

        int max_value = 0;
        int current_value = 0;
        int difference;
        int profit, buy ,sell;
        int margin[] = new int[3];
        profit = 0;
        buy = 0;
        sell = 0;

        int map_size = map.size();
        for (int i = 0; i< map_size; i++){
            margin = iterator(sorted.entrySet().iterator());

            if (margin[0] != 0) {
                if (margin[0] > profit) {
                    profit = margin[0];
                    buy = margin[1];
                    sell = margin[2];
                }
            }
        }
        System.out.println(profit + "(buy at $" + buy + " sell at $" + sell + ")" );
        String result = profit + " (buy at $" + buy + " sell at $" + sell + ")" ;
        return result;
    }
    public static int[] iterator(Iterator iterator){
        int difference;
        int current_value = 0;
        Date current_date = new Date();
        int[] margin = new int[3];
        Iterator<Map.Entry<Date, Integer>> itr = iterator;
        int count = 0;
        int max_value = 0;
        while(itr.hasNext()) {
            count += 1;
            Map.Entry<Date, Integer> entry = itr.next();
            if (count == 1) {
                current_value = entry.getValue();
                current_date = entry.getKey();
                // remove the value from map
                itr.remove();
            }

            if (count > 1) {
                // check that the dates are ok
                if (current_date.before(entry.getKey())) {


                    difference = current_value - entry.getValue();
                    if (difference <= 0) {
                        if (max_value < Math.abs(difference)) {
                            margin[0] = Math.abs(difference);
                            max_value = Math.abs(difference);

                            margin[1] = (current_value);
                            margin[2] = (entry.getValue());

                        }
                    }
                }
            }
        }
        return margin;
    }

}
