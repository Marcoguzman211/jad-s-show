package com.jad.show.create;

import com.jad.show.IShow;
import com.jad.show.MovieType;
import com.jad.show.ShowType;

/**
 * Handler responsible for creating {@link com.jad.show.MovieShow} instances.
 */
public class MovieShowHandler extends CreateShowHandler {
    public MovieShowHandler() {
        super(ShowType.MOVIE);
    }

    @Override
    protected IShow create(final String desc) {
        final String prefix = this.getShowType().name() + ":";
        if (!desc.startsWith(prefix)) {
            return null;
        }
        final var params = this.extractParameters(desc.substring(prefix.length()));
        return this.makeMovieShow(
                params.get("name"),
                params.get("description"),
                params.get("director"),
                params.get("yearOfRelease"),
                MovieType.valueOf(params.get("movieType"))
        );
    }
}

