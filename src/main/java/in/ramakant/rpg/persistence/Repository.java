package in.ramakant.rpg.persistence;

import in.ramakant.rpg.common.exceptions.ConfigurationException;

import java.util.Collections;
import java.util.List;

public interface Repository<T> {
    List<T> load() throws ConfigurationException;

    void save(List<T> resource) throws ConfigurationException;

    default T loadOne() throws ConfigurationException {
        List<T> load = load();
        if (load.size() > 1) {
            throw new ConfigurationException("Something is wrong. We are expecting only one entry for this resource.");
        }

        return load.get(0);
    }

    default void saveOne(T entity) throws ConfigurationException {
        List<T> listWithOneResource = Collections.singletonList(entity);
        save(listWithOneResource);
    }
}
