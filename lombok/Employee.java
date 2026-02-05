package lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = "department")
public class Employee {

    private int id;
    private String name;
    private String department;
}
