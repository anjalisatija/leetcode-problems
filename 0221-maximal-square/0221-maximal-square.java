class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int[][] prefix = new int[m][n];

        for(int j=0;j<m;j++){
            int count=0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='1')
                count++;
                prefix[j][i]=count;
            }
        }

        
        int left=0,right=Math.min(n,m),mid,ans=0;
        while(left<=right){
            mid = (left+right)/2;
            boolean flag = false;
            int count_req = mid*mid;

            for(int i=0;i<=(n-mid);i++){
                int count=0;
                for(int j=0;j<mid;j++){
                    if(i==0)
                    count += prefix[j][i+mid-1];
                    else count += (prefix[j][i+mid-1]-prefix[j][i-1]);
                }

                if(count==count_req){
                    flag = true;
                    break;
                }

                for(int j=1;j<=(m-mid);j++){
                    if(i==0)
                    count -= prefix[j-1][i+mid-1];
                    else count -= (prefix[j-1][i+mid-1]-prefix[j-1][i-1]);

                    if(i==0)
                    count += (prefix[j+mid-1][i+mid-1]);
                    else count += (prefix[j+mid-1][i+mid-1]-prefix[j+mid-1][i-1]);

                    if(count==count_req){
                        flag = true;
                        break;
                    }
                }

                if(flag)
                break;
            }

            if(flag){
                ans = mid;
                left = mid+1;
            }else right = mid-1;
        }

        return(ans*ans);
    }
}