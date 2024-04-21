package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {
    private static List<Anime> animes;

    static {
        // Inicializa a lista com alguns animes pré-definidos
        animes = new ArrayList<>(List.of(new Anime(1L, "Xmen"), new Anime(2L, "CDZ")));
    }

    public List<Anime> listAll() {
        return animes;
    }
    public Anime findById(Long id) {
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3,100000));
        animes.add(anime);
        return anime;
    }

    // Método auxiliar para verificar se um ID já existe na lista
    private boolean idExists(long id) {
        return animes.stream().anyMatch(a -> a.getId() != null && a.getId() == id);
    }

    public void delete(long id) {
        animes.remove(findById(id));
    }
}
