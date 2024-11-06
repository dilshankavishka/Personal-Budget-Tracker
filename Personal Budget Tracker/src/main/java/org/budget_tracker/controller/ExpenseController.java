package org.budget_tracker.controller;

import lombok.RequiredArgsConstructor;
import org.budget_tracker.dto.Expense;
import org.budget_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {
    @Autowired
    final  ExpenseService service;
    @GetMapping("/get-all")
    public List<Expense> getExpense(){
        return service.getAll();
    }
    @PostMapping("/add-expense")
    @ResponseStatus(HttpStatus.CREATED)
    public void addExpense(@RequestBody Expense expense){
        service.addExpense(expense);
    }
    @GetMapping("/search-by-id/{id}")
    public Expense getExpenseById(@PathVariable Integer id){
        return service.searchExpenseById(id);
    }
    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteExpenseById(@PathVariable Integer id){
        service.deleteExpenseById(id);
    }
    @PutMapping("/update-expense")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateExpenseById(@RequestBody Expense expense){
        service.updateExpenseById(expense);
    }

}
