package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dao.ExpensesDao;
import pl.coderslab.entity.Expenses;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ExpensesController {
    private final ExpensesDao expensesDao;

    public ExpensesController(ExpensesDao expensesDao) {
        this.expensesDao = expensesDao ;
    }

    @GetMapping("/expensesForm/list")
    public String showAll(Model model) {
        model.addAttribute("allExpenses", expensesDao.findAll());
        return "expenses/all";
    }

    @GetMapping("/expensesForm/add")
    public String initAddFom(Model model) {
        model.addAttribute("expense", new Expenses());
        return "expenses/form";
    }

    @PostMapping("/expensesForm/add")
    public String persistAuthor(@ModelAttribute("expense")@Valid Expenses expense, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "expenses/form";
        }
        expensesDao.persist(expense);
        return "redirect:/expensesForm/list";
    }

    @GetMapping("/expensesForm/edit")
    public String prepareEdit(@RequestParam Long idToEdit, Model model) {
        model.addAttribute("expense", expensesDao.findById(idToEdit));
        return "expenses/form";
    }

    @PostMapping("/expensesForm/edit")
    public String merge(@Valid Expenses expense, BindingResult result) {
        if (result.hasErrors()) {
            return "expenses/form";
        }
        expensesDao.merge(expense);
        return "redirect:/expensesForm/list";
    }

    @GetMapping("/expensesForm/remove")
    public String prepareRemove(@RequestParam Long toRemoveId, Model model) {
        model.addAttribute("expense",expensesDao.findById(toRemoveId));
        return "expenses/remove";
    }

    @PostMapping("/expensesForm/remove")
    public String remove(@RequestParam String confirmed, @RequestParam Long toRemoveId) {
        if ("yes".equals(confirmed)) {
            Expenses expense = expensesDao.findById(toRemoveId);
            expensesDao.remove(expense);
        }
        return "redirect:/expensesForm/list";
    }
}