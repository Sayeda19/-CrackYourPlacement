void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int j=0,i,temp[nums1Size];
    for(i=0;i<m;i++)
    {
       
            temp[j]=nums1[i];
            j++;
        
        
    }
    for(i=0;i<n;i++)
    {
        temp[j]=nums2[i];
        j++;
    }
    int tempp;
    for (i = 0; i < nums1Size - 1; i++) {
        for (j = 0; j < nums1Size - i - 1; j++) {
            if (temp[j] > temp[j + 1]) {
                int tempp = temp[j];
                temp[j] = temp[j + 1];
                temp[j + 1] = tempp;
            }
        }
    }
    
    for(i=0;i<nums1Size;i++)
    {
        nums1[i]=temp[i];
    }
}