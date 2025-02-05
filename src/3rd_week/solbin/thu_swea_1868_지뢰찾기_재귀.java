import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution
{
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char[][] arr;
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
	static int[] dy = {1,1,1,0,0,-1,-1,-1};
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++) {
            System.out.print("#" + t + " ");
            int sum = 0;
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            for (int i=0;i<n;i++) {
            	arr[i] = br.readLine().toCharArray();
            }
            
            // 지뢰와 인접하지 않은곳을 클릭해서 모두 연다
            for (int i=0;i<n;i++) {
            	for (int j=0;j<n;j++) {
            		if (!isNear(i,j) && arr[i][j] == '.') {
            			click(i,j);
            			sum++;
            		}
            	}
            }
            
            // 지뢰와 인접하면서 열리지 않은곳을 센다
            for (int i=0;i<n;i++) {
            	for (int j=0;j<n;j++) {
            		if (isNear(i,j) && arr[i][j] == '.') {
            			sum++;
            		}
            	}
            }
            
            System.out.println(sum);
        }
    }
    
    static void click(int a,int b) {
    	arr[a][b] = 'O';
    	if (!isNear(a,b)) {
    		for (int i=0;i<8;i++) {
        		int x = a+dx[i];
        		int y = b+dy[i];
        		if (bound(x,y) && arr[x][y]!='O') {
        			click(x,y);
        		}
        	}
    	}
    }
    
    static boolean isNear(int a, int b) {
    	boolean hasMine = false;
    	for (int i=0;i<8;i++) {
    		int x = a+dx[i];
    		int y = b+dy[i];
    		if (bound(x,y) && arr[x][y]=='*') {
    			hasMine = true;
    			break;
    		}
    	}
    	return hasMine;
    }
    
    static boolean bound(int x, int y) {
    	if (x<0||x>=n||y<0||y>=n) {
    		return false;
    	} else {
    		return true;
    	}
    }
}