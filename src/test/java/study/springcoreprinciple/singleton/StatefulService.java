package study.springcoreprinciple.singleton;



public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제
    }

    // price를 Thread간 공유되는 영역이 아닌 지역변수로 이동하여 문제 해결
//    public int order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
////        this.price = price; // 여기가 문제
//        return price;
//    }

    public int getPrice() {
        return price;
    }
}
