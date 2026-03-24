public static boolean helper(int idx, int[] arr, int target){
    if(target == 0) return true;
    if(idx == 0) return arr[0] == target;
    
    // take
    boolean take = false;
    if(arr[idx] <= target) take = helper(idx - 1, arr, target - arr[idx]);
    
    // not-take
    boolean notTake = helper(idx - 1, arr, target);
    
    return take || notTake;
}
