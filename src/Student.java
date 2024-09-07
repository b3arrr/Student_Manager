class Student {  // Student class with attributes name and grade. This is to be used as object for the grade manager class

    private final String name;

    private final double grade;


    public Student(String name, double grade) {

        this.name = name;

        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

}