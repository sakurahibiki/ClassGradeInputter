/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

/**
 *
 * @author Adjatay
 */
public class BusinessLogic {
    private double gpa;
    private double Tpoints;
    private double tCredits;
    private String classification;
    private String standing;
          
    public BusinessLogic() {
        gpa = 0.0;
        tCredits = 0;
        Tpoints = 0;
        classification = new String();
        standing = new String();
        
    }
    public double calculateTotalCredits(DataAccess db) {
       calculateGPA(db);
       return tCredits;
       
    }
    public double calculateTotalPoints(DataAccess db){
        calculateGPA(db);
        return Tpoints;
    }
    public double calculateBySemester(DataAccess db, Integer year, String semester) {
        Tpoints = 0.0;
        for (int i = 0; i < db.getCount(); i++) {
            Course course = db.getCourseAt(i);
            if (course.getSemester().equals(semester) && course.getYear().equals(year)) {
            Tpoints = Tpoints + (course.getPoints() * course.getCredits());
            tCredits = tCredits + (course.getCredits());
            }
            
        }
            
            
        
        
        
        if (tCredits > 0) gpa = Tpoints/tCredits;
            return gpa;
    }
    public double calculateGPA(DataAccess db) {
        Tpoints = 0.0;
        tCredits = 0.0;
        
        for (int i = 0; i < db.getCount(); i++) {
            Course course = db.getCourseAt(i);
            Tpoints += course.getPoints();
            tCredits += course.getCredits();
            
        }
        if (tCredits > 0) gpa = Tpoints / tCredits;
        return gpa;
        
    }
    
    public String getClassification() {
        classification = new String();
        
        if (tCredits >= 90) classification = "Senior";
        if (tCredits >= 60 && tCredits < 90) classification = "Junior";
        if (tCredits >= 30 && tCredits < 60) classification = "Sopohmore";
        if (tCredits < 30) classification = "Freshman";
      
        return classification;
    }
    
    public String getStanding() {
        standing = new String();
        if (gpa >= 3.7) standing = "Honors";
        if (gpa >= 2.0 && gpa < 3.7) standing = "Good Standing";
        if (gpa < 2.0) standing = "Provobation";
        
        return standing;
    }
    //public BusinessLogic();
      public void sort(DataAccess db) {
          for(int i = 0; i < db.getCount(); i++) {
              int min = i;
              for (int k = i; k < db.getCount(); k++) {
                  
                  if (db.getCourseAt(k).comparedTo(db.getCourseAt(min)) < 0){
                      min = k;
                  }
              }
              Course courseA = db.getCourseAt(min);
              Course courseB = db.getCourseAt(i);
              
              db.setCourseAt(courseB, min);
              db.setCourseAt(courseA, i);
              
              
          }
      }  
        
    
}

    

