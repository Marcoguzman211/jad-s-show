package com.jad.show.create;

import com.jad.show.IShow;
import com.jad.show.ShowFactory;
import com.jad.show.ShowType;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract handler of the chain of responsibility used to create shows from a description string.
 */
public abstract class CreateShowHandler extends ShowFactory {
    private CreateShowHandler next;
    private final ShowType showType;

    protected CreateShowHandler(final ShowType showType) {
        this.showType = showType;
    }

    /**
     * Sets the next handler of the chain.
     *
     * @param handler The next handler.
     */
    public void setNext(final CreateShowHandler handler) {
        this.next = handler;
    }

    protected ShowType getShowType() {
        return this.showType;
    }

    /**
     * Tries to handle the description or delegates to the next handler of the chain.
     *
     * @param desc The show description.
     * @return The created show or {@code null} if none could be created.
     */
    public IShow handle(final String desc) {
        final IShow show = this.create(desc);
        if (show == null && this.next != null) {
            return this.next.handle(desc);
        }
        return show;
    }

    /**
     * Extracts the key=value pairs of the parameters separated by ';'.
     *
     * @param parameters The string containing the parameters.
     * @return A map with the extracted parameters.
     */
    protected Map<String, String> extractParameters(final String parameters) {
        final Map<String, String> map = new HashMap<>();
        for (final String token : parameters.split(";")) {
            if (token.isEmpty()) {
                continue;
            }
            final String[] kv = token.split("=", 2);
            if (kv.length == 2) {
                map.put(kv[0], kv[1]);
            }
        }
        return map;
    }

    /**
     * Creates a show from the description or returns {@code null} if it cannot handle it.
     *
     * @param desc The show description.
     * @return The created show or {@code null}.
     */
    protected abstract IShow create(String desc);
}

