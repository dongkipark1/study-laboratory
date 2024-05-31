package ex03;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // JVM 실행시 확인해야한다
public @interface RequestMapping {
    String uri(); // value()는 키값이 생략 가능하다.
}
