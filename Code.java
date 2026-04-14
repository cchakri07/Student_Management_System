import java.util.*;
class Student{
        int id;
        int age;
        String name;
        String className;

    Student(int id ,int age, String name, String className) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.className = className;
    }
}
class Code{
    static Scanner s = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    static void addStudents(){
        
        System.out.println("Enter student id");
        int id = s.nextInt();
        for(Student i : students){
            if(i.id == id){
                System.out.println("ID already exist. Enter new ID");
                return;
            }
        }
        System.out.println("Enter student age");
        int age = s.nextInt();
        s.nextLine();
        System.out.println("Enter student name");
        String name = s.nextLine();
        System.out.println("Enter student class name");
        String className = s.nextLine();
        students.add(new Student(id,age, name, className));
    }
    static void updateStudents(){
        System.out.println("Enter student id");
        int idd = s.nextInt();
        s.nextLine();
        System.out.println("Enter new student name");
        String name = s.nextLine();
        System.out.println("Enter new student class name");
        String className = s.nextLine();
        System.out.println("Enter student age");
        int age = s.nextInt();
        for(int i = 0;i<students.size();i++){
             if(students.get(i).id == idd){
                students.get(i).name = name;
                students.get(i).className = className;
                students.get(i).age = age;
                System.out.println("Student updated!");
                return;
            }
        }
        
    }

    static void deleteStudent(){
        System.out.println("Enter student id to delete");
        int idd = s.nextInt();
        boolean found = false;
        for(int i =0;i<students.size();i++){
            if(students.get(i).id == idd){
                students.remove(i);
                found = true;
                break;
            }

        }
        if(!found){
            System.out.println("No Such Student");
        }
    }
    static void viewStudent(){
        System.out.println("Enter student id to view");
        int idd = s.nextInt();
        for(int i =0;i<students.size();i++){
            if(students.get(i).id == idd){
                System.out.printf("Age : %d Name: %s id : %d",students.get(i).age,students.get(i).name,students.get(i).id);
            } 
            else{
                System.out.print("No such Student");
            } 
        }
    }


    public static void main(String[] args){
        while(true){
            System.out.println("Want to add student press 1");
            System.out.println("Want to delete student press 2");
            System.out.println("Want to view student press 3");
            System.out.println("Want to update student press 4");
            System.out.println("Want to exit  press 5");
            int choice = s.nextInt();

            
                switch(choice){
                    case 1:
                        addStudents();
                        break;
                    case 2:
                        deleteStudent();
                        break;
                    case 3 :
                        viewStudent();
                        break;
                    case 4:
                        updateStudents();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
            }
        }      
    }        
}