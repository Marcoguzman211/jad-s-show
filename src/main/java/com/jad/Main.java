package com.jad;

import com.jad.customer.*;
import com.jad.show.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UtilityClassCanBeEnum")
public final class Main {
    public static void main(final String[] args) {
        final ISpectator jad = new Spectator("Jean-Aymeric", "Diet");

        final ShowFactory showFactory = new ShowFactory() {
            @Override
            public MovieShow makeMovieShow(final String name,
                                           final String description,
                                           final String director,
                                           final String yearOfRelease,
                                           final MovieType movieType) {
                return super.makeMovieShow(name, description, director, yearOfRelease, movieType);
            }

            @Override
            public TheaterShow makeTheaterShow(final String name,
                                              final String description,
                                              final String director,
                                              final String... actors) {
                return super.makeTheaterShow(name, description, director, actors);
            }

            @Override
            public StreetShow makeStreetShow(final String name,
                                            final String description,
                                            final String... performers) {
                return super.makeStreetShow(name, description, performers);
            }

            @Override
            public ConcertShow makeConcertShow(final String name,
                                              final String description,
                                              final String artist) {
                return super.makeConcertShow(name, description, artist);
            }
        };

        final List<IShow> shows = new ArrayList<>();
        shows.add(showFactory.makeMovieShow("Titre du film",
                "Description du film",
                "Nom du réalisateur",
                "2023",
                MovieType.SCIENCE_FICTION));
        shows.add(showFactory.makeTheaterShow("Titre du spectacle de théâtre",
                "Description du spectacle de théâtre",
                "Nom du metteur en scène",
                "Nom de l'acteur 1",
                "Nom de l'acteur 2",
                "Nom de l'acteur 3"));
        shows.add(showFactory.makeStreetShow("Titre du spectacle de rue",
                "Description du spectacle de rue",
                "Nom de l'artiste 1",
                "Nom de l'artiste 2",
                "Nom de l'artiste 3"));
        shows.add(showFactory.makeConcertShow("Titre du concert",
                "Description du concert",
                "Nom de l'artiste ou du groupe"));

        for (final IShow show : shows) {
            jad.watch(show);
        }
    }
}