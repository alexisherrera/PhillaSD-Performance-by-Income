import java.util.ArrayList;

/**
 * Created by alexisherrera on 5/2/17.
 */
public class Zipcode {

    private int zipcode;
    private double median_income;
    private ArrayList<School> schools_in_zip;

    //constructor for our zipcode object
    public Zipcode(int zipcode, double median_income) {
        this.zipcode = zipcode;
        this.median_income = median_income;
        schools_in_zip = new ArrayList<>();
    }

    //method to add schools in this zipcode
    public void addSchool(School school) {
        schools_in_zip.add(school);
    }

    //method to get schools in the area (or null if none )
    public ArrayList<School> getSchools() {
        if (schools_in_zip.size() == 0) { return null; }
        return schools_in_zip;
    }

    //method to get number of schools in zipcode
    public int numberOfSchools() {
        return schools_in_zip.size();
    }

    //method to return the school with the lowest city rank (or null if no schools in zipcode)
    public School lowestCityRank() {
        School min = null;
        int min_val = Integer.MAX_VALUE;
        for (School s: schools_in_zip) {
            if (s.getCity_rank() == -1) { continue; } //skip if an invalid file
            if (s.getCity_rank() < min_val) {
                min_val = s.getCity_rank();
                min = s;
            }
        }
        return min;
    }

    //method to return the school with the highest city rank (or null if no schools in zipcode)
    public School highestCityRank() {
        School max = null;
        int max_val = 0;
        for (School s: schools_in_zip) {
            if (s.getCity_rank() == -1) {
                continue;
            } //skip if an invalid file
            if (s.getCity_rank() > max_val) {
                max_val = s.getCity_rank();
                max = s;
            }
        }
        return max;
    }

    //method to return the average city rank within the school district (or -1 if no schools in the zipcode)
    public int averageCityRank() {
        if (schools_in_zip.size() == 0) { return -1; }
        int avg = 0;
        for (School s: schools_in_zip) {
            avg = avg + s.getCity_rank();
        }
        return (avg / schools_in_zip.size());
    }

    //method to return the school with the lowest achievement score city rank (or null if no schools in zipcode)
    public School lowestAchievementCityRank() {
        School min = null;
        int min_val = Integer.MAX_VALUE;
        for (School s: schools_in_zip) {
            if (s.getAchievement_city_rank() == -1) { continue; } //skip if an invalid file
            if (s.getAchievement_city_rank() < min_val) {
                min_val = s.getAchievement_city_rank();
                min = s;
            }
        }
        return min;
    }

    //method to return the school with the highest achievement score city rank (or null if no schools in zipcode)
    public School highestAchievementCityRank() {
        School max = null;
        int max_val = 0;
        for (School s: schools_in_zip) {
            if (s.getAchievement_city_rank() == -1) { continue; } //skip if an invalid file
            if (s.getAchievement_city_rank() > max_val) {
                max_val = s.getAchievement_city_rank();
                max = s;
            }
        }
        return max;
    }

    //method to return the average achievement score city rank (or -1 if no schools in zipcode)
    public int averageAchievementCityRank() {
        if (schools_in_zip.size() == 0) { return -1; }
        int avg = 0;
        for (School s: schools_in_zip) {
            avg = avg + s.getAchievement_city_rank();
        }
        return (avg / schools_in_zip.size());
    }

    //method to return the school with the lowest college and career city rank (or null if no schools in zipcode)
    public School lowestCollegeCareerCityRank() {
        School min = null;
        int min_val = Integer.MAX_VALUE;
        for (School s: schools_in_zip) {
            if (s.getCollege_career_rank() == -1) { continue; } //skip if an invalid file
            if (s.getCollege_career_rank() < min_val) {
                min_val = s.getCollege_career_rank();
                min = s;
            }
        }
        return min;
    }

    //method to return the school with the highest college and career city rank (or null if no schools in zipcode)
    public School highestCollegeCareerCityRank() {
        School max = null;
        int max_val = 0;
        for (School s: schools_in_zip) {
            if (s.getCollege_career_rank() == -1) { continue; } //skip if an invalid file
            if (s.getCollege_career_rank() > max_val) {
                max_val = s.getCollege_career_rank();
                max = s;
            }
        }
        return max;
    }

    //method to return the average college and career city rank (or -1 if no schools in zipcode)
    public int averageCollegeCareerCityRank() {
        if (schools_in_zip.size() == 0) { return -1; }
        int avg = 0;
        for (School s: schools_in_zip) {
            avg = avg + s.getCollege_career_rank();
        }
        return (avg / schools_in_zip.size());
    }

    //method to return the school with the lowest annual retention rate (or null if no schools in zipcode)
    public School lowestAnnualRetentionRate() {
        School min = null;
        int min_val = Integer.MAX_VALUE;
        for (School s: schools_in_zip) {
            if (s.getAnnual_retention_rate() == -1) { continue; } //skip if an invalid file
            if (s.getAnnual_retention_rate() < min_val) {
                min_val = s.getAnnual_retention_rate();
                min = s;
            }
        }
        return min;
    }

