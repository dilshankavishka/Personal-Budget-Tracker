package org.budget_tracker.service;

import org.budget_tracker.dto.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAll();
    void addExpense(Expense expense);
    void deleteExpenseById(Integer expenseId);
    Expense searchExpenseById(Integer expenseId);
    void updateExpenseById(Expense expense);
}
