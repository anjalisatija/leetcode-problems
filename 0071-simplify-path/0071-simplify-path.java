class Solution {
    /*
        . : Current directory
        .. : Parent directory
        // : /
        /// : /
        ... : Valid file name or directory
        .... / or above : Valid file name or directory
        Path should start with a single slash '/'.
        Directories within the path must be separated by exactly one slash '/'.
        The path must not end with a slash '/', unless it is the root 
        directory.
        The path must not have any single or double periods 
        ('.' and '..') used to denote current or parent directories.
    */
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String s : str) {
            if(s.isEmpty() || s.equals(".")) {
                continue;
            }
            if(s.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(s);
            }
        }

        if(stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append("/").append(s);
        }

        return sb.toString();
    }
}