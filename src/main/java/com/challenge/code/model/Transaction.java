package com.challenge.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Table(name = "TRANSACTION_TABLE")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "create_year")
    private Integer year;

    @Column(name = "create_month")
    private Integer month;

    @Column(name = "create_day")
    private Integer day;

    @Column(name = "transaction_amount")
    private double amount;
}
