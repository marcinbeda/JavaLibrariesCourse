package pl.beda.guice.injection;

import com.google.inject.Inject;

public class ListFiller {

    @Inject
    private Repository repository;

    public void getUsers() {
        repository.getUsers();
    }
}
