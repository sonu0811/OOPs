import java.util.Date;
//Candidate Base class
abstract class Candidate {
 private String name;
 private Date dateOfBirth;
 private int hscAggregate;
 private float ugCgpa;
 private float pgCgpa;
 private int numProjects;
 private int interviewMarks;
 private boolean isFullTime;
 private boolean isIndianCitizen;
 public Candidate(String name, Date dateOfBirth, int hscAggregate,
float
 ugCgpa, float pgCgpa, int numProjects,
 int interviewMarks, boolean isFullTime, boolean
 isIndianCitizen) {
 this.name = name;
 this.dateOfBirth = dateOfBirth;
 this.hscAggregate = hscAggregate;
 this.ugCgpa = ugCgpa;
 this.pgCgpa = pgCgpa;
 this.numProjects = numProjects;
 this.interviewMarks = interviewMarks;
 this.isFullTime = isFullTime;
 this.isIndianCitizen = isIndianCitizen;
 }
 public String getName() {
 return name;
 }
 public Date getDateOfBirth() {
 return dateOfBirth;
 }
 public int getHscAggregate() {
 return hscAggregate;
 } 
 public float getUgCgpa() {
    return ugCgpa;
    }
    public float getPgCgpa() {
    return pgCgpa;
    }
    public int getNumProjects() {
    return numProjects;
    }
    public int getInterviewMarks() {
    return interviewMarks;
    }
    public boolean isFullTime() {
    return isFullTime;
    }
    public boolean isIndianCitizen() {
    return isIndianCitizen;
    }
   // Abstract method to calculate final marks, to be implemented by each subclass
    public abstract float calculateFinalMarks();
   }
   //SCSTCandidate Class
   class SCSTCandidate extends Candidate {
    private int pcmAverageMarks;
    public SCSTCandidate(String name, Date dateOfBirth, int hscAggregate,
    float ugCgpa, float pgCgpa, int numProjects,int interviewMarks, boolean
   isFullTime, boolean isIndianCitizen, int pcmAverageMarks)
    {
    super(name, dateOfBirth, hscAggregate, ugCgpa, pgCgpa,
   numProjects,interviewMarks, isFullTime,isIndianCitizen);
    this.pcmAverageMarks = pcmAverageMarks;
    }
    @Override
    public float calculateFinalMarks() {
    // Calculate final marks based on the given formula
    return (0.5f * getHscAggregate()) + (0.2f * getUgCgpa()) + (0.2f *
   getPgCgpa()) + (0.1f * getInterviewMarks());
    } 
    public int getPcmAverageMarks() {
        return pcmAverageMarks;
        }
        }
       
       // RecuritingTeam Class
       class RecruitingTeam {
        public boolean checkEligibility(Candidate candidate) {
        // Check eligibility based on the given criteria
        if (candidate.getDateOfBirth().compareTo(new Date(1999, 6, 30)) < 0)
        {
        return false;
        }
        if (candidate.getHscAggregate() < 60) {
        return false;
        }
        if (candidate instanceof SCSTCandidate) {
        if (((SCSTCandidate) candidate).getPcmAverageMarks() < 50) {
        return false;
        }
        }
        if (candidate.getUgCgpa() < 8) {
        return false;
        }
        if (candidate.getPgCgpa() < 8) {
        return false;
        }
        if (candidate.getNumProjects() < 2) {
        return false;
        }
        if (!candidate.isFullTime()) {
        return false;
        }
        if (candidate.getInterviewMarks() < 35) {
        return false; 
    }
    if (!candidate.isIndianCitizen()) {
    return false;
    }
    return true;
   
    }
   }
   // HR Class
   class HRTeam {
    public void notifyCandidate(Candidate candidate, boolean isAccepted) {
    if (isAccepted) {
    System.out.println(candidate.getName() + " has been accepted.");
    } else {
    System.out.println(candidate.getName() + " has been rejected.");
    }
   
    }
   }
   public class function {
    public static void main(String[] args) {
    RecruitingTeam recruitingTeam = new RecruitingTeam();
    HRTeam hrTeam = new HRTeam();
    SCSTCandidate candidate1 = new SCSTCandidate("Hiren", new Date(2001, 7, 1), 
   84, 9, 9, 2, 96, true, true, 94);
    SCSTCandidate candidate2 = new SCSTCandidate("Sonu", new Date(2001, 5, 1),
   70, 8, 8, 2, 80, true, true, 85);
    SCSTCandidate candidate3 = new SCSTCandidate("Arohan", new Date(2002, 1, 1),
   50, 9, 9, 2, 50, true, true, 90);
   // Check eligibility and notify candidates
    boolean isAccepted1 = recruitingTeam.checkEligibility(candidate1);
    hrTeam.notifyCandidate(candidate1, isAccepted1);
    boolean isAccepted2 = recruitingTeam.checkEligibility(candidate2);
    hrTeam.notifyCandidate(candidate2, isAccepted2);
    boolean isAccepted3 = recruitingTeam.checkEligibility(candidate3);
    hrTeam.notifyCandidate(candidate3, isAccepted3);
    // Output final marks of accepted candidates
    if (isAccepted1) { 
        System.out.println(candidate1.getName() + " has final marks of "
        + candidate1.calculateFinalMarks());
        }
        if (isAccepted2) {
        System.out.println(candidate2.getName() + " has final marks of "
        + candidate2.calculateFinalMarks());
        }
        if (isAccepted3) {
        System.out.println(candidate3.getName() + " has final marks of "
        + candidate3.calculateFinalMarks());
        }
       }
       } 
       
