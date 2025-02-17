/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backEnd;

/**
 *
 * @author Adjatay
 */
public class Course {
    private String subject;
    private Integer credits;
    private Character grade;
    private Integer year;
    private String semester; //fall spring summer
    
    
    
    public Course() {
        this.subject = new String();
        this.credits = 0;
        this.grade = ' ';
        this.year = 1851;
        
        this.semester = new String();
} 
    public Course(String s, Integer i, Character c, Integer y, String e) {
        this.subject = s;
        this.credits = i;
        this.grade = c;  
        setYear(y);
        setSemester(e);
    }
    public String getSubject() { return this.subject; }
    public Integer getCredits() { return this.credits; }
    public Character getGrade() { return this.grade; }
    
    public void setSubject(String s) { this.subject = s; }
    public void setCredits(Integer i) { this.credits = i; }
    public void setGrade(Character c) {this.grade = c;  }
    
    public double getPoints() {
        if (grade == 'A') return credits * 4.0;
        if (grade == 'B') return credits * 3.0;
        if (grade == 'C') return credits * 2.0;
        if (grade == 'D') return credits * 1.0;
        return 0.0;
    }
    @Override
    public String toString() { //allows us to print string
     StringBuilder sb = new StringBuilder();
     sb.append(this.subject);
     sb.append(",");
     sb.append(this.credits);
     sb.append(",");
     sb.append(this.grade);
     sb.append(",");
     sb.append(this.year);
     sb.append(",");
     sb.append(this.semester);
     
     
     return sb.toString(); 
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
        
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester.toUpperCase();
      
    }

    /**
     * @return the term
     */
    public long getTerm() {
        if (semester == null) return (year * 100);
        if (semester.equals("SPRING")) return (year * 100 + 3);
        if (semester.equals("SUMMER")) return (year * 100 + 6);
        if (semester.equals("FALL")) return (year * 100 + 9);
        return 0;
    }
    public void parseCourse(String text) { //finds where there are commas (,) and splits them into an array
        String tokens[] = text.split(",");
        
        this.subject = tokens[0];
        this.credits = Integer.parseInt(tokens[1]);
        this.grade = tokens[2].charAt(0);
        setYear(Integer.parseInt(tokens[3]));
        setSemester(tokens[4].toUpperCase());
        
        
    }
    public int comparedTo(Course that) {
        if (this.getTerm() > that.getTerm()) return (+1);
        if (this.getTerm() < that.getTerm()) return (-1);
            
        return 0;
    }
    
    }
  
