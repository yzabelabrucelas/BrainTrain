package com.example.franchette.braintrain;

/**
 * Created by Franchette on 3/15/2018.
 */

public class Question
{
    private int pictureID;
  //  private String questionText;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;

    private String correctAnswer;
    private boolean creditAlreadyGiven;

    public Question(int pictureID, String choiceA, String choiceB, String choiceC,String choiceD, String correctAnswer)
    {
        this.pictureID = pictureID;
       // this.questionText = questionText;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.correctAnswer = correctAnswer;
        this.creditAlreadyGiven = false;
    }


    public int getPictureID()
    {
        return pictureID;
    }

    public void setPictureID(int pictureID)
    {
        this.pictureID = pictureID;
    }

    /*public String getQuestionText()
    {
        return questionText;
    }

    public void setQuestionText(String questionText)
    {
        this.questionText = questionText;
    }
*/
    public String getChoiceA()
    {
        return choiceA;
    }

    public void setChoiceA(String choiceA)
    {
        this.choiceA = choiceA;
    }

    public String getChoiceB()
    {
        return choiceB;
    }

    public void setChoiceB(String choiceB)
    {
        this.choiceB = choiceB;
    }

    public String getChoiceC()
    {
        return choiceC;
    }

    public void setChoiceC(String choiceC)
    {
        this.choiceC = choiceC;
    }

    public String getChoiceD()
    {
        return choiceD;
    }

    public void setChoiceD(String choiceC)
    {
        this.choiceC = choiceD;
    }


    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }

    public boolean isCreditAlreadyGiven()
    {
        return creditAlreadyGiven;
    }

    public void setCreditAlreadyGiven(boolean creditAlreadyGiven)
    {
        this.creditAlreadyGiven = creditAlreadyGiven;
    }


    public boolean isCorrectAnswer(String selectedAnswer)
    {
        return (selectedAnswer.equals(correctAnswer));
    }


/*
    @Override
    public String toString()
    {
        return questionText;

    }
    */
}
