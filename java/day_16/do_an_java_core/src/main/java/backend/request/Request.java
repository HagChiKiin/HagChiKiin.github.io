package backend.request;

public class Request {
    private String userName;
    private String email;
    private String passWord;

    public Request(String userName) {
        this.userName = userName;

    }

    public Request(String email, String userName) {
        this.userName = userName;
        this.email = email;
    }

    public Request(String passWord, String userName, String email) {
        this.passWord = passWord;
        this.email = email;
        this.userName = userName;
    }
}
