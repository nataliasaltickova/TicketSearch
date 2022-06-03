import java.util.Arrays;
import java.util.Objects;

public class TicketManager {
    private final TicketRepository repository;

    public TicketManager(TicketRepository repository1) {
        this.repository = repository1;
    }

    public Ticket[] searchBy(String from, String to) {

        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getDepartureAirport() == from && ticket.getArrivalAirport() == to) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int LastIndex = tmp.length - 1;
                tmp[LastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
