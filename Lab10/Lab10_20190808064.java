/**
 * @author Ali Çolak
 * 2.03.2021
 */
public class Lab10_20190808064 {

    public static void main(String[] args) {

    }

}

class Student {

    private int registration ;
    private String name ;

    public void setName(String name) {
        this.name = name;
    }

    public int getRegistration() {
        return registration;
    }
}

class FullTimeStudent extends Student {


}

class PartTimeStudent extends Student {


}


class PhDProgram {

    private String deptName;

    public  void registerCourse (PhDCourse course) {

    }

    public  void registerThesis (PhDThesis course) {

    }
}

interface Course {

    void setInstructorName (String name) ;

}

class PhDCourse implements Course {

    private  int courseCode ;
    private String courseName ;
    private String courseArea ;
    private String courseInstructor ;

    @Override
    public void setInstructorName(String name) {

    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public boolean isInProgram (int dc) {
        return false;
    }
}

class PhDThesis {

    private int thesisCode ;
    private String thesisTopic ;
    private String thesisFields ;

    public int getThesisCode() {
        return thesisCode;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public Student getStudent() {
        return null;
    }

}