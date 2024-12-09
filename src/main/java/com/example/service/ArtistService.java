package com.example.service;


import com.example.domain.Artist;
import com.example.repository.IRepository;
import com.example.repository.RepositoryException;

public class ArtistService {
    IRepository<Artist> artistRepo;

    public ArtistService(IRepository<Artist> artistRepo) {
        // NOTE Injectam dependenta la repository prin constructor
        this.artistRepo = artistRepo;
    }

    public void addArtist(int id, String name, String genre) throws RepositoryException {
        Artist art = new Artist(id, name, genre);
        // TODO Validari!?
        artistRepo.add(art);
    }

}
