class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0 ) return -1;
	    
	    Queue<int[]> q=new LinkedList<>();
	    q.add(new int[]{0,0});
	    int[][] dir={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
	    
	    int path=1;
	    int xlen=grid.length;
	    int ylen=grid[0].length;
	    int len=q.size();
	    grid[0][0]=1;
	    int c=0;
	    
	    while(!q.isEmpty()){
	        
	        int[] data=q.poll();
	            
	        int x=data[0];
	        int y=data[1];
	            
	        if(x==grid.length-1 && y==grid[0].length-1) return path;
	        
	           
	        for(int[] dat:dir){
	            int x1=x+dat[0];
	            int y1=y+dat[1];
	            if(x1<xlen && x1>=0 && y1<ylen && y1>=0 && grid[x1][y1]==0){
	                q.add(new int[]{x1,y1});
	                grid[x1][y1]=1;
	            }
	        }
	            
	            
	        c++;
	        if(c==len){
	            c=0;
	            path++;
	            len=q.size();
	            
	        }
	        
	       
	        
	    }
	    
	    return -1;
    }
}
