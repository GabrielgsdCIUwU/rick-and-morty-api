package edu.estatuas.storage;


import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.estatuas.model.Character;
import edu.estatuas.model.CharacterResponse;

public class CharacterStorageJson implements CharacterStorage {

    @Override
    public List<Character> readFromUrl(URL url) {
        List<Character> allCharacters = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpClient client = HttpClient.newHttpClient();
            String nextUrl = url.toString();

            while (nextUrl != null) {
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(nextUrl))
                    .GET()
                    .build();
                
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                CharacterResponse data = mapper.readValue(response.body(), CharacterResponse.class);

                allCharacters.addAll(data.getResults());
                nextUrl = data.getInfo().getNext();
            }

            
            return allCharacters;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void writeToFile(File file, List<Character> characters) {
        if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
            throw new IllegalArgumentException("El archivo no existe en el sistema o no se puede leer: " + file);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, characters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
