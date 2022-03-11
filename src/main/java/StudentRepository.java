import java.util.ArrayList;
import java.util.List;
public class StudentRepository {
    private String[] studentDatabase ={"jon", "david", "elon", "michelle", "esther"};
    public List<String> getStudentsFromDatabase(){
        List<String> studentsDb = new ArrayList<String>();
        for(String s : studentDatabase){
            studentsDb.add(s);
        }
        return null;
    }
}
