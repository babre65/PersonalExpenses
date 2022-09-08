package com.reihaneh.personalexpenses.repository;

import com.reihaneh.personalexpenses.domain.Expense;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends BaseRepository<Expense, Long>{
}
