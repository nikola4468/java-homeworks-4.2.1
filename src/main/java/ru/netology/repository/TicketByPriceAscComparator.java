package ru.netology.repository;

import ru.netology.domain.Ticket;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTime() - o2.getTime();
    }
}