package dat3.cinema.api;

import dat3.cinema.entity.Ticket;
import dat3.cinema.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Get all tickets path
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping
    public Ticket addTicket(@RequestBody Ticket request){return ticketService.addTicket(request);}
}
