package vitcon.example.testrealm.presenter;

import android.content.Context;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.internal.Util;
import vitcon.example.testrealm.model.Student;
import vitcon.example.testrealm.view.MainView;

public class MainPresenter implements MainMvpPresenter {

    private Context mContext;
    private MainView mMainView;
    private List<Student> mStudents;
    private Realm mRealm;

    public MainPresenter(Context context, MainView mainView) {
        mContext = context;
        mMainView = mainView;
        mStudents = new ArrayList<>();
        mRealm.init(mContext);
        mRealm = Realm.getDefaultInstance();
    }

    public List<Student> getStudents() {
        return mStudents;
    }

    public void setStudents(List<Student> students) {
        mStudents = students;
    }

    @Override
    public void onDelete(int adapterPosition) {
        //todo delete student
    }

    @Override
    public void addStudent(String name, String age, String numberPhone) {
        if (TextUtils.isEmpty(name)){
            mMainView.setError("tên rỗng");
            return;
        }
        if (TextUtils.isEmpty(age)){
            mMainView.setError("tuổi sai");
            return;
        }
        if (TextUtils.isEmpty(numberPhone)){
            mMainView.setError("số điện thoại rỗng");
            return;
        }
        Student student = new Student(name,Integer.valueOf(age),numberPhone);
        mStudents.add(student);
        mMainView.notifidata();
        //todo save student
//        mRealm.beginTransaction();
//        mRealm.copyToRealm(student);
//        mRealm.commitTransaction();
    }

    @Override
    public void loadData() {
        mRealm.beginTransaction();
        RealmResults<Student> students = mRealm.where(Student.class).findAll();
        mStudents = students;
        mMainView.notifidata();
        mRealm.commitTransaction();
    }
}
