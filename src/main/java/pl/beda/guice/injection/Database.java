package pl.beda.guice.injection;

import lombok.extern.java.Log;

@Log
public class Database implements Repository {

    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public void getUsers() {
        log.info(host);
        log.info(toString());
    }
}
