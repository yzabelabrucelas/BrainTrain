package com.example.franchette.braintrain;

import java.util.Random;

/**
 * Created by Franchette on 3/12/2018.
 */

class Anagram
{
    public static final Random RANDOM = new Random();
    public static final String[] WORDS =
            {
                    "CHECKBOX", "SPINNER","BUTTON", "PICKER", "SWITCH",
            "NOTIFICATION", "TOAST","DIALOG","ACTIVITY","SERVICE","EDITTEXT","RATINGBAR","CONTEXT","FRAGMENT"
            };

    public static String randomWord()
    {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    public static String shuffleWord(String word)
    {
        if (word != null  &&  !"".equals(word))
        {
            char a[] = word.toCharArray();

            for (int i = 0; i < a.length; i++)
            {
                int j = RANDOM.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            return new String(a);
        }

        return word;
    }
}
