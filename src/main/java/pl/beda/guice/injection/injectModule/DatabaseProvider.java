package pl.beda.guice.injection.injectModule;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import pl.beda.guice.injection.Database;

public class DatabaseProvider implements Provider<Database> {

    @Inject
    @Named("DB_URL")
    private String host;

    @Override
    public Database get() {
        Database repository = new Database();
        repository.setHost(host);
        return repository;
    }
}
