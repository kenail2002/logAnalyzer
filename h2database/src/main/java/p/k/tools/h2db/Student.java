package p.k.tools.h2db;

import java.util.Random;

public class Student {


    private long id;
    private String username;
    private String password;
    private int age;

    public Student() {
        this.id = System.currentTimeMillis() * 1000 + new Random().nextInt() % 100;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(this.id);
        sb.append(",username=").append(this.username);
        sb.append(",password=***,age=").append(this.age);
        return sb.toString();
    }
}