package search;

public class binarySearch {
    private binarySearch(){}

    public static Integer bsearch(Integer[] arr, Integer n){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if ( arr[mid] > n){
                high = mid - 1;
            } else if (arr[mid] < n){
                low = mid + 1;
            }else {
                if (mid == arr.length - 1 || arr[mid + 1] > n){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于指定值的元素索引
     * @param arr
     * @param n
     * @return
     */
    public static int bsearchBiggerEqual(Integer[] arr, Integer n){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < n){
                low = mid + 1;
            }else {
                if (mid == arr.length - 1 || arr[mid - 1] < n){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }

    public static int bsearchLastSmallerEqual(Integer[] arr, Integer n){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= n){
                if (mid == arr.length - 1 || arr[mid + 1] > n){
                    return mid;
                }else {
                    low = mid + 1;
                }

            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 4, 5, 6, 6, 7, 9, 11};
        System.out.println(bsearch(arr, 6));
        System.out.println(bsearch(arr, 4));
        System.out.println(bsearchBiggerEqual(arr, 10));
        System.out.println(bsearchBiggerEqual(arr, 10));
    }
}
