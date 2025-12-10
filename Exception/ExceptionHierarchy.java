package Exception;

public class ExceptionHierarchy {

    public static void main(String[] args) {

        try {
            int a = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
