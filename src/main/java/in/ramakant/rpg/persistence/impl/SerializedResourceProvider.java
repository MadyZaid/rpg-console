package in.ramakant.rpg.persistence.impl;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.common.utils.ExternalIO;
import in.ramakant.rpg.common.utils.InternalIO;
import in.ramakant.rpg.persistence.Repository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public abstract class SerializedResourceProvider<T> implements Repository<T> {

    private static final String PATH_TO_CONFIG_FILES = "config";
    private static final String PATH_TO_SAVED_FILES = "saved";

    public static String configPath() {
        return PATH_TO_CONFIG_FILES;
    }

    public static String savePath() {
        return PATH_TO_SAVED_FILES;
    }

    public List<T> load() throws ConfigurationException {
        try (ObjectInputStream objectInputStream = getObjectInputStream()) {
            List<T> resources = (List<T>) objectInputStream.readObject();
            if (resources == null || resources.isEmpty()) {
                throw new ConfigurationException("loaded configuration is empty");
            }

            return resources;
        } catch (Exception e) {
            return handleException(e);
        }
    }

    private ObjectInputStream getObjectInputStream() throws IOException {
        if (isLoadExternal()) {
            return ExternalIO.objectInputStream(basePath(), getFilename());
        } else {
            return InternalIO.objectInputStream(basePath(), getFilename());
        }
    }

    @Override
    public void save(List<T> resources) throws ConfigurationException {
        System.out.println("Trying to save resources to a file");

        try (ObjectOutputStream objectOutputStream = ExternalIO.objectOutputStream(basePath(), getFilename())) {
            objectOutputStream.writeObject(resources);
            System.out.println("resources saving finished with a success");
        } catch (Exception e) {
            throw new ConfigurationException("Could not save resources, shutting down", e);
        }
    }

    protected abstract List<T> handleException(Exception e) throws ConfigurationException;

    protected abstract String getFilename();

    protected abstract String basePath();

    protected abstract boolean isLoadExternal();
}