    //method to return the school with the highest annual retention rate (or null if no schools in zipcode)
    public School highestAnnualRetentionRate() {
        School max = null;
        int max_val = 0;
        for (School s: schools_in_zip) {
            if (s.getAnnual_retention_rate() == -1) { continue; } //skip if an invalid file
            if (s.getAnnual_retention_rate() > max_val) {
                max_val = s.getAnnual_retention_rate();
                max = s;
            }
        }
        return max;
    }

    //method to return the average annual retention rate (or -1 if no schools in zipcode)
    public int averageAnnualRetentionRate() {
        if (schools_in_zip.size() == 0) { return -1; }
        int avg = 0;
        for (School s: schools_in_zip) {
            avg = avg + s.getAnnual_retention_rate();
        }
        return (avg / schools_in_zip.size());
    }

    //method to return the school with the lowest 4-year grad rate (or null if no schools in zipcode)
    public School lowest4YearGradRate() {
        School min = null;
        int min_val = Integer.MAX_VALUE;
        for (School s: schools_in_zip) {
            if (s.getFour_year_grad_rate_cohort() == -1) { continue; } //skip if an invalid file
            if (s.getFour_year_grad_rate_cohort() < min_val) {
                min_val = s.getFour_year_grad_rate_cohort();
                min = s;
            }
        }
        return min;
    }

    //method to return the school with the highest 4-year grad rate (or null if no schools in zipcode)
    public School highest4YearGradRate() {
        School max = null;
        int max_val = 0;
        for (School s: schools_in_zip) {
            if (s.getFour_year_grad_rate_cohort() == -1) { continue; } //skip if an invalid file
            if (s.getFour_year_grad_rate_cohort() > max_val) {
                max_val = s.getFour_year_grad_rate_cohort();
                max = s;
            }
        }
        return max;
    }

    //method to return the average 4-year grad rate (or -1 if no schools in zipcode)
    public int average4YearGradRate() {
        if (schools_in_zip.size() == 0) { return -1; }
        int avg = 0;
        for (School s: schools_in_zip) {
            avg = avg + s.getFour_year_grad_rate_cohort();
        }
        return (avg / schools_in_zip.size());
    }

    //method to return the school with the lowest percentage of students not meeting
    //SAT/ACT minimum threshold (or null if no schools in zipcode)
    public School lowestPercNotMeetingStdThresh() {
        School min = null;
        int min_val = Integer.MAX_VALUE;
        for (School s: schools_in_zip) {
            if (s.getStd_test_not_meeting_thresh() == -1) { continue; } //skip if an invalid file
            if (s.getStd_test_not_meeting_thresh() < min_val) {
                min_val = s.getStd_test_not_meeting_thresh();
                min = s;
            }
        }
        return min;
    }

    //method to return the school with the highest percentage of students not meeting
    //SAT/ACT minimum threshold (or null if no schools in zipcode)
    public School highestPercNotMeetingStdThresh() {
        School max = null;
        int max_val = 0;
        for (School s: schools_in_zip) {
            if (s.getStd_test_not_meeting_thresh() == -1) { continue; } //skip if an invalid file
            if (s.getStd_test_not_meeting_thresh() > max_val) {
                max_val = s.getStd_test_not_meeting_thresh();
                max = s;
            }
        }
        return max;
    }

    //method to return the average percentage of students not meeting SAT/ACT minimum threshold (or null if no schools in zipcode)
    public int averagePercNotMeetingStdThresh() {
        if (schools_in_zip.size() == 0) { return -1; }
        int avg = 0;
        for (School s: schools_in_zip) {
            avg = avg + s.getStd_test_not_meeting_thresh();
        }
        return (avg / schools_in_zip.size());
    }

    //method to return the school with the lowest college/career readiness score as perceived
    //by students(or null if no schools in zipcode)
    public School lowestCollegeCareerReadinessStudent() {
        School min = null;
        int min_val = Integer.MAX_VALUE;
        for (School s: schools_in_zip) {
            if (s.getCollege_readiness_score_by_student() == -1) { continue; } //skip if an invalid file
            if (s.getCollege_readiness_score_by_student() < min_val) {
                min_val = s.getCollege_readiness_score_by_student();
                min = s;
            }
        }
        return min;
    }

    //method to return the school with the highest college/career readiness score as perceived
    //by students(or null if no schools in zipcode)
    public School highestCollegeCareerReadinessStudent() {
        School max = null;
        int max_val = 0;
        for (School s: schools_in_zip) {
            if (s.getCollege_readiness_score_by_student() == -1) { continue; } //skip if an invalid file
            if (s.getCollege_readiness_score_by_student() > max_val) {
                max_val = s.getCollege_readiness_score_by_student();
                max = s;
            }
        }
        return max;
    }

    //method to return the average college/career readiness score as perceived by students (or -1 if no schools in zipcode)
    public int averageCollegeCareerReadinessStudent() {
        if (schools_in_zip.size() == 0) { return -1; }
        int avg = 0;
        for (School s: schools_in_zip) {
            avg = avg + s.getCollege_readiness_score_by_student();
        }
        return (avg / schools_in_zip.size());
    }




}
