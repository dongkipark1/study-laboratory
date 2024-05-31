package ex02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Annotation;

public class App {
    public static void main(String[] args) {
        String path = "/login";


        UserController uc = new UserController();
        Method[] methods = uc.getClass().getDeclaredMethods(); // 정의되어 있는 메서드를 전부 찾아준다. (로그인, 조인)

        for (Method method : methods) {
            //System.out.println(method.getName());

            Annotation anno = (Annotation) method.getDeclaredAnnotation(RequestMapping.class);
            RequestMapping rm = (RequestMapping) anno;

            if (rm.uri().equals(path)){
                try {
                    method.invoke(uc);
                } catch (Exception e) {
                    System.out.println("메서드 호출하다 오류남 : " + e.getMessage());
                }
            }
        }
    }
}
