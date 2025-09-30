class Solution {
public:
    #define ll long long
    ll getlimit(ll x){
        ll p = ceil((double)18.0 / (double)x);
        ll ans = 1LL;
        while(p--){
            ans *= 10LL;
        }
        return ans;
    }
    string smallestGoodBase(string n) {
        ios_base::sync_with_stdio(0);
        ll N = stoll(n), k = (ll)log2((long double)N) + 1, ans = N-1LL;
        for(ll i = 2; i <= k; i++){
            ll start = 2LL, end = getlimit(i), mid, answ = -1LL;
            while(start <= end){
                mid = start + (end - start) / 2;
                ll val = N-1, prod = 1LL, mult = mid, j = i;
                while(j--){
                    if(val / prod >= mult){
                        val = val - (prod * mult);
                    }
                    else{
                        val = -1;
                        break;
                    }
                    prod *= mult;
                }
                if(val <= 0){
                    if(val == 0){
                        answ = mid;
                    }
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            if(answ != -1){
                ans = min(ans, answ);
            }
        }
        return to_string(ans);
    }
};