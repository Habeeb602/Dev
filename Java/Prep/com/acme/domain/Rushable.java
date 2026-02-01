package com.acme.domain;

import com.acme.util.MyDate;

public interface Rushable {
    public abstract boolean isRushable(MyDate orderDate, double amount);
}
