package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AnswerCode implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor){
        return SerenityRest.lastResponse().statusCode();
    }

    public static AnswerCode answerCode(){
        return new AnswerCode();
    }

}
