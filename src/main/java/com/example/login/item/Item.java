package com.example.login.item;

import com.example.login.appuser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Item {

    @Id
    @GeneratedValue
    private long pid;
    private String productName;
    private int qty;
    private double price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser appUser;
}
