package model;

public class User {

    private String userId;
    private String name;
    private String password;
    private String phone;

    // Default Constructor
    public User() {

    }

    // Parameterized Constructor
    public User(String userId, String name,
                String password, String phone) {

        this.userId = userId;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Display Method

    public void displayUser() {

        System.out.println("----------------------------");
        System.out.println("User ID : " + userId);
        System.out.println("Name    : " + name);
        System.out.println("Phone   : " + phone);
    }
}