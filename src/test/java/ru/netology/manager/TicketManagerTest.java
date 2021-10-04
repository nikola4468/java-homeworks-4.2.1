package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketManagerTest {
    private TicketManager manager = new TicketManager();
    Ticket ticket1 = new Ticket(1, 45000, "DMD", "KIX", 720);
    Ticket ticket2 = new Ticket(2, 40000, "DMD", "ONT", 780);
    Ticket ticket3 = new Ticket(3, 35000, "DMD", "KIX", 600);
    Ticket ticket4 = new Ticket(4, 5000, "VKV", "COB", 700);
    Ticket ticket5 = new Ticket(5, 54000, "SHE", "COB", 400);
    Ticket ticket6 = new Ticket(6, 56000, "ONT", "KIX", 680);
    Ticket ticket7 = new Ticket(7, 58000, "DMD", "KIX", 750);


    @Test
    void shouldSearchByFromTo() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.searchByFromToAndSortPrice("DMD", "KIX");
        Ticket[] expected = new Ticket[]{ticket3, ticket1, ticket7};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.getAll();
        Ticket[] expected = new Ticket[]{ticket7, ticket6, ticket5, ticket4, ticket3, ticket2, ticket1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.removeById(3);

        Ticket[] actual = manager.getAll();
        Ticket[] expected = new Ticket[]{ticket7, ticket6, ticket5, ticket4, ticket2, ticket1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveBynNoId() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        assertThrows(NotFoundException.class, () -> {
            manager.removeById(8);
        });
    }
}