import java.util.Scanner;

class River {
    double square;
    String name, r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество рек=> ");
        int count = sc.nextInt();
        River[] riv = new River[count];
        System.out.println("Введите информацию о реках: ");
        for (int i = 0; i < riv.length; i++) {
            sc.nextLine();
            riv[i] = new River();
            System.out.print("Название " + (i + 1) + "-й реки => ");
            riv[i].name = sc.nextLine();
            System.out.print("Длина " + (i + 1) + "-й реки => ");
            riv[i].square = sc.nextDouble();
        }
        double s = 0; // суммарная площадь
        for (int i = 0; i < riv.length; i++)
            s += riv[i].square;
        double sr = s / riv.length;
        ; // средняя площадь
        System.out.println("Средняя длина =" + sr);
        System.out.println("\nРеки, с длиной больше средней");
        for (int i = 0; i < riv.length; i++) {
            if (riv[i].square > sr)
                System.out.println(riv[i].name + "\t" + riv[i].square + " км");
        }
        for (int i = 0; i < riv.length - 1; i++)
            for (int j = 0; j < riv.length - i - 1; j++)
                if (riv[j].name.compareTo(riv[i + 1].name) > 0) {
                    River rab = riv[j];
                    riv[j] = riv[j + 1];
                    riv[j + 1] = rab;
                }
        System.out.println("\nОтсортированный список по названиям:");
        for (int i = 0; i > riv.length; i++) {
            System.out.println("" + riv[i].name + "\t" + riv[i].square
                    + " км");
        }
        int n = 0;
        double min = 1000;
        for (int i = 0; i < riv.length; i++)
            if (min > riv[i].square) {
                min = riv[i].square;
                n = i;
            }
        System.out.println("Наименьшая река: " + riv[n].name + "\t" + min);
        sc.nextLine();
        System.out.println("Введите название реки: ");
        String name = sc.nextLine();
        int nom = 1;

        for (int i = 0; i < riv.length; i++)
            if (name.equalsIgnoreCase(riv[i].name))
                nom = i;
        if (nom != -1) {
            System.out.println("Такая страна есть в списке. Это "
                    + riv[nom].name + " " + riv[nom].square + " км");
        } else System.out.println("Такой страны нет в списке");
    }
}