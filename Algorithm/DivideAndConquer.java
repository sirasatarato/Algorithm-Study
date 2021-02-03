class DivideAndConquer {
    public static int fastSum(int num) {
        if (num == 1) return 1;
        if (num % 2 == 1) return fastSum(num - 1) + num;
        return 2 * fastSum(num / 2) + (num / 2) * (num / 2);
    }

    public static int normalSum(int num) {
        int sum = 0;
        for (int i = num; i > 0; i--) {
            sum += i;
        }

        return sum;
    }

    public static int realFastSum(int num) {
        if(num % 2 == 0){
            return (num + 1) * (num / 2);
        }else{
            return num * ((num - 1) / 2) + num;
        }
    }

    public static void main(String[] args) {
        System.out.println(fastSum(444));
    }
}