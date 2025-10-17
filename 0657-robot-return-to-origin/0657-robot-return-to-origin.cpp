class Solution {
public:
    bool judgeCircle(string m) {
        int x=0,y=0;
        for(int i=0;i<m.size();i++)
            switch(m[i])
            {   case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                default:
                    y--;    
            }
        if(x==0 && y==0)
            return true;
        return false;
    }
};