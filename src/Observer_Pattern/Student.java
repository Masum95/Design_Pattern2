package Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observer {

    private List<Subject> subjectList = new ArrayList<>();
    private String name;

    public Student(String name){
        this.name = name;
    }

    public Observer addSubject(Subject sub)
    {
        subjectList.add(sub);
        sub.subscribe(this);
        return this;
    }

    @Override
    public void getMessage(String message) {
        System.out.println(name + " receives : " +message);
        System.out.println();
    }

    @Override
    public String getName() {
        return name;
    }
}
