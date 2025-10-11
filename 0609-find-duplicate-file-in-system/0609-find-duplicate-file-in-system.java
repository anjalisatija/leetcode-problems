class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>>map = new HashMap<>();
        for(String path : paths){
            String []parts = path.split(" ");
            String dir = parts[0];
            
            for(int i=1;i<parts.length;i++){
                String fileInfo = parts[i];
                int openTag = fileInfo.indexOf("(");
                int closeTag = fileInfo.indexOf(")");
                
                String fileName = fileInfo.substring(0,openTag);
                String content = fileInfo.substring(openTag+1,closeTag);

                String filePath = dir+"/"+fileName;

                map.putIfAbsent(content,new ArrayList<>());
                map.get(content).add(filePath);
                    }
                }  
                List<List<String>>list = new ArrayList<>();
                for(List<String>result : map.values()){
                    if(result.size()>1){
                        list.add(result);
                             
            }
        }
        return list;
    }
}