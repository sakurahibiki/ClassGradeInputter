/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package backEnd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileReader;

/**
 *
 * @author Adjatay
 */
public class DataAccess {
    private Course[] courses;
    private int count;
    
    public DataAccess() {
        courses = new Course[100];
        count = 0;
    }
    public int getCount() { return this.count; }
    
    public Course getCourseAt(int idx) {return this.courses[idx];}
    
    public boolean addCourse (Course crn) {
        if (count < 100) {
        courses[count++] =  crn;
        return true;
        }
        return false;
    }
    public void open(String filename) {
        
        try {
            FileReader file = new FileReader(filename);
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                Course course = new Course();
                course.parseCourse(line);
                addCourse(course);
            }
            scanner.close();
        } catch (Exception ex) {
        System.err.println("Couldn't read into " + filename);
        }
        
        
    }
    public void save(String filename) {
        try {
            FileWriter file = new FileWriter(filename);
            BufferedWriter buffer = new BufferedWriter(file);
            
            for (int i = 0; i < count; i++) {
                buffer.append(courses[i].toString());
                buffer.append("\n");
                
            }
           buffer.close();
        } catch (Exception ex) {
        System.err.println("Couldn't write into " + filename);
        }
        
    }

    void setCourseAt(Course course, int idx) {
        courses[idx] = course;
    }
}
