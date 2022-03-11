import java.util.ArrayList;
import java.util.List;
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<String> findNamesWithLetterE(){
        List<String> studentsWithLetterE = new ArrayList<String>();
        List<String> studentsFromDb = studentRepository.getStudentsFromDatabase();
        for(String s:studentsFromDb){
            if(s.contains("e")){
                studentsWithLetterE.add(s);
            }
        }
        return studentsWithLetterE;
    }
}
