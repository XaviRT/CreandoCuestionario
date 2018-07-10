package com.example.usuario.two_cheerful_roads;

import java.util.ArrayList;
import java.util.List;

public class NutricionQuiz_1 {
    public ArrayList<String> pregunta;
    public ArrayList<String> choice1;
    public ArrayList<String> posib2;
    public ArrayList<String> posib3;
    public ArrayList<String> posib4;
    public ArrayList<String> answer;

    public NutricionQuiz_1() {
    }

    public NutricionQuiz_1(ArrayList<String> pregunta, ArrayList<String> choice1, ArrayList<String> posib2, ArrayList<String> posib3, ArrayList<String> posib4, ArrayList<String> answer) {
        this.pregunta = pregunta;
        this.choice1 = choice1;
        this.posib2 = posib2;
        this.posib3 = posib3;
        this.posib4 = posib4;
        this.answer = answer;
    }

    public List getPregunta() {
        return pregunta;
    }

    public void setPregunta(ArrayList<String> pregunta) {
        this.pregunta = pregunta;
    }

    public List getChoice1() {
        return choice1;
    }

    public void setChoice1(ArrayList<String> choice1) {
        this.choice1 = choice1;
    }

    public List getPosib2() {
        return posib2;
    }

    public void setPosib2(ArrayList<String> posib2) {
        this.posib2 = posib2;
    }

    public List getPosib3() {
        return posib3;
    }

    public void setPosib3(ArrayList<String> posib3) {
        this.posib3 = posib3;
    }

    public List getPosib4() {
        return posib4;
    }

    public void setPosib4(ArrayList<String> posib4) {
        this.posib4 = posib4;
    }

    public List getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }
}

