package com.example.usuario.two_cheerful_roads;

public class NutricionQuiz_1 {
    private String pregunta;
    private String posib1;
    private String posib2;
    private String posib3;
    private String posib4;
    private String answer;

    public NutricionQuiz_1() {}

    public NutricionQuiz_1(String pregunta, String posib1, String posib2, String posib3, String posib4, String answer){
            this.pregunta = pregunta;
            this.posib1 = posib1;
            this.posib2 = posib2;
            this.posib3 = posib3;
            this.posib4 = posib4;
            this.answer = answer;
        }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getPosib1() {
        return posib1;
    }

    public void setPosib1(String posib1) {
        this.posib1 = posib1;
    }

    public String getPosib2() {
        return posib2;
    }

    public void setPosib2(String posib2) {
        this.posib2 = posib2;
    }

    public String getPosib3() {
        return posib3;
    }

    public void setPosib3(String posib3) {
        this.posib3 = posib3;
    }

    public String getPosib4() {
        return posib4;
    }

    public void setPosib4(String posib4) {
        this.posib4 = posib4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
