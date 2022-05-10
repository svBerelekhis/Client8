package object;

import java.io.Serializable;

public class Request implements Serializable {
    private final String request;

    public Request(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }
}
