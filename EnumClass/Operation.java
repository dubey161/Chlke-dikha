package EnumClass;
//public enum Operation {
//    ADD {
//        public int apply(int a, int b) { return a + b; }
//        public void hello() { System.out.println("ADD"); }
//    },
//    SUBTRACT {
//        public int apply(int a, int b) { return a - b; }
//        public void hello() { System.out.println("SUBTRACT"); }
//    },
//    MULTIPLY {
//        public int apply(int a, int b) { return a * b; }
//        public void hello() { System.out.println("MULTIPLY"); }
//    },
//    DIVIDE {
//        public int apply(int a, int b) { return a / b; }
//        public void hello() { System.out.println("DIVIDE"); }
//    };
//
//    public abstract int apply(int a, int b);
//    public abstract void hello();
//}

public enum Operation {
    ADD {
        public int apply(int a, int b) { return a + b; }
    },
    SUBTRACT {
        public int apply(int a, int b) { return a - b; }
    },
    MULTIPLY {
        public int apply(int a, int b) { return a * b; }
        @Override
        public void hello() {
            System.out.println("Hello from MULTIPLY");
        }
    },
    DIVIDE {
        public int apply(int a, int b) { return a / b; }
        @Override
        public void hello() {
            System.out.println("Hello from DIVIDE");
        }
    };

    public abstract int apply(int a, int b);

    // default implementation
    public void hello() {
        System.out.println("Hello from Generic");
    }
}
