package com.example.eventdrivenprogramming.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudentDetailsViewModel extends ViewModel {
    private MutableLiveData<String> _studentName = new MutableLiveData<>();
    public LiveData<String>  studentName = _studentName;

    public void setStudentName(String name) {
       _studentName.postValue(name);
    }
    private MutableLiveData<Student> _myStudentObj = new MutableLiveData<>();
    public LiveData<Student> myStudentObj = _myStudentObj;

    public void setMyStudentObj(Student student){
        _myStudentObj.postValue(student);
    }

    private MediatorLiveData<String> fullNameMediatorLiveData=new MediatorLiveData<>();
    private MutableLiveData<String> _fullName = new MutableLiveData<>();
    public LiveData<String> fullName = _fullName;
    public  void setup() {
        fullNameMediatorLiveData.observeForever(s -> {});
        fullNameMediatorLiveData.addSource(_myStudentObj, student ->{
            _fullName.postValue(String .format("%s %s", student.firstName, student.lastName));
        });
    }
}
