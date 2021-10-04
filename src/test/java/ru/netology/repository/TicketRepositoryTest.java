package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 35000, "DMD", "KIX", 720);
    Ticket ticket2 = new Ticket(2, 40000, "DMD", "ONT", 780);
    Ticket ticket3 = new Ticket(3, 45000, "DMD", "KIX", 600);
    Ticket ticket4 = new Ticket(4, 5000, "VKV", "COB", 700);
    Ticket ticket5 = new Ticket(5, 54000, "SHE", "COB", 400);
    Ticket ticket6 = new Ticket(6, 56000, "ONT", "KIX", 680);
    Ticket ticket7 = new Ticket(7, 58000, "DMD", "KIX", 750);

    @Test
    public void shouldFindById() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);

        Ticket actual = repository.findById(3);
        Ticket expected = new Ticket(3, 45000, "DMD", "KIX", 600);
        assertEquals(expected, actual);
    }
}