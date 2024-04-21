package academy.devdojo.springboot2.controller;

// Importações necessárias

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

// Indica que esta classe é um controlador REST, permitindo que seus métodos manipulem requisições HTTP
@RestController
// Define o caminho base para todas as rotas neste controlador
@RequestMapping("anime")
@Log4j2 // Cria automaticamente um logger estático para a classe, usando Log4j2, para facilitar o logging.
//@Autowired // Injeta automaticamente a dependência marcada neste campo.
// @AllArgsConstructor // Construtor gerado automaticamente com todos os argumentos para as final fields e @NonNull fields.
@RequiredArgsConstructor
// Construtor gerado automaticamente com todos os argumentos para final fields e @NonNull fields, mas não inicializa fields com valor default.
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(DateUtil.formatLocalDateTimeToDatebaseStyle(LocalDateTime.now()));
       // return animeService.listAll(); outro exemplo de boas praticas
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        animeService.save(anime);
        return null;
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}