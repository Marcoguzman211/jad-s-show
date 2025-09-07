package com.jad.show.create;

import com.jad.show.IShow;
import com.jad.show.ShowType;

/**
 * Handler responsible for creating {@link com.jad.show.ConcertShow} instances.
 */
public class ConcertShowHandler extends CreateShowHandler {
    public ConcertShowHandler() {
        super(ShowType.CONCERT);
    }

    @Override
    protected IShow create(final String desc) {
        final String prefix = this.getShowType().name() + ":";
        if (!desc.startsWith(prefix)) {
            return null;
        }
        final var params = this.extractParameters(desc.substring(prefix.length()));
        return this.makeConcertShow(
                params.get("name"),
                params.get("description"),
                params.get("artist")
        );
    }
}

