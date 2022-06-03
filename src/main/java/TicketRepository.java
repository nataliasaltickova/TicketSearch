public class TicketRepository {
    Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {

        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int LastIndex = tmp.length - 1;
        tmp[LastIndex] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {

        return tickets;
    }

    public void removeById(int id) {

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;

        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;

    }


}
