package Day_04;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by george.gligor on 2/5/2015.
 */
public class Day5Ex3Problems {

    @Test(description = "Create a list of strings. Assert that:..")
    public void list(){


        List myListofStrings = new ArrayList<String>();
        List myEmptyList = new ArrayList<String>();

        myListofStrings.add("Testing");
        myListofStrings.add("T");
        myListofStrings.add("Test");
        myListofStrings.add("Ting");


        //the list contains $someItem.
        /*assertThat(myListofStrings, hasItem("Test"));
        assertThat(myListofStrings, contains("hjk"));

        assertThat(myListofStrings, not(hasItem("ing")));
        assertThat(myListofStrings, not(hasItem("")));
        assertThat(myListofStrings, not(hasItem("dfdgf")));

        assertThat(myListofStrings, allOf(hasSize(greaterThan(5)),hasSize(greaterThanOrEqualTo(4))));
        assertThat(myListofStrings, anyOf(hasSize(greaterThan(5)),hasSize(greaterThanOrEqualTo(4))));

        assertThat(myListofStrings, anyOf(hasItem(startsWith("Test")), hasItem(endsWith("g"))));
        assertThat(myListofStrings, allOf(hasItem(startsWith("Test")), hasItem(endsWith("r"))));

        assertThat(myListofStrings, hasItem(containsString("T")));

        assertThat(myEmptyList, hasSize(greaterThan(0)));
        assertThat(myEmptyList, not(hasSize(0)));
*/

    }
}
