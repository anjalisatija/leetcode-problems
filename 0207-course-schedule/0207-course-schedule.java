class Solution {
    public boolean isCyclic(HashMap<Integer,ArrayList<Integer>> h1,int n)
    {
      int count=0;
        int indegree[]=new int[n];
        for(int i=0;i<n;i++)
        indegree[i]=0;
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> l3=h1.get(i);
            for(int j=0;j<l3.size();j++)
            indegree[l3.get(j)]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            q.add(i);
        }
        while(!q.isEmpty())
        {
            int U=q.remove();
            count++;
            ArrayList<Integer> l4=h1.get(U);
            for(int i=0;i<l4.size();i++)
            {
                indegree[l4.get(i)]--;
                if(indegree[l4.get(i)]==0)
                {
                    q.add(l4.get(i));
            
                }
            }
        }
        return count==n;


    }
    public boolean canFinish(int numCourses, int[][] A) {
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<>();
        for(int i=0;i<numCourses;i++)
        {
            ArrayList<Integer> l1=new ArrayList<>();
            h1.put(i,l1);
        }
        for(int i=0;i<A.length;i++)
        {
            int U=A[i][0];
            int V=A[i][1];
            ArrayList<Integer> l2=h1.get(U);
            l2.add(V);
            h1.put(U,l2);
        }
        return isCyclic(h1,numCourses);
    }
}