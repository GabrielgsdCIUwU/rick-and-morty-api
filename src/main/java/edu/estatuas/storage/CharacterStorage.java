package edu.estatuas.storage;

import edu.estatuas.model.Character;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface CharacterStorage {
    /**
     * Lee Characters desde una URL
     * @param url El url
     * @return Lista de Characters
     * */
    List<Character> readFromUrl(URL url) throws IOException;
}
