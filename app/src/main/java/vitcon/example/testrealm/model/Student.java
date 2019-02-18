package vitcon.example.testrealm.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Student extends RealmObject {
    private String mName;
    private int mAge;
    private String mNumberPhone;
//    private RealmList<Dog> mDogs;


    public Student() {
    }

    public Student(String name, int age, String numberPhone) {
        mName = name;
        mAge = age;
        mNumberPhone = numberPhone;
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

    public String getNumberPhone() {
        return mNumberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        mNumberPhone = numberPhone;
    }

//    public RealmList<Dog> getDogs() {
//        return mDogs;
//    }
//
//    public void setDogs(RealmList<Dog> dogs) {
//        mDogs = dogs;
//    }
}
