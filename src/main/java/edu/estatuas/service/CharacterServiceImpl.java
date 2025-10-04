package edu.estatuas.service;

import java.io.File;
import java.net.URL;
import java.util.List;

import edu.estatuas.model.Character;
import edu.estatuas.repository.CharacterRepository;
import edu.estatuas.storage.CharacterStorage;

public class CharacterServiceImpl implements CharacterService {

    private final CharacterStorage storage;
    private final CharacterRepository repository;

    public CharacterServiceImpl(CharacterStorage storage, CharacterRepository repository) {
        this.storage = storage;
        this.repository = repository;
    }

    @Override
    public List<Character> readFromURL(URL url) {
        return storage.readFromUrl(url);
    }

    @Override
    public void importFromURL(URL url) {
        readFromURL(url).forEach(repository::save);
    }

    @Override
    public void writeToFile(String filepath, List<Character> characters) {
        storage.writeToFile(new File(filepath), characters);
    }

    @Override
    public void exportToFile(String filePath) {
        writeToFile(filePath, getAll());
    }

    @Override
    public List<Character> getAll() {
        return repository.getAll();
    }

    @Override
    public Character getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Character save(Character character) {
        return repository.save(character);
    }

    @Override
    public Character update(int id, Character character) {
        return repository.update(id, character);
    }

    @Override
    public Character delete(int id) {
        return repository.delete(id);
    }


}
