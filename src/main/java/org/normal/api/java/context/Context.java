package org.normal.api.java.context;

import java.util.Optional;
import java.util.UUID;

public interface Context<T extends ContextType> {

    T getType();

    <Z> Optional<Z> getData(String key, Class<Z> type);

    default Optional<String> getId() {
        return getData("id", String.class);
    }

    default Optional<String> getName() {
        return getData("name", String.class);
    }

    default Optional<UUID> getUuid() {
        return getData("uuid", UUID.class);
    }

    <Z> void putData(String key, Z value);

}
