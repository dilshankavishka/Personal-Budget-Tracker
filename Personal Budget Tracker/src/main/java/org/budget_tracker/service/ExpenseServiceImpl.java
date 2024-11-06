package org.budget_tracker.service;

import lombok.RequiredArgsConstructor;
import org.budget_tracker.dto.Expense;
import org.budget_tracker.entity.ExpenseEntity;
import org.budget_tracker.repository.ExpenseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Expense> getAll() {
       List<Expense> expenseList = new ArrayList<>();
       repository.findAll().forEach(entity ->{
           expenseList.add(mapper.map(entity, Expense.class));
       });
        return expenseList;
    }

    @Override
    public void addExpense(Expense expense) {
        repository.save(mapper.map(expense, ExpenseEntity.class));
    }

    @Override
    public void deleteExpenseById(Integer expenseId) {
        repository.deleteById(expenseId);
    }

    @Override
    public Expense searchExpenseById(Integer expenseId) {
        return mapper.map(repository.findById(expenseId), Expense.class);
    }

    @Override
    public void updateExpenseById(Expense expense) {
        repository.save(mapper.map(expense,ExpenseEntity.class));
    }
}
