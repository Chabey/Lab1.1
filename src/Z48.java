public class Z48 {
    public static class Except1{
        public static int m(){
            try {
                System.out.println("0");
                throw new RuntimeException("Error");
            } finally {
                System.out.println("1");
            } }
        public static void main(String[] args) {
            System.out.println(m());
        }
    }
}
