package edu.estatuas.storage;

import edu.estatuas.model.Character;

import java.io.File;
import java.net.URL;
import java.util.List;

public interface CharacterStorage {
    /**
     * Lee Characters desde una URL
     * @param url El url
     * @return Lista de Characters
     * */
    List<Character> readFromUrl(URL url);

     /**
     * Escribe Character a un archivo
     * @param file El archivo donde escribir
     * @param characters Lista de Characters a escribir
     */
    void writeToFile(File file, List<Character> characters);
}
