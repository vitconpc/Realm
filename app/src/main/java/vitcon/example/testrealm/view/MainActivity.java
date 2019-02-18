package vitcon.example.testrealm.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import vitcon.example.testrealm.R;
import vitcon.example.testrealm.custom.StudentAdapter;
import vitcon.example.testrealm.custom.StudentCallback;
import vitcon.example.testrealm.presenter.MainMvpPresenter;
import vitcon.example.testrealm.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements StudentCallback, MainView {

    private EditText mEdtName;
    private EditText mEdtAge;
    private EditText mEdtNumberPhone;
    private RecyclerView mRecyclerView;
    private MainMvpPresenter mPresenter;
    private StudentAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mPresenter = new MainPresenter(this,this);
        mAdapter = new StudentAdapter(this,((MainPresenter) mPresenter).getStudents(),this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.loadData();
    }

    private void initView() {
        mEdtName = findViewById(R.id.edt_name);
        mEdtAge = findViewById(R.id.edt_age);
        mEdtNumberPhone = findViewById(R.id.edt_sdt);
        mRecyclerView = findViewById(R.id.rv_list_people);
    }

    public void add(View view) {
        mPresenter.addStudent(mEdtName.getText().toString().trim(),mEdtAge.getText().toString().trim(),mEdtNumberPhone.getText().toString().trim());
    }

    @Override
    public void longClick(int adapterPosition) {
        mPresenter.onDelete(adapterPosition);
    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void notifidata() {
        mAdapter.notifyDataSetChanged();
    }
}
