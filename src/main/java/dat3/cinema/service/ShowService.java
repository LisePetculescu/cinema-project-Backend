package dat3.cinema.service;

import dat3.cinema.repository.ShowRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    private ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }
}
