package datastructure.list;

public class ListMain {
    private static void printArrayList(MyArrayList list){
        System.out.println("\n----------------------------------------");
        for(int i = 0 ; i < list.length; i++){
            System.out.print(list.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        int[] array = {66, 33, 99, 55, 88, 22, 24, 77};

        //ArrayListExample Test
        MyArrayList arrayList = new MyArrayList(array.length);
        for (int i1 : array) {
            arrayList.add(i1);
        }
        printArrayList(arrayList);

        arrayList.add(18);      //마지막에 18 추가
        printArrayList(arrayList);

        arrayList.add(3, 1);    //3번째 자리에 1 추가
        printArrayList(arrayList);

        arrayList.remove();     //마지막 데이터 삭제
        printArrayList(arrayList);

        arrayList.remove(3);    //3번째 데이터 삭제
        printArrayList(arrayList);
    }
}
