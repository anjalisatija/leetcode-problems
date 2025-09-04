class MinStack {
public:
    stack<pair<int,int>> st;

    MinStack() {}

    void push(int val) {
        if(st.empty()) {
            st.push({val, val});
        } else {
            int minval = min(val, st.top().second);
            st.push({val, minval});
        }
    }

    void pop() {
        st.pop();
    }

    int top() {
        return st.top().first;
    }

    int getMin() {
        return st.empty() ? -1 : st.top().second;
    }
};