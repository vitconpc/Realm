package vitcon.example.testrealm.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vitcon.example.testrealm.R;
import vitcon.example.testrealm.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context mContext;
    private List<Student> mStudents;
    private StudentCallback mStudentCallback;

    public StudentAdapter(Context context, List<Student> students, StudentCallback studentCallback) {
        mContext = context;
        mStudents = students;
        mStudentCallback = studentCallback;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new StudentViewHolder(LayoutInflater.from(mContext).inflate(R.layout.custom_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        studentViewHolder.bindData(mStudents.get(i));
    }

    @Override
    public int getItemCount() {
        return mStudents == null ? 0 : mStudents.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private TextView mTxtName;
        private TextView mTxtAge;
        private TextView mTxtNumberPhone;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtAge = itemView.findViewById(R.id.txt_age);
            mTxtName = itemView.findViewById(R.id.txt_name);
            mTxtNumberPhone = itemView.findViewById(R.id.txt_number_phone);
            itemView.setOnLongClickListener(this);
        }

        public void bindData(Student student) {
            mTxtName.setText(student.getName());
            mTxtAge.setText(student.getAge()+"");
            mTxtNumberPhone.setText(student.getNumberPhone());
        }

        @Override
        public boolean onLongClick(View v) {
            mStudentCallback.longClick(getAdapterPosition());
            return false;
        }
    }
}
