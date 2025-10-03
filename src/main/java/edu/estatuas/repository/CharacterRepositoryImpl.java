package edu.estatuas.repository;

import edu.estatuas.model.Character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterRepositoryImpl implements CharacterRepository {
    private final Map<Integer, Character> characters = new HashMap<>();
    /**
     * Obtiene todos los personajes
     *
     * @return Lista de personajes
     */
    @Override
    public List<Character> getAll() {
        return characters.values().stream().toList();
    }

    /**
     * Obtiene un personaje por su id
     *
     * @param integer Identificador del personaje
     * @return El personaje o null si no se encuentra
     */
    @Override
    public Character getById(Integer integer) {
        return characters.get(integer);
    }

    /**
     * Guarda un personaje
     *
     * @param item El personaje a guardar
     * @return El personaje guardado
     */
    @Override
    public Character save(Character item) {
        characters.put(item.getId(), item);
        return item;
    }

    /**
     * Actualiza un personaje
     *
     * @param integer Identificador del personaje
     * @param item    El personaje con los datos actualizados
     * @return El personaje actualizado o null si no se encuentra
     */
    @Override
    public Character update(Integer integer, Character item) {
        return characters.put(integer, item);
    }

    /**
     * Elimina un personaje
     *
     * @param integer Identificador del personaje
     * @return El personaje eliminado o null si no se encuentra
     */
    @Override
    public Character delete(Integer integer) {
        return characters.remove(integer);
    }
}
