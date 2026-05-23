package dto;

public record User(String login, String password) {

    public static User will() {
        return new User("will", "will");
    }

    public static User notWill() {
        return new User("wil", "wil");
    }
}