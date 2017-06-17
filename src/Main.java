import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    //method to extract rank from string
    public static int extractRank(String zipcode_string) {

        //find the first occurence of a non-digit
        int index = 0;
        for (int i = 0; i < zipcode_string.length(); i++) {
            if (!Character.isDigit(zipcode_string.charAt(i))) { index = i; break; }
        }
        if (index == 0) { return -1; }
        return Integer.parseInt(zipcode_string.substring(0, index));
    }

    public static int extractValue(String s) {
        if (!Character.isDigit(s.charAt(0))) { return -1; }
        return Integer.parseInt(s);
    }

    //main method where we put everything together
    public static void main(String[] args) {

        //make a hashmap with zip codes of philly mapped to incomes
	    PhillyIncomeStats philly_income_stats = new PhillyIncomeStats("http://zipatlas.com/us/pa/philadelphia/zip-code-comparison/median-household-income.htm");
        HashMap<Integer, Double> zip_income_map = philly_income_stats.getMedianIncomeByZipCode();

        //make a hashmap of zipcode objects that maps to int of zipcode with the object
        HashMap<Integer, Zipcode> zipcode_obj_map = new HashMap<>();
        for (Integer zip: zip_income_map.keySet()) {
            zipcode_obj_map.put(zip, new Zipcode(zip, zip_income_map.get(zip)));
        }

        //make array list for schools that are not in the zipcodes we are accounting for
        ArrayList<School> schools_not_in_zips = new ArrayList<>();

        //try and open the CSV file
        try {
            //now we want to create schools by reading the CSV data of Philadelphia schools
            CSVReader reader = new CSVReader(new FileReader("./data/2015_2016_SCHOOL_PROGRESS_REPORT_20170203.csv"));
            String[] next_line;

            //create arraylist of all the schools in Philadelphia we are analyzing
            ArrayList<School> schools = new ArrayList<>();

            int counter = 0;

            //iterate through each line of CSV file
            while ((next_line = reader.readNext()) != null) {

                //first line of CSV file is headers so we should skip it
                if (counter == 0) { counter++; continue; }
                //this school is closed
                if (counter == 75) { counter++; continue; }

                //extract relevant data fields from the CSV files
                String name = next_line[0];
                int zipcode = Integer.parseInt(next_line[7]);
                int city_rank = extractRank(next_line[22]);
                int achievement_city_rank = extractRank(next_line[26]);
                int college_career_rank = extractRank(next_line[38]);
                int annual_retention_rate = Integer.parseInt(next_line[144]);
                int four_year_grad_rate_cohort = extractValue(next_line[177]);
                int std_test_not_meeting_thresh = extractValue(next_line[205]);
                int college_readiness_score_by_student = extractValue(next_line[215]);

                School school_created = new School(name, zipcode, city_rank, achievement_city_rank, college_career_rank,
                        annual_retention_rate, four_year_grad_rate_cohort, std_test_not_meeting_thresh, college_readiness_score_by_student);

                //create schools from data and store in our array list
                schools.add(school_created);

                //add school to corresponding zipcode object
                if (zipcode_obj_map.get(zipcode) != null) {
                    zipcode_obj_map.get(zipcode).addSchool(school_created);
                }

                //if we are not accounting for given zipcode add to our list of schools not in our zip scope
                else { schools_not_in_zips.add(school_created); }
                counter++;
            }

            System.out.println(zipcode_obj_map.size());
            System.out.println(schools_not_in_zips.size());

            //now we can do analysis on our zipcodes (will mostly use excel, so I will print data and copy/paste)
            //a lot of code beyond these lines will be commented out as I will need certain kinds of data
            //to do my analysis

            //data pertaining to the zip codes and their median income alone
            for (Integer key: zip_income_map.keySet()) {
                //System.out.println(key);
                //System.out.println(zip_income_map.get(key));
            }

            //data pertaning to zipcode object I constructed earlier
            for (Integer zip: zipcode_obj_map.keySet()) {
                ArrayList<School> schools_in_zip = zipcode_obj_map.get(zip).getSchools();
                if (schools_in_zip == null) { continue; }
                System.out.print(zip + ",");
                System.out.print(zipcode_obj_map.get(zip).averagePercNotMeetingStdThresh()+ ",");
                System.out.print(zip_income_map.get(zip));
                System.out.println("");

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
