import java.util.*;
import java.io.*;
class Student{
    int id ;String name;int age;String department;

    Student(int id, String name, int age,String department){
        this.id = id;
        this.age = age;
        this.name = name;
        this.department = department;
    }
}
class Main{
    static Scanner s = new Scanner(System.in);
    static List<Student> x = new ArrayList<>();
    static void saveToFile(){
        try{
            FileWriter fw = new FileWriter("student.txt");
            for(Student st : x){
                fw.write(st.id+","+st.name+","+st.age+","+st.department+"\n");
            }

            fw.close();
        }
        catch(Exception e){
            System.out.println("Error saving file");
        }
    }
    
    static void addDetails(){
        System.out.println("Enter Student ID:");
        int idd = s.nextInt();
        s.nextLine();
        for(Student i : x){
            if(i.id == idd){
                System.out.print("ID Already Exists.");
                return;
            }

        }
        System.out.println("Enter Student Name:");
        String name = s.nextLine();
        System.out.println("Enter Student Age:");
        int age = s.nextInt();
        s.nextLine();
        System.out.println("Enter Student Department:");
        String dep = s.nextLine();

        try{
            FileWriter fw = new FileWriter("student.txt",true);
            
            fw.write(idd+","+name+","+age+","+dep+"\n");
            x.add(new Student(idd,name,age,dep));
            fw.close();
        }
        catch(Exception e){
            System.out.print("Error in addDetails!!!");
        }
    }
    static void readFile(){
        try{
            File f = new File("student.txt");
            if(!f.exists()) return;
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String l = sc.nextLine();
                String[] data = l.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age= Integer.parseInt(data[2]);
                String dep = data[3];
                x.add(new Student(id, name, age, dep));
            }
            sc.close();
        }
        catch(Exception e){
            System.out.print("Error in ReadFile!!!");
        }
    }
    static void updateDetails(){
        boolean found = false;
        System.out.print("Enter ID to Update:");
        int idd = s.nextInt();
        s.nextLine();
        for(Student i : x){
            if(i.id == idd){
                System.out.println("Enter New Name:");
                i.name = s.nextLine();
                System.out.println("Enter New Age:");
                i.age = s.nextInt();
                s.nextLine();
                System.out.println("Enter New Dep:");
                i.department = s.nextLine();
                saveToFile();
                found = true;
                System.out.println("Updated!");
                return;
            }
            if(!found){
                System.out.print("ID NOT FOUND");
            }
        }
    }

    static void deleteDetails(){
        boolean found = false;
        System.out.println("Enter ID to Delete: ");
        int idd = s.nextInt();
        for(int i = 0;i<x.size();i++){
            if(x.get(i).id == idd){
                x.remove(i);
                found = true;
                
            }
        }
        if(found){
            saveToFile();
            System.out.print("ID Removed Successfully!");
        }
        else{
            System.out.print("ID Not Found");
        }
    }

    static void viewDetails(){
        System.out.println("Enter ID to ViewDetails:");
        boolean found = false;
        int idd = s.nextInt();
        for(int i = 0;i<x.size();i++){
            if(x.get(i).id==idd){
                System.out.print("ID: "+x.get(i).id +" Name: "+x.get(i).name+" Age: "+x.get(i).age+" Department: "+ x.get(i).department);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.print("ID not Found");
            return;
        }
    }


    public static void main(String[] args){
        
        readFile();
        while(true){
            System.out.print("\n1.Add Student Detail \n2.Update Details\n3.Delete Details\n4.View Details\n5.Exit\n");
            int choice = s.nextInt();
            switch(choice){
                case 1 -> addDetails();
                case 2 -> updateDetails();
                case 3 -> deleteDetails();
                case 4 -> viewDetails();
                case 5 -> System.exit(0);
                default -> System.out.print("Invalid Choice");
            }

        }
    }
}