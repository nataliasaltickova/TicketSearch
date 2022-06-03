import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {


    @Test
    void shouldFindAllWhenAddThird() {
        TicketRepository repository = new TicketRepository();
        Ticket ticket1 = new Ticket(1,1000,"LED","GOJ", 59);
        Ticket ticket2 = new Ticket(3,1500,"DME","EGO", 123);
        Ticket ticket3 = new Ticket(5,3000,"KUF","GOJ", 65);

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);

        Ticket[] expected = {ticket1,ticket2,ticket3};
        Ticket [] actual = repository.findAll();

        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldRemoveByIdWhenOneTicket() {
        TicketRepository repository = new TicketRepository();
        Ticket ticket1 = new Ticket(1,1000,"LED","GOJ", 59);
        Ticket ticket2 = new Ticket(3,1500,"DME","EGO", 123);
        Ticket ticket3 = new Ticket(5,3000,"KUF","GOJ", 65);

        repository.add(ticket1);
        repository.removeById(1);

        Ticket[] expected = {};
        Ticket [] actual = repository.findAll();

        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldRemoveByIdWhenRemoveOne() {
        TicketRepository repository = new TicketRepository();
        Ticket ticket1 = new Ticket(1,1000,"LED","GOJ", 59);
        Ticket ticket2 = new Ticket(3,1500,"DME","EGO", 123);
        Ticket ticket3 = new Ticket(5,3000,"KUF","GOJ", 65);

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.removeById(1);

        Ticket[] expected = {ticket2,ticket3};
        Ticket [] actual = repository.findAll();

        assertArrayEquals(expected,actual);
    }

    }


