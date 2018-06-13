
package Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Captain implements Observer {


    private List<Subject> subjectList = new ArrayList<>();
    private String name;

    public Captain(String name){
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
        //System.out.println(message);
    }

    public void postMessage(String msg,Subject subject)
    {
        subject.setMessage(msg,this);
    }

    @Override
    public String getName() {
        return name;
    }
}


