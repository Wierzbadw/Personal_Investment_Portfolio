package pl.coderslab.controller;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dao.CurrenciesDao;
import pl.coderslab.entity.Currencies;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class CurrenciesController {

    private final CurrenciesDao currenciesDao;

    public CurrenciesController(CurrenciesDao currenciesDao) {
        this.currenciesDao = currenciesDao ;
    }

    @GetMapping("/currenciesForm/list")
    public String showAll(Model model) {
        model.addAttribute("allCurrencies", currenciesDao.findAll());
        return "currencies/all";
    }

    @GetMapping("/currenciesForm/add")
    public String initAddFom(Model model) {
        model.addAttribute("currency", new Currencies());
        return "currencies/form";
    }

    @PostMapping("/currenciesForm/add")
    public String persistAuthor(@ModelAttribute("currency")@Valid Currencies currency, BindingResult result) throws IOException, JSONException {
        if (result.hasErrors()) {
            return "currencies/form";
        }
        currency.setCurrencyRate(currency.getCurrencyBase());
        currency.setCurrencyValue(currency.getCurrencyRate(),currency.getCurrencyAmount());
        currency.setCurrencyYearChange(currency.getCurrencyBase());
        currenciesDao.persist(currency);
        return "redirect:/currenciesForm/list";
    }

    @GetMapping("/currenciesForm/edit")
    public String prepareEdit(@RequestParam Long idToEdit, Model model) {
        model.addAttribute("currency", currenciesDao.findById(idToEdit));
        return "currencies/form";
    }

    @PostMapping("/currenciesForm/edit")
    public String merge(@Valid Currencies currency, BindingResult result) throws JSONException, IOException {
        if (result.hasErrors()) {
            return "currencies/form";
        }
        currency.setCurrencyRate(currency.getCurrencyBase());
        currency.setCurrencyValue(currency.getCurrencyRate(),currency.getCurrencyAmount());
        currency.setCurrencyYearChange(currency.getCurrencyBase());
        currenciesDao.merge(currency);
        return "redirect:/currenciesForm/list";
    }

    @GetMapping("/currenciesForm/remove")
    public String prepareRemove(@RequestParam Long toRemoveId, Model model) {
        model.addAttribute("currency",currenciesDao.findById(toRemoveId));
        return "currencies/remove";
    }

    @PostMapping("/currenciesForm/remove")
    public String remove(@RequestParam String confirmed, @RequestParam Long toRemoveId) {
        if ("yes".equals(confirmed)) {
            Currencies currency =currenciesDao.findById(toRemoveId);
            currenciesDao.remove(currency);
        }
        return "redirect:/currenciesForm/list";
    }
}
