import java.util.ArrayList;

public class CoorPiecePlateau {
	
	
	static int coor[][] = new int[7][2];
	int x;
	int y;
	
	public CoorPiecePlateau(int x, int y) {
		this.x=x;
		this.y=y;
		
		for(int i=0; i<coor.length;i++) {
			for(int j=0; j<2;j++) {
				if(j==0) {
					coor[i][j]=x;
				}
				else {
					coor[i][j]=y;
				}	
			}
		}
	}
	
	/*public static int ifexist() {
		
	}*/
	
	public static int[][] getcollect() {
		return coor;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CoorPiecePlateau(5, 2);
		for(int i=0; i<coor.length;i++) {
			for(int j=0; j<2;j++) {
				System.out.println(coor[i][j]);
			}
			System.out.println(" ");
	}
	
	}
}