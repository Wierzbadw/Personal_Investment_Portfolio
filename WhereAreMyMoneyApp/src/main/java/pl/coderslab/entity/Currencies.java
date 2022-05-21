package pl.coderslab.entity;

import org.json.JSONException;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.IOException;


@Entity
@Table(name = "currencies")
public class Currencies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 1, max = 20, message = "Nazwa musi mieć od 1 do 20 znaków")
    private String currencyBase;


    private double currencyAmount;

    private double currencyValue;

    private double currencyRate;

    public double currencyYearChange;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getCurrencyRate() {
        return currencyRate;
    }


    public void setCurrencyRate(String currencyBase) throws IOException, JSONException {

        this.currencyRate = currencyFetcher.fetchCurrencyRateToUSD(currencyBase);
    }


    public String getCurrencyBase() {
        return currencyBase;
    }

    public void setCurrencyBase(String currencyBase) {
        this.currencyBase = currencyBase;
    }

    public double getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(double currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyRate,double currencyAmount) {
        this.currencyValue = currencyRate*currencyAmount;
    }

    public double getCurrencyYearChange() {
        return  currencyYearChange;
    }

    public void setCurrencyYearChange(String currencyBase) throws IOException, JSONException {
        this.currencyYearChange = currencyFetcher.fetchYearChange(currencyBase);

    }



    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", currencyBase=" + currencyBase +
                ", currencyRate=" + currencyRate +
                ", currencyAmount=" + currencyAmount +
                ", currencyValue=" + currencyValue +
                ", currencyYearChange=" + currencyYearChange +
                '}';
    }
}

