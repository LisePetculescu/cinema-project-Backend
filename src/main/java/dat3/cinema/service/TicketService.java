package dat3.cinema.service;

import dat3.cinema.entity.Ticket;
import dat3.cinema.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket addTicket(Ticket request){
        Ticket newTicket = new Ticket();
        updateTicket(newTicket, request);
        return ticketRepository.save(newTicket);
    }

    public void updateTicket(Ticket original, Ticket request){
        original.setId(request.getId());
        original.setReservation(request.getReservation());
        original.setSeat(request.getSeat());
        original.setTicketType(request.getTicketType());
        original.setTicketPrice(request.getTicketPrice());
    }
}
