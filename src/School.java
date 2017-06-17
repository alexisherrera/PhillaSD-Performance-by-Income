/**
 * Created by alexisherrera on 5/2/17.
 */
public class School {

    private String name;
    private int zipcode;
    private int city_rank;
    private int achievement_city_rank;
    private int college_career_rank;
    private int annual_retention_rate;
    private int four_year_grad_rate_cohort;
    private int std_test_not_meeting_thresh;
    private int college_readiness_score_by_student;

    //constructor with all the fields we need to deal with our analysis
    public School(String name, int zipcode, int city_rank, int achievement_city_rank, int college_career_rank,
                  int annual_retention_rate, int four_year_grad_rate_cohort, int std_test_not_meeting_thresh,
                  int college_readiness_score_by_student) {


        //set the fields
        this.name = name;
        this.zipcode = zipcode;
        this.city_rank = city_rank;
        this.achievement_city_rank = achievement_city_rank;
        this.college_career_rank = college_career_rank;
        this.annual_retention_rate = annual_retention_rate;
        this.four_year_grad_rate_cohort = four_year_grad_rate_cohort;
        this.std_test_not_meeting_thresh = std_test_not_meeting_thresh;
        this.college_readiness_score_by_student = college_readiness_score_by_student;

    }

    //method to get name
    public String getName() { return this.name; }

    //method to get zipcode
    public int getZipcode() { return this.zipcode; }

    //method to get city_rank
    public int getCity_rank() {return  this.city_rank; }

    //method to get achievement_city_rank
    public int getAchievement_city_rank() { return this.achievement_city_rank; }

    //method to get college career rank
    public int getCollege_career_rank() { return this.college_career_rank; }

    //method to get annual retention rate
    public int getAnnual_retention_rate() { return this.annual_retention_rate; }

    //method to get the four year graduation rate for a cohort
    public int getFour_year_grad_rate_cohort() { return this.four_year_grad_rate_cohort; }

    //method to get the SAT/ACT % not meeting threshold
    public int getStd_test_not_meeting_thresh() { return this.std_test_not_meeting_thresh; }



    //method to get College and Career readiness score (answered by student)
    public int getCollege_readiness_score_by_student() { return this.college_readiness_score_by_student; }
}
