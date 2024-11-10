package org.budget_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Expense {
    private Integer id;
    private String description;
    private String type;
    private Date date;
    private Double amount;
}
