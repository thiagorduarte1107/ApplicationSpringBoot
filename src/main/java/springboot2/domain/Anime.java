package academy.devdojo.springboot2.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class Anime {
    private Long id;
    private String name;
    public Anime(String name) {
        this.id = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
        this.name = name;
    }
}
