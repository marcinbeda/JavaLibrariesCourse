package pl.beda.guice.injection.injectModule;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import pl.beda.guice.injection.Repository;


public class RepositoryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("DB_URL")).toInstance("localhost");
        bind(Repository.class).toProvider(pl.beda.guice.injection.injectModule.DatabaseProvider.class).in(Singleton.class);
    }
}
