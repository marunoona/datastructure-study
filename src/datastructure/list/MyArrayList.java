package datastructure.list;

public class MyArrayList {
    final static int MAX_SIE = 100;
    private int[] data;
    int length;

    MyArrayList() {
        super();
        this.length = 0;
        data = new int[MAX_SIE];
    }

    MyArrayList(int size) {
        this.length = 0;
        data = new int[size];
    }

    void add(int data){
        int size = this.data.length;
        if(this.length == size)
            copyArray(data, size);
        else
            this.data[this.length] = data;
        this.length++;
    }
    /**
     * 배열의 특정 인덱스에 데이터를 추가
     * @param index
     * @param data
     */
    void add(int index, int data) {
        int size = this.data.length;
        if (this.length == size)
            copyArrayWithIndex(index, data, size);
        else {
            int i = this.length - 1;
            //배열의 인덱스를 중심으로 뒤로 한칸씩 이동
            while (i > index - 1) {
                this.data[i + 1] = this.data[i];
                i--;
            }
            this.data[index - 1] = data;
        }
        this.length++;
    }

    /**
     * 배열의 마지막 데이터 삭제
     */
    void remove() {
        if (this.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.data[this.length - 1] = 0;
        this.length--;
    }

    /**
     * 특정 인덱스의 데이터를 삭제
     *
     * @param index
     */
    void remove(int index) {
        if (this.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.data[index - 1] = 0;

        int i = index - 1;
        //삭제된 이후 데이터로 차례대로 지움
        while (i < this.length - 1) {
            this.data[i] = this.data[i + 1];
            i++;
        }
        this.length--;
    }

    /**
     * 배열 복사
     *
     * @param data
     * @param size
     */
    private void copyArray(int data, int size) {
        int newSize = size + 1;
        int[] newArray = new int[newSize];

        newArray[newSize - 1] = data;
        for (int i = 0; i < size; i++) {
            newArray[i] = this.data[i];
        }
        this.data = new int[newSize];

        for (int i = 0; i < newArray.length; i++) {
            this.data[i] = newArray[i];
        }
    }

    /**
     * 특정 인덱스 배열 복사
     * @param index
     * @param data
     * @param size
     */
    private void copyArrayWithIndex(int index, int data, int size) {
        int newSize = size + 1;
        int[] newArray = new int[newSize];

        newArray[index - 1] = data;

        //인덱스를 중심으로 이전 데이터 복사
        for (int i = 0; i < index - 1; i++) {
            newArray[i] = this.data[i];
        }

        //인덱스를 중심으로 이후 데이터 복사
        for (int i = newSize - 1; i > index - 1; i--) {
            newArray[i] = this.data[i - 1];
        }
        this.data = new int[newSize];

        for (int i = 0; i < newArray.length; i++) {
            this.data[i] = newArray[i];
        }
    }

    int get(int index){
        return this.data[index];
    }
}
