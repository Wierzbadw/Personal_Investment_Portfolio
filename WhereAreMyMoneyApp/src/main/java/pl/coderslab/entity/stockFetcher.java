package pl.coderslab.entity;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class stockFetcher {
    static BigDecimal fetchPrice(String symbol) throws IOException {
        Stock stock = YahooFinance.get(symbol);
        return stock.getQuote().getPrice();
    }

    static BigDecimal fetchChangeInPercent(String symbol) throws IOException {
        Stock stock = YahooFinance.get(symbol);
        return stock.getQuote().getChangeInPercent();
    }

    static String fetchDisplayName(String symbol) throws IOException {
        Stock stock = YahooFinance.get(symbol);
        return stock.getName();
    }

    private static String convertDate(Calendar cal) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = format.format(cal.getTime());
        return formatDate;
    }

    public static List<String> fetchStockDetails(String symbol) throws IOException {
        Stock stock = YahooFinance.get(symbol);
        List <String> list = new ArrayList<String>();

        list.add(String.valueOf(stock.getQuote().getDayLow()));
        list.add(String.valueOf(stock.getQuote().getDayHigh()));

        list.add(String.valueOf(stock.getQuote().getYearLow()));
        list.add(String.valueOf(stock.getQuote().getYearHigh()));

        list.add(String.valueOf(stock.getQuote().getChange()));
        list.add(String.valueOf(stock.getQuote().getPreviousClose()));
        list.add(String.valueOf(stock.getQuote().getChangeInPercent()));

        list.add(String.valueOf(stock.getQuote().getPriceAvg50()));
        list.add(String.valueOf(stock.getQuote().getChangeFromAvg50InPercent()));

        list.add(String.valueOf(stock.getQuote().getPriceAvg200()));
        list.add(String.valueOf(stock.getQuote().getChangeFromAvg200InPercent()));

        return list;
    }

}
