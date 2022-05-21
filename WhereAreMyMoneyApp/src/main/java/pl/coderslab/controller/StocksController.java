package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.dao.StocksDao;

import pl.coderslab.entity.Stocks;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class StocksController {

    private final StocksDao stocksDao;

    public StocksController(StocksDao stocksDao) {
        this.stocksDao = stocksDao;
    }

    @GetMapping("/stocksForm/list")
    public String showAll(Model model) {
        model.addAttribute("allStocks", stocksDao.findAll());
        return "stocks/all";
    }

    @GetMapping("/stocksForm/add")
    public String initAddFom(Model model) {
        model.addAttribute("stock", new Stocks());
        return "stocks/form";
    }

    @PostMapping("/stocksForm/add")
    public String persistAuthor(@ModelAttribute("stock")@Valid Stocks stock, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "stocks/form";
        }
        stock.setStockName(stock.getStockSymbol());
        stock.setStockPrice(stock.getStockSymbol());
        stock.setStockTotalValue(stock.getStockSymbol());
        stock.setStocksChangeInPercent(stock.getStockSymbol());
        stock.setDayLow(stock.getStockSymbol());
        stock.setDayHigh(stock.getStockSymbol());
        stock.setYearLow(stock.getStockSymbol());
        stock.setYearHigh(stock.getStockSymbol());
        stock.setPreviousClose(stock.getStockSymbol());
        stock.setPriceAvg50(stock.getStockSymbol());
        stock.setChangeFromAvg50InPercent(stock.getStockSymbol());
        stock.setPriceAvg200(stock.getStockSymbol());
        stock.setChangeFromAvg200InPercent(stock.getStockSymbol());
        stocksDao.persist(stock);
        return "redirect:/stocksForm/list";
    }

    @GetMapping("/stocksForm/details")
    public String prepareDetails(@RequestParam Long detailsOfId, Model model) {
        model.addAttribute("stock", stocksDao.findById(detailsOfId));
        return "stocks/details";
    }

    @PostMapping("/stocksForm/details")
    public String details(@RequestParam String confirmed, @RequestParam Long detailsOfId) {
        if ("yes".equals(confirmed)) {
            Stocks stock = stocksDao.findById(detailsOfId);
            stocksDao.remove(stock);
        }
        return "redirect:/stocksForm/list";
    }

    @GetMapping("/stocksForm/edit")
    public String prepareEdit(@RequestParam Long idToEdit, Model model) {
        model.addAttribute("stock", stocksDao.findById(idToEdit));
        return "stocks/form";
    }

    @PostMapping("/stocksForm/edit")
    public String merge(@Valid Stocks stock, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "stocks/form";
        }
        stock.setStockName(stock.getStockSymbol());
        stock.setStockPrice(stock.getStockSymbol());
        stock.setStockTotalValue(stock.getStockSymbol());
        stock.setStocksChangeInPercent(stock.getStockSymbol());
        stocksDao.merge(stock);
        return "redirect:/stocksForm/list";
    }

    @GetMapping("/stocksForm/remove")
    public String prepareRemove(@RequestParam Long toRemoveId, Model model) {
        model.addAttribute("stock", stocksDao.findById(toRemoveId));
        return "stocks/remove";
    }

    @PostMapping("/stocksForm/remove")
    public String remove(@RequestParam String confirmed, @RequestParam Long toRemoveId) {
        if ("yes".equals(confirmed)) {
            Stocks stock = stocksDao.findById(toRemoveId);
            stocksDao.remove(stock);
        }
        return "redirect:/stocksForm/list";
    }

}