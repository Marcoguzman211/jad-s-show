package com.jad.show.create;

import com.jad.show.IShow;
import com.jad.show.ShowType;

/**
 * Handler responsible for creating {@link com.jad.show.StreetShow} instances.
 */
public class StreetShowHandler extends CreateShowHandler {
    public StreetShowHandler() {
        super(ShowType.STREET_SHOW);
    }

    @Override
    protected IShow create(final String desc) {
        final String prefix = this.getShowType().name() + ":";
        if (!desc.startsWith(prefix)) {
            return null;
        }
        final var params = this.extractParameters(desc.substring(prefix.length()));
        final String performersParam = params.get("performers");
        final String[] performers = performersParam == null || performersParam.isEmpty() ? new String[0] : performersParam.split(",");
        return this.makeStreetShow(
                params.get("name"),
                params.get("description"),
                performers
        );
    }
}

