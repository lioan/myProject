package cn.com.lioan.annotation;

import cn.com.lioan.testEnum.Color;

public class TestBasicAnnotation {

    @AnnotationSimple(value = "ID", name = "id", color = Color.BLUE)
    private Integer id;

    @AnnotationSimple(value = "NAME", name = "name", color = Color.BLACK)
    private String name;

    @AnnotationSimple("AGE")
    private Integer age;

    @AnnotationSimple("method:getId")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
