package lombok;

import lombok.ToString;

@ToString(exclude = "marks", includeFieldNames = true)
public class Student {

    private String name;
    private int rollNo;
    private int marks;
}
