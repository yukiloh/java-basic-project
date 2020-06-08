package com.example.javase.Annotation.AnnoCheckCase;

public class MethodNeedCheck {

    @CheckAnno
    public void a(){        System.out.println("1+1=  "+(1+1));    }
    @CheckAnno
    public void b(){        System.out.println("1-1=  "+(1-1));    }
    @CheckAnno
    public void c(){        System.out.println("1+1=  "+1*1);    }
    @CheckAnno
    public void d(){        System.out.println("1+1=  "+1/0);    }
}
