package Day_5_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;


/**
 * Created by george.gligor on 2/5/2015.
 */
public class Ex2_3_4Test {

    @Test (description = "Exercise 2 - String-uri")
    public void string(){

        String word = new String("Testing");
        String word1 = new String();

        assertTrue(word.contains("ing"), "False");
        assertTrue(word.contains("zet"), "False");

        Assert.assertEquals("Testing", word, "False");
        Assert.assertEquals("Test", word, "False");

        assertTrue(word.startsWith("Test"),"False");
        assertTrue(word.startsWith("est"),"False");

        assertTrue(word.endsWith("ing"),"False");
        assertTrue(word.endsWith("in"),"False");

        assertThat(word,isEmptyOrNullString());
        assertThat(word1,isEmptyOrNullString());

        assertThat(word, not(equalTo("kki")));
        assertThat(word, not(equalTo("Testing")));

        assertThat(word, equalTo("fdfd"));
        assertThat(word, equalTo("Testing"));

        assertThat(word, equalToIgnoringCase("Testing"));

        assertThat(word, equalToIgnoringWhiteSpace("kdjs ksjd"));

    }

    @Test (description = "Create a list of strings. Assert that:..")
    public void list(){


        List myListofStrings = new ArrayList<String>();
        List myEmptyList = new ArrayList<String>();

        myListofStrings.add("Testing");
        myListofStrings.add("T");
        myListofStrings.add("Test");
        myListofStrings.add("Ting");


        //the list contains $someItem.
       /* assertThat(myListofStrings, hasItem("Test"));
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
        assertThat(myEmptyList, not(hasSize(0)));*/


    }

    @Test (description = "Create a new HashMap. Assert that")
    public void map(){

        HashMap<Integer, String> hashMap= new HashMap<Integer, String>();

        hashMap.put(3, "diamante");
        hashMap.put(4, "briliante");
        hashMap.put(10, "rubine");

        assertThat(hashMap, hasKey(3));
        assertThat(hashMap, hasValue("rubine"));
        assertThat(hashMap, hasEntry(4,"briliante"));

        assertThat(hashMap, hasKey(1));
        assertThat(hashMap, hasValue("ubine"));
        assertThat(hashMap, hasEntry(2,"briliante"));

    }
}
