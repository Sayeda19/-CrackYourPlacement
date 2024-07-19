void sortColors(int* nums, int numsSize) {
    int i,j,min,temp;
    for(i=0;i<numsSize-1;i++)
    {
        min=i;
        for(j=i;j<numsSize;j++)
        {
            if(nums[min]>nums[j])
            {
                min=j;
            }
        }
        if(min!=i)
        {
            temp=nums[i];
            nums[i]=nums[min];
            nums[min]=temp;
        }
    }
}