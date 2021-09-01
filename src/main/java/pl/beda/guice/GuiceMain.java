package pl.beda.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.extern.java.Log;
import pl.beda.guice.injection.ListFiller;
import pl.beda.guice.injection.injectModule.RepositoryModule;

@Log
public class GuiceMain {
    public static void main(String[] vararg) {

        Injector injector = Guice.createInjector(new RepositoryModule());

        injector.getInstance(ListFiller.class).getUsers();

        ListFiller listFiller = new ListFiller();

        injector.injectMembers(listFiller);
        listFiller.getUsers();
    }
}
