package InterfaceAndImmutable;

interface Calc {
    int add(int a, int b);
    int subtract(int a, int b);

    default int multiplyByTwo(int a) {
        return a * 2;
    }
}
