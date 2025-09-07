package com.jad.show.create;

import com.jad.show.IShow;

/**
 * Singleton holding the chain of {@link CreateShowHandler} used to create shows from descriptions.
 */
public enum CreateShowHandlerChain {
    INSTANCE;

    private final CreateShowHandler first;

    CreateShowHandlerChain() {
        final CreateShowHandler movie = new MovieShowHandler();
        final CreateShowHandler theater = new TheaterShowHandler();
        final CreateShowHandler street = new StreetShowHandler();
        final CreateShowHandler concert = new ConcertShowHandler();
        movie.setNext(theater);
        theater.setNext(street);
        street.setNext(concert);
        this.first = movie;
    }

    public IShow handle(final String description) {
        return this.first.handle(description);
    }
}

