import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private final static String PETERBURG = "LED";
    private final static String MOSCOW = "DME";
    public static final String NOVGOROD = "GOJ";
    public static final String CUJBUCEV = "KUF";
    public static final String SARATOV = "EGO";

    @Test
    void shouldSearchByFromAndTo() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 1000, PETERBURG, NOVGOROD, 59);
        Ticket ticket2 = new Ticket(3, 1500, MOSCOW, SARATOV, 123);
        Ticket ticket3 = new Ticket(5, 1000, CUJBUCEV, NOVGOROD, 65);

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);

        Ticket[] actual = manager.searchBy(PETERBURG, NOVGOROD);
        Ticket[] expected = {ticket1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByFromNotTo() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 1000, PETERBURG, NOVGOROD, 59);
        Ticket ticket2 = new Ticket(3, 1500, MOSCOW, SARATOV, 123);
        Ticket ticket3 = new Ticket(5, 1000, CUJBUCEV, NOVGOROD, 65);

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);

        Ticket[] actual = manager.searchBy(PETERBURG, SARATOV);
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotFromAndTo() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 1000, PETERBURG, NOVGOROD, 59);
        Ticket ticket2 = new Ticket(3, 1500, MOSCOW, SARATOV, 123);
        Ticket ticket3 = new Ticket(5, 1000, CUJBUCEV, NOVGOROD, 65);

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);

        Ticket[] actual = manager.searchBy(MOSCOW, NOVGOROD);
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotFromAndNotTo() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 1000, PETERBURG, NOVGOROD, 59);
        Ticket ticket2 = new Ticket(3, 1500, MOSCOW, SARATOV, 123);
        Ticket ticket3 = new Ticket(5, 1000, CUJBUCEV, NOVGOROD, 65);

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);

        Ticket[] actual = manager.searchBy(PETERBURG, SARATOV);
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPriceAndFromAndTo() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        Ticket ticket1 = new Ticket(1, 1000, PETERBURG, NOVGOROD, 59);
        Ticket ticket2 = new Ticket(3, 1500, MOSCOW, SARATOV, 123);
        Ticket ticket3 = new Ticket(5, 1000, CUJBUCEV, NOVGOROD, 65);
        Ticket ticket4 = new Ticket(6, 1500, CUJBUCEV, NOVGOROD, 64);

        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);

        Ticket[] actual = manager.searchBy(CUJBUCEV, NOVGOROD);
        Ticket[] expected = {ticket3, ticket4};

        assertArrayEquals(expected, actual);
    }
}