package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    public boolean matchesFromTo(String from, String to) {
        if (this.from.contains(from) & this.to.contains(to)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }
}

