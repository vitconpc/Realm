package vitcon.example.testrealm.model;

import io.realm.RealmObject;

public class Dog extends RealmObject {
    private String mName;
    private int mAge;

    public Dog() {
    }

    public Dog(String name, int age) {
        mName = name;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
