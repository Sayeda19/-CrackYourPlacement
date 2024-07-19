int removeDuplicates(int* nums, int numsSize) {
    int i;
    int k=1;
    int temp[numsSize];
    for(i=0;i<numsSize;i++)
    {
        temp[i]=nums[i];
    }
    for(i=1;i<numsSize;i++)
    {
        if(temp[i]!=temp[i-1]){
            nums[k]=temp[i];
            k++;
        }
    }
    return k;
}