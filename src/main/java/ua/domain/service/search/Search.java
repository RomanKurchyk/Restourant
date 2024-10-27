package ua.domain.service.search;

import ua.domain.api.Identifier;
import ua.domain.service.WorkException;
import java.util.List;

public class Search<E extends Identifier> {

    public static final WorkException DATA_EXCEPTION = new WorkException("Send correct data");
    public static final WorkException FOUND_EXCEPTION = new WorkException("Not found");

    public E searchById(List<E> items, int id) throws WorkException {
        if (items == null || id <= 0) throw DATA_EXCEPTION;

        for (E item : items) {
            if (item != null && item.getId() == id) return item;
        }
        throw FOUND_EXCEPTION;

    }

}


