package com.jad.show.create;

import com.jad.show.IShow;
import com.jad.show.ShowType;

/**
 * Handler responsible for creating {@link com.jad.show.TheaterShow} instances.
 */
public class TheaterShowHandler extends CreateShowHandler {
    public TheaterShowHandler() {
        super(ShowType.THEATER);
    }

    @Override
    protected IShow create(final String desc) {
        final String prefix = this.getShowType().name() + ":";
        if (!desc.startsWith(prefix)) {
            return null;
        }
        final var params = this.extractParameters(desc.substring(prefix.length()));
        final String actorsParam = params.get("actors");
        final String[] actors = actorsParam == null || actorsParam.isEmpty() ? new String[0] : actorsParam.split(",");
        return this.makeTheaterShow(
                params.get("name"),
                params.get("description"),
                params.get("director"),
                actors
        );
    }
}

