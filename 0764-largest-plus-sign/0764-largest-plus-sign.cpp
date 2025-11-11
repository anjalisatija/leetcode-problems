class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        vector<vector<int>>up(n, vector<int>(n));
         vector<vector<int>>down(n, vector<int>(n));
          vector<vector<int>>left(n, vector<int>(n));
           vector<vector<int>>right(n, vector<int>(n));
           vector<vector<int>>v(n, vector<int>(n,1));
           int maxi=0;
           for(int i=0; i<mines.size(); i++)
           {
               v[mines[i][0]][mines[i][1]]=0;
           }
           int count=0;
           for(int i=0; i<n; i++)
           {
             count=0;

               for(int j=0; j<n; j++)
               {
                   if(v[i][j]==1)
                   {
                       count++;
                       left[i][j]=count;
                   }
                   else count=0;
               }
           }



             for(int i=0; i<n; i++)
           {
             count=0;

               for(int j=n-1; j>=0; j--)
               {
                   if(v[i][j]==1)
                   {
                       count++;
                       right[i][j]=count;
                   }
                   else count=0;
               }
           }



  for(int i=0; i<n; i++)
           {
             count=0;

               for(int j=0; j<n; j++)
               {
                   if(v[j][i]==1)
                   {
                       count++;
                       up[j][i]=count;
                   }
                   else count=0;
               }
           }





  for(int i=0; i<n; i++)
           {
             count=0;

               for(int j=n-1; j>=0; j--)
               {
                   if(v[j][i]==1)
                   {
                       count++;
                       down[j][i]=count;
                   }
                   else count=0;
               }
           }



           for(int i=0; i<n; i++)
           {
               for(int j=0; j<n; j++)
               {
                      if(v[i][j]==1)
                      {
                          int order=min({ left[i][j] , right[i][j] , up[i][j] , down[i][j]});
                          maxi=max(maxi,order);
                      }
               }
           }
      return maxi;

    }
};