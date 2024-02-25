public class Student extends Person
{
    private double gpa;
    private String major;
    private int gradYear;

    /**
     *
     * @param sName
     * @param iAge
     * @param sMajor
     * @param iGradYear
     */
    public Student(String sName, int iAge, String sMajor, int iGradYear)
    {
        super(sName, iAge);
        this.gpa = 0.0;
        this.major = sMajor;
        this.gradYear = iGradYear;
    }

    /**
     *
     * @param sName
     * @param iAge
     * @param sAddress
     * @param sMajor
     * @param iGradYear
     */
    public Student(String sName, int iAge, String sAddress, String sMajor, int iGradYear)
    {
        super(sName, iAge, sAddress);
        this.gpa = 0.0;
        this.major = sMajor;
        this.gradYear = iGradYear;
    }

    /**
     *
     * @return
     */
    public double getGPA() {
        return gpa;
    }

    /**
     *
     * @param newGpa
     */
    public void setGPA(double newGpa)
    {
        if (newGpa < 0 || newGpa > 4)
        {
            throw new IllegalArgumentException("GPA must be between 0 and 4");
        }
        this.gpa = newGpa;
    }

    /**
     *
     * @return
     */
    public String getMajor()
    {
        return major;
    }

    /**
     *
     * @param newMajor
     */
    public void setMajor(String newMajor)
    {
        if (newMajor == null || newMajor.isEmpty())
        {
            throw new IllegalArgumentException("Major cannot be empty or null");
        }
        this.major = newMajor;
    }

    /**
     *
     * @return
     */
    public int getGraduationYear()
    {
        return gradYear;
    }

    /**
     *
     * @param newGradYear
     */
    public void setGraduationYear(int newGradYear)
    {
        this.gradYear = newGradYear;
    }
}
