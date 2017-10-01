package p.k.tools.h2db;

public class Student {
    private String username;
    private String password;
    private int age;

    public Student() {
    }

    public Student(String us1, String pd, int age1) {
        this();
        this.username = us1;
        this.password = pd;
        this.age = age1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}