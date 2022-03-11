Unit Testing with Mockito


Launch Intellij and click on “New Project” 
Select “Maven” and click “Next”











Name your project “jfs-mockito” and click “Finish”.

Navigate to your java folder in your main directory and create the following classes:
StudentRepository
StudentService

Inside of your StudentRepository class, create an Array of type String and name it studentDatabase. This Array should contain the following names: (“jon”, “david”, “elon”, “michelle”, “esther” ) and should be private.
private String[] studentDatabase

Inside your StudentRepository class, create a method named getStudentsFromDatabase(). This method should create a List of type String and this List should be called studentsFromDb. Your method should add all of the elements from the studentDatabase List into the studentsFromDb List (you could use a for each loop for this. Your getStudentsFromDatabase() method should return your studentsFromDb List.
	public List<String> getStudentsFromDatabase()

Inside your StudentService class, create a field for your StudentRepository class and a constructor. Pass in your StudentRepository class into your constructor.
StudentRepository studentRepository;

   	public StudentService(StudentRepository studentRepository) {
       	this.studentRepository = studentRepository;
   	}

Inside your StudentService class create a method called findNamesWithLetterE() that creates an ArrayList of type String named studentsWithLetterE and then adds students from the studentsFromDb List  who have the letter “e” in their name to this new ArrayList. This method should return the new ArrayList. (You will need to use your getStudentsFromDatabase() method from your StudentRepository class and loop over the names to find those with the letter “e”).
	public List<String> findNamesWithLetterE(){
	List<String> studentsWithLetterE = new ArrayList<>();
	}


Now add JUnit5 (JUnit Jupiter API) and Mockito (Mockito Core) to your project by going to the Maven Repository and putting the dependencies in our pom.xml file: https://mvnrepository.com/
(Remember to add <dependencies></dependencies> to your pom.xml file before pasting in junit and mockito).
May need to refresh your Maven project after you paste in these dependencies.

Inside of your java folder in your test directory, create a TestStudentService class.

Create an instance of your StudentRepository class inside your TestStudentService class.
	StudentRepository studentRepository = new StudentRepository();

Create an instance of your StudentService class inside your TestStudentService class and pass in your studentRepository that you just created so we can test its methods.
	StudentService studentService = new StudentService(studentRepository);

Inside your TestStudentService class, create a method called testFindNamesWithLetterE(). Add the @Test annotation.
	
Inside this method create a List<String> named result and assign the results of studentService.findNamesWithLetterE() to it.
	List<String> result = studentService.findNamesWithLetterE();

Create a List<String> named expected and assign List.of(“elon”, “michelle”, “esther”) to it.
	List<String> expected = List.of("elon", "michelle", "esther");

Use assertEquals and pass in your expected value and your result value. Run your test. It should pass.

Go back to your StudentRepository class and make your getStudentsFromDatabase() method return null, then go back to your TestStudentService class and run your test again. It should fail.

Now we will use Mockito in our test.

Inside your TestStudentService class, comment out StudentRepository studentRepository = new StudentRepository();

Inside your TestStudentService class, create a mock of your StudentRepository class:
	StudentRepository studentRepository = mock(StudentRepository.class);

Inside your testFindNamesWithLetterE() method, use Mockito’s “when” method. (Make sure you add this line of code before all other lines of code in this method)	when(studentRepository.getStudentsFromDatabase()).thenReturn(List.of("jon", "david", "elon", "michelle", "esther"));

Run your test, it should pass now.


To verify that your mock is being used, add the following right after your call to assertEquals.
	verify(studentRepository).getStudentsFromDatabase();

Run your test again, it should still pass. If your mock was not being used your test would now fail.
