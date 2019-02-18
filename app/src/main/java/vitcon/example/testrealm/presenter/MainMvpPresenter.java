package vitcon.example.testrealm.presenter;

public interface MainMvpPresenter {
    void onDelete(int adapterPosition);

    void addStudent(String name, String age, String numberPhone);

    void loadData();
}
