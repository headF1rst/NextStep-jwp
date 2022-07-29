package webserver.response;

import http.request.Protocol;

public class StatusLine {

    private Protocol protocol;
    private HttpStatusCode httpStatusCode;

    private StatusLine(Protocol protocol, HttpStatusCode httpStatusCode) {
        this.protocol = protocol;
        this.httpStatusCode = httpStatusCode;
    }

    public static StatusLine of(Protocol protocol, HttpStatusCode httpStatusCode) {
        return new StatusLine(protocol, httpStatusCode);
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public HttpStatusCode getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
