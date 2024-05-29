package com.ksa.jodayn.design.patterns;

class MyUrl {
    private String protocol;
    private String host;
    private int port;
    private String path;
    private String query;

    public MyUrl() {

    }

    public MyUrl(String protocol, String host, int port, String path, String query) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.path = path;
        this.query = query;
    }

    static class Builder {
        private MyUrl url = new MyUrl();

        MyUrl build() {
            return url;
        }

        Builder addProtocol(String protocol) {
            url.protocol = protocol;
            return this;
        }

        Builder addHost(String host) {
            url.host = host;
            return this;
        }

        Builder addPort(int port) {
            url.port = port;
            return this;
        }

        Builder addPath(String path) {
            url.path = path;
            return this;
        }

        Builder addQuery(String query) {
            url.query = query;
            return this;
        }
    }
}

class MainW {
    public static void main(String[] args) {


        MyUrl myUrl = new MyUrl.Builder()
                .addHost("google.com")
                .addProtocol("https")
                .addPort(80)
                .addPath("/abc")
                .addQuery("?a=123&y=Abd").build();

        MyUrl.Builder builder = new MyUrl.Builder()
                .addHost("google.com");

        String port = "80";
        if (port !=null){
            builder.addPort(Integer.parseInt(port));
        }

//        builder.build()
    }
}


//URL https://www.google.com:80/abc?a=123&y=Abd

//https
//www
//google.com
//80
//abc
//a=123&y=Abd