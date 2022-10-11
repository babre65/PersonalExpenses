package com.reihaneh.personalexpenses.repository;

import com.reihaneh.personalexpenses.domain.Expense;
import com.reihaneh.personalexpenses.service.dto.UserExpensesDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExpenseRepository extends BaseRepository<Expense, Long> {


    @Query("select new com.reihaneh.personalexpenses.service.dto.UserExpensesDto(" +
            " e.type, e.purchaseDate, e.paymentType, e.amount, e.note, e.description, e.category.name)" +
            " from Expense e where e.user.username = :userName")
    List<UserExpensesDto> getCurrentUserExpenses(String userName);


    @Query(value = "select new com.reihaneh.personalexpenses.service.dto.UserExpensesDto(" +
            " e.type, e.purchaseDate, e.paymentType, e.amount, e.note, e.description, e.category.name)" +
            " from Expense e where e.user.username = :username and e.category.id = :categoryId")
    List<UserExpensesDto> getCurrentUserExpensesByCategory(String username, Long categoryId);


    @Query(value = "SELECT Sum(AMOUNT) as totalAmount , MONTHNAME(PURCHASE_DATE) as monthName, YEAR(PURCHASE_DATE) as years, TYPE as type" +
            " FROM EXPENSE where USER_ID = 1 group by MONTH(PURCHASE_DATE ), YEAR(PURCHASE_DATE )  ,TYPE", nativeQuery = true)
    List<Map<String, Object>> getCurrentUserMonthlyTotalExpenses(String username);
}
