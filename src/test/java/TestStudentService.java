import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

public class TestStudentService {
//    StudentRepository studentRepository = new StudentRepository();
      StudentRepository studentRepository = mock(StudentRepository.class);
    StudentService studentService = new StudentService(studentRepository);
    @Test
    public void testFindNamesWithLetterE(){
       when(studentRepository.getStudentsFromDatabase()).thenReturn(List.of("jon", "david", "elon", "michelle", "esther"));
        List<String> result = studentService.findNamesWithLetterE();
        List<String> expected = List.of("elon", "michelle", "esther");
        assertEquals(expected, result);
        verify(studentRepository).getStudentsFromDatabase();
    }
}
