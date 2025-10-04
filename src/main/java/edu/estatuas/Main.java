package edu.estatuas;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import edu.estatuas.repository.CharacterRepositoryImpl;
import edu.estatuas.service.CharacterService;
import edu.estatuas.service.CharacterServiceImpl;
import edu.estatuas.storage.CharacterStorageJson;
import edu.estatuas.model.Character;

public class Main {
    public static void main(String[] args) {
        System.out.println("Wubba Lubba Dub Dub!");

        CharacterService service = new CharacterServiceImpl(
                new CharacterStorageJson(),
                new CharacterRepositoryImpl());

        URL rickAndMortyAPI = null;
        try {
            rickAndMortyAPI = URI.create("https://rickandmortyapi.com/api/character").toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        service.importFromURL(rickAndMortyAPI);

        List<Character> characters = service.getAll();

        // Numero de personajes
        System.out.println("\nTotal personajes:");
        System.out.println(characters.size());

        // Mostrar numero de personajes agrupados por genero
        System.out.println("\nNumero de personajes agrupados por genero:");
        characters.stream()
                .collect(Collectors.groupingBy(c -> c.getGender()))
                .forEach((gender, chars) -> {
                    System.out.println(gender + ": " + chars.size());
                });

        // Mostrar todos los personajes que son de Earth (C-137)
        System.out.println("\nTodos los nombres de los personajes que son de Earth (C-137)");
        characters.stream()
            .filter(c -> "Earth (C-137)".equals(c.getOrigin().get("name").asText()))
            .forEach(c -> {
                System.out.println(c.getName());
            });
    }
}
