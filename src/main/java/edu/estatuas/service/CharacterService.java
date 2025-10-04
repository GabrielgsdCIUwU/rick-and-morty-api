package edu.estatuas.service;

import java.net.URL;
import java.util.List;

import edu.estatuas.model.Character;

public interface CharacterService {
    
    /**
     * Lee personajes desde una URL
     * @param URL  Lee personajes desde una URL
     * @return Lista de personajes
     */
     List<Character> readFromURL(URL url);

    /**
     * Escribe personajes en un archivo
     * @param filepath Ruta del archivo
     * @param characters Lista de personajes
     */
    void writeToFile(String filepath, List<Character> characters);

    /**
     * Importa Characters desde una URL y los almacena en el repositorio
     * @param filePath Ruta del archivo
     */
    void importFromURL(URL url);
    
    /**
     * Exporta Characters del repositorio a un archivo
     * @param filePath Ruta del archivo
     */
    void exportToFile(String filePath);
    
    /**
     * Obtiene todos los Characters
     * @return Lista de Characters
     */
    List<Character> getAll();
    
    /**
     * Obtiene un Character por su id
     * @param id Identificador del Character
     * @return Character
     */
    Character getById(int id);
    
    /**
     * Guarda un Character
     * @param Character Character a guardar
     * @return Character guardado
     */
    Character save(Character character);
    
    /**
     * Actualiza un Character
     * @param id Identificador del Character
     * @param Character Character con los datos actualizados
     * @return Character actualizado
     */
    Character update(int id, Character character);
    
    /**
     * Elimina un Character
     * @param id Identificador del Character
     * @return Character eliminado
     */
    Character delete(int id);
}
