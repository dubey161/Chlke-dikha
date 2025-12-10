package Exception;

public class CustomExceptionExample {

    static void checkMarks(int marks) throws MyException {
        if (marks < 40) {
            throw new MyException("Marks too low!");
        }
        System.out.println("Marks are good");
    }

    public static void main(String[] args) {
        try {
            checkMarks(30);
        } catch (MyException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }
    }
}
