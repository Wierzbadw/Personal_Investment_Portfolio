package pl.coderslab.entity;

import javax.persistence.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "stocks")
public class Stocks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String stockSymbol;

    public String stockName;
    public String stockIndustry;

    public BigDecimal stockPrice;
    public double stockUnits;

    public BigDecimal stockTotalValue;
    public BigDecimal stockChangeInPercent;

    public LocalDate date;
    private String dayLow;
    private String dayHigh;
    private String yearLow;
    private String yearHigh;
    private String priceAvg50;
    private String changeFromAvg50InPercent;
    private String priceAvg200;
    private String changeFromAvg200InPercent;
    private String previousClose;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setSetStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getStockName() throws IOException {
        return stockName;
    }

    public void setStockName(String stockSymbol) throws IOException {
        this.stockName = stockFetcher.fetchDisplayName(stockSymbol);
    }

    public String getStockIndustry() {
        return stockIndustry;
    }

    public void setStockIndustry(String stockIndustry) {
        this.stockIndustry = stockIndustry;
    }

    public BigDecimal getStockPrice() throws IOException {
        return stockPrice;
    }

    public void setStockPrice(String stockSymbol) throws IOException {
        this.stockPrice = stockFetcher.fetchPrice(stockSymbol);
    }


    public double getStockUnits() {
        return stockUnits;
    }

    public void setStockUnits(double stockUnits) {
        this.stockUnits = stockUnits;
    }

    public BigDecimal getStockTotalValue() throws IOException {
        return stockTotalValue;
    }

    public void setStockTotalValue(String stockSymbol) throws IOException {
        this.stockTotalValue = getStockPrice().multiply(BigDecimal.valueOf(getStockUnits()));
    }


    public BigDecimal getStockChangeInPercent() throws IOException {
        return stockChangeInPercent;
    }

    public void setStocksChangeInPercent(String stockSymbol) throws IOException {
        this.stockChangeInPercent = stockFetcher.fetchChangeInPercent(stockSymbol);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDayLow() {
        return dayLow;
    }

    public void setDayLow(String stockSymbol) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.dayLow =list.get(0);
    }

    public String getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(String stockSymbol) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.dayHigh =list.get(1);
    }

    public String getYearLow() {
        return yearLow;
    }

    public void setYearLow(String yearLow) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.yearLow =list.get(2);
    }

    public String getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(String yearHigh) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.yearHigh =list.get(3);
    }

    public String getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.previousClose =list.get(5);
    }

    public String getPriceAvg50() {
        return priceAvg50;
    }

    public void setPriceAvg50(String priceAvg50) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.priceAvg50 =list.get(7);
    }

    public String getChangeFromAvg50InPercent() {
        return changeFromAvg50InPercent;
    }

    public void setChangeFromAvg50InPercent(String changeFromAvg50InPercent) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.changeFromAvg50InPercent =list.get(8);
    }

    public String getPriceAvg200() {
        return priceAvg200;
    }

    public void setPriceAvg200(String priceAvg200) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.priceAvg200 =list.get(9);
    }

    public String getChangeFromAvg200InPercent() {
        return changeFromAvg200InPercent;
    }

    public void setChangeFromAvg200InPercent(String changeFromAvg200InPercent) throws IOException {
        List <String> list = stockFetcher.fetchStockDetails(stockSymbol);
        this.changeFromAvg200InPercent =list.get(10);
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", stockSymbol=" + stockSymbol + '\'' +
                ", stockName=" + stockName +
                ", stockPrice=" + stockPrice +
                ", stockIndustry=" + stockIndustry +
                ", stockUnits=" + stockUnits +
                ", stockTotalValue=" + stockTotalValue +
                ", stockChangeInPercent=" + stockChangeInPercent +
                ", date=" + date +
                ", dayLow=" + dayLow +
                ", dayHigh=" + dayHigh +
                ", yearLow=" + yearLow +
                ", yearHigh=" + yearHigh +
                ", previousClose=" + previousClose +
                ", priceAvg50=" + priceAvg50 +
                ", changeFromAvg50InPercent=" +  changeFromAvg50InPercent +
                ", priceAvg200=" + priceAvg200 +
                ", changeFromAvg200InPercent=" +  changeFromAvg200InPercent +
                '}';
    }
}

