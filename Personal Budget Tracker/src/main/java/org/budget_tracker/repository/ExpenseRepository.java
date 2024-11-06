package org.budget_tracker.repository;

import org.budget_tracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer> {

}
//interface CrudRepository<T,ID>{
//    void add(T t);
//    T get();
//    T searchById(ID id);
//}