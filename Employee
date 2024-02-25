
public class Employee extends Person
{
    private String department;
    private String title;
    private int hireYear;


    /**
     *
      * @param sName
     * @param iAge
     * @param sDept
     * @param sTitle
     * @param iHireYear
     */
    public Employee(String sName, int iAge, String sDept, String sTitle, int iHireYear)
    {
        super(sName, iAge);
        this.department = sDept;
        this.title = sTitle;
        this.hireYear = iHireYear;
    }


    /**
     *
     * @param sName
     * @param iAge
     * @param sAddress
     * @param sDept
     * @param sTitle
     * @param iHireYear
     */
    public Employee(String sName, int iAge, String sAddress, String sDept, String sTitle, int iHireYear)
    {
        super(sName, iAge, sAddress);
        this.department = sDept;
        this.title = sTitle;
        this.hireYear = iHireYear;
    }


    /**
     *
      * @return
     */
    public String getDepartment() {
        return department;
    }


    /**
     *
      * @param sDepartment
     */
    public void changeDepartment(String sDepartment)
    {
        if (sDepartment == null || sDepartment.isEmpty())
        {
            throw new IllegalArgumentException("Department cannot be empty or null");
        }
        this.department = sDepartment;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }


    /**
     *
      * @param sTitle
     */
    public void changeTitle(String sTitle)
    {
        if (sTitle == null || sTitle.isEmpty())
        {
            throw new IllegalArgumentException("Title cannot be empty or null");
        }
        this.title = sTitle;
    }

    /**
     *
     * @return
     */
    public int getHireYear() {
        return hireYear;
    }

}
